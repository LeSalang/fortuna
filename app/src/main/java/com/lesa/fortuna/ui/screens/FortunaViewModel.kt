package com.lesa.fortuna.ui.screens

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.lesa.fortuna.R
import com.lesa.fortuna.utils.HelmParams
import com.lesa.fortuna.utils.SortsOfShawarma
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class FortunaViewModel(): ViewModel() {
    val rotationValue = mutableFloatStateOf(0f)
    val listOfShawarma = SortsOfShawarma.entries.toMutableList()
    val numberOfVariants = listOfShawarma.size - 1
    val centralShawarma = mutableStateOf(listOfShawarma.last())
    private var sound1 = MediaPlayer()
    private var sound2 = MediaPlayer()

    fun createSound(context: Context) {
        sound1 = MediaPlayer.create(context, R.raw.orkestr_barabannyiy_perezvon)
        sound2 = MediaPlayer.create(context, R.raw.povezlo_povezlo)
    }

    private var randomValueOfTurn = 0
    private var newPositionOfTurn = 0

    fun getHelmParams(boxWithConstraintsScope: BoxWithConstraintsScope): HelmParams {
        val boxWidth = boxWithConstraintsScope.maxWidth.value
        val boxHeight = boxWithConstraintsScope.maxHeight.value
        val boxSize = min(boxHeight, boxWidth)
        val boxCenter = boxSize / 2f
        val helmRadius = boxSize / 3.2f
        val centralCircleSize = boxSize / 3f
        val centralCircleStartPoint = (boxSize - centralCircleSize) / 2f
        val smallCircleSize = boxSize / 4.5f
        val smallCircleOffset = boxCenter - smallCircleSize / 2
        val smallCircleOffsetList = mutableListOf<Pair<Dp, Dp>>()
        for (i in 0..7) {
            val angle = PI / 4 * i
            val x = (helmRadius * cos(angle) + smallCircleOffset).dp
            val y = (helmRadius * sin(angle) + smallCircleOffset).dp
            smallCircleOffsetList.add(Pair(x, y))
        }
        return HelmParams(
            helmSize = boxSize.dp,
            helmCenter = boxCenter.dp,
            centralCircleOffset = centralCircleStartPoint.dp,
            centralCircleSize = centralCircleSize.dp,
            smallCircleOffsetList = smallCircleOffsetList,
            smallCircleSize = smallCircleSize.dp
        )
    }

    fun rotateHelm(animateStep: Float) {

        CoroutineScope(Dispatchers.IO).launch {
            //sound1.start()
            getRandomValueOfTurn()
            getNewPosition()
            rotationValue.floatValue = randomValueOfTurn * 45f + animateStep
            delay(3800L)
            //sound1.pause()
            sound2.start()
            replaceCircle(newPositionOfTurn)
            delay(2500L)
            sound2.pause()
        }


    }

    private fun getRandomValueOfTurn() {
        randomValueOfTurn = (10..20).random()
    }

    private fun getNewPosition() {
        val shift = randomValueOfTurn % numberOfVariants
        val finalShift = (newPositionOfTurn - shift)
        newPositionOfTurn = if (finalShift < 0) {
            8 + finalShift
        } else {
            finalShift
        }
    }

    private fun replaceCircle(newPositionOfTurn: Int) {
        val oldIndex = listOfShawarma.indexOf(centralShawarma.value)
        val correctShift = newPositionOfTurn - 2
        val newIndex = if (correctShift < 0) {
            8 + correctShift
        } else {
            correctShift
        }
        val oldCentralShawarma = centralShawarma.value
        val newCentralShawarma = listOfShawarma[newIndex]
        listOfShawarma[oldIndex] = newCentralShawarma
        listOfShawarma[newIndex] = oldCentralShawarma
        centralShawarma.value = newCentralShawarma
    }
}