package com.lesa.fortuna.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.lesa.fortuna.R
import com.lesa.fortuna.utils.SortsOfShawarma

@Composable
fun Helm(
    vm: FortunaViewModel,
    listOfShawarma: List<SortsOfShawarma>,
    modifier: Modifier,
    angle: Float
) {
    BoxWithConstraints(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        val boxScope = this
        val helmParams = vm.getHelmParams(boxScope)
        Box(
            modifier = Modifier
                .size(helmParams.helmSize)
                .rotate(angle)
        ) {
            Image(
                painter = painterResource(id = R.drawable.helm),
                contentDescription = stringResource(id = R.string.helm),
                modifier = Modifier
                    .fillMaxSize()
            )
            Image(
                painter = painterResource(id = vm.centralShawarma.value.sort.logo),
                contentDescription = stringResource(id = vm.centralShawarma.value.sort.name),
                modifier = Modifier
                    .offset(
                        x = helmParams.centralCircleOffset,
                        y = helmParams.centralCircleOffset
                    )
                    .size(helmParams.centralCircleSize)
                    .clip(CircleShape)
                    .background(Color.White)
                    .rotate(-angle)
            )
            helmParams.smallCircleOffsetList.forEachIndexed { i, coordinate ->
                SmallCircle(
                    image = listOfShawarma[i].sort.logo,
                    size = helmParams.smallCircleSize,
                    x = coordinate.first,
                    y = coordinate.second,
                    color = Color.White,
                    angle = 90f + 45f*i
                )
            }
        }


    }
}

@Composable
fun SmallCircle(
    image: Int,
    size: Dp,
    x: Dp,
    y: Dp,
    color: Color,
    angle: Float
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "",
        modifier = Modifier
            .size(size)
            .offset(
                x = x,
                y = y
            )
            .clip(CircleShape)
            .background(color)
            .rotate(angle)
            .clickable { }
    )

}