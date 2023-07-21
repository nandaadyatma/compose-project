package com.example.artspace.ui.theme

import androidx.compose.ui.graphics.painter.Painter

data class Art(
    val image: Painter,
    val title: String,
    val artist: String,
    val year: String
)