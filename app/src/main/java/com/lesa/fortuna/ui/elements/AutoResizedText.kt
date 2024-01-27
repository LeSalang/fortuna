package com.lesa.fortuna.ui.elements

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.isUnspecified

@Composable
fun AutoResizedText(
    text: String,
    color: Color = Color.Black,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    style: TextStyle = MaterialTheme.typography.titleLarge,
) {
    var multiplier by remember {
        mutableFloatStateOf(1f)
    }
    var shouldDraw by remember {
        mutableStateOf(false)
    }
    Text(
        text = text,
        color = color,
        maxLines = 1,
        overflow = TextOverflow.Visible,
        style = style,
        fontSize = style.fontSize * multiplier,
        textAlign = textAlign,
        onTextLayout = {
            if (it.hasVisualOverflow) {
                multiplier *= 0.9f
            } else {
                shouldDraw = true
            }
        },
        modifier = modifier
            .drawWithContent {
                if (shouldDraw) {
                    drawContent()
                }
            }
    )
    /*var resizedTextStyle by remember {
        mutableStateOf(style)
    }
    val defaultFontSize = MaterialTheme.typography.titleLarge.fontSize
    var shouldDraw by remember {
        mutableStateOf(false)
    }
    Text(
        text = text,
        color = color,
        modifier = modifier
            .drawWithContent {
                if (shouldDraw) {
                    drawContent()
                }
            },
        softWrap = false,
        onTextLayout = {result ->
            if (result.didOverflowWidth) {
                if (style.fontSize.isUnspecified) {
                    resizedTextStyle = resizedTextStyle.copy(
                        fontSize = defaultFontSize
                    )
                }
                resizedTextStyle = resizedTextStyle.copy(
                    fontSize = resizedTextStyle.fontSize * 0.95
                )
            } else {
                shouldDraw = true
            }
        }
    )*/
}