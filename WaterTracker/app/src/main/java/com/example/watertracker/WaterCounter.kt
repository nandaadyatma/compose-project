package com.example.watertracker

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    Text(
        text = "You have had ${count}glasses.",
        modifier = modifier.padding(16.dp)
    )
    Spacer(modifier = Modifier.height(10.dp))
    Button(onClick = { count++ }, modifier = Modifier.padding(top = 8.dp)) {
        Text(text = "Add one")
    }
}