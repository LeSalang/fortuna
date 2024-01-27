package com.lesa.fortuna.utils

import androidx.compose.ui.unit.Dp

data class HelmParams(
    val helmSize: Dp,
    val helmCenter: Dp,
    val centralCircleOffset: Dp,
    val centralCircleSize: Dp,
    val smallCircleOffsetList: MutableList<Pair<Dp, Dp>>,
    val smallCircleSize: Dp
)