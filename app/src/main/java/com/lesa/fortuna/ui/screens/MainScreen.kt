package com.lesa.fortuna.ui.screens

import android.content.Context
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.lesa.fortuna.R
import com.lesa.fortuna.ui.elements.AutoResizedText
import com.lesa.fortuna.ui.theme.fortunaFontFamily

@Composable
fun MainScreen(
    viewModel: FortunaViewModel,
    context: Context
) {
    val rotationValue = viewModel.rotationValue.floatValue
    val angle: Float by animateFloatAsState(
        targetValue = rotationValue,
        animationSpec = tween(
            durationMillis = 3500,
            easing = FastOutSlowInEasing
        ),
        label = ""
    )
    //viewModel.createSound(context)
    Column(
        modifier = Modifier
            .padding(vertical = 60.dp, horizontal = 20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AutoResizedText(
            text = stringResource(id = R.string.fortuna).uppercase(),
            modifier = Modifier
                .fillMaxWidth(),
                //.size(200.dp)
               // .background(Color.White),
            style = MaterialTheme.typography.titleLarge
        )
        Helm(
            vm = viewModel,
            listOfShawarma = viewModel.listOfShawarma,
            modifier = Modifier
                .weight(1f),
            angle = angle
        )
        Button(
            onClick = {
               // viewModel.playSound()
                viewModel.rotateHelm(angle)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            modifier = Modifier

        ) {
            AutoResizedText(
                text = stringResource(id = R.string.turn_the_wheel),
                color = Color.White,
                style = MaterialTheme.typography.labelSmall
            )
        }


    }
}