package com.lesa.fortuna.utils

import com.lesa.fortuna.R

enum class SortsOfShawarma(val sort: SortOfShawarma) {
    CHEESE(SortOfShawarma(
        name = R.string.taste_cheese,
        logo = R.drawable.taste_small_cheese)),
    KIWI(SortOfShawarma(
        name = R.string.taste_kiwi,
        logo = R.drawable.taste_small_kiwi)),
    MEXICAN(SortOfShawarma(
        name = R.string.taste_mexican,
        logo = R.drawable.taste_small_mexican)),
    MUSHROOM(SortOfShawarma(
        name = R.string.taste_mushroom,
        logo = R.drawable.taste_small_mushroom)),
    PINEAPPLE(SortOfShawarma(
        name = R.string.taste_pirate,
        logo = R.drawable.taste_small_pineapple)),
    PIRATE(SortOfShawarma(
        name = R.string.taste_pirate,
        logo = R.drawable.taste_small_pirate)),
    POMEGRANATE(SortOfShawarma(
        name = R.string.taste_pomegranate,
        logo = R.drawable.taste_small_pomegranate)),
    SHRIMP(SortOfShawarma(
        name = R.string.taste_shrimp,
        logo = R.drawable.taste_small_shrimp)),
    STANDARD(SortOfShawarma(
        name = R.string.taste_standard,
        logo = R.drawable.taste_small_standard))
}

data class SortOfShawarma(
    val name: Int,
    val logo: Int
)