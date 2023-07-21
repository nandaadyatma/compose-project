package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.Art
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)) {
        CardImage()
    }
}

@Composable
fun CardImage(

) {
    val arts = listOf(
        Art(
            image = painterResource(id = R.drawable.pic1),
            title = "Mountain & Grass",
            artist = "Mono Spacer",
            year = "2022"
        ),
        Art(
            image = painterResource(id = R.drawable.pic2),
            title = "The Great Cliff",
            artist = "La Rod",
            year = "2023"
        ),
        Art(
            image = painterResource(id = R.drawable.pic3),
            title = "Green Rice Field",
            artist = "Budiono",
            year = "2019"
        ),
        Art(
            image = painterResource(id = R.drawable.pic4),
            title = "Into the Woods",
            artist = "Sabake Kaoma",
            year = "2021"
        ),
        Art(
            image = painterResource(id = R.drawable.pic5),
            title = "Winter Lake",
            artist = "Sophia Lilis",
            year = "2023"
        ),
    )

    // State untuk mengelola currentIndex
    var currentIndex by remember { mutableStateOf(0) }

    currentIndex = currentIndex.coerceIn(0, arts.size - 1)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(10.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = arts[currentIndex].image,
            contentDescription = "",
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxWidth()
                .padding(15.dp)
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                )
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = arts[currentIndex].title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = arts[currentIndex].artist,
                fontSize = 14.sp,
            )

            Text(
                text = "(${arts[currentIndex].year})",
                fontSize = 14.sp,
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
    }

    Spacer(modifier = Modifier.height(50.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = { currentIndex = (currentIndex - 1).coerceAtLeast(0) }, enabled = (currentIndex > 0)) {
            Text(
                text = "Previous",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Button(onClick = { currentIndex = (currentIndex + 1).coerceAtMost(arts.size - 1) }, enabled = (currentIndex < arts.size - 1)) {
            Text(
                text = "Next",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}
