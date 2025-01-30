package com.jaber.scratchcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jaber.scractch.CardScratch
import com.jaber.scractch.ImageScratch
import com.jaber.scratchcard.ui.theme.ScratchCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScratchCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black,
                ) {
                    Scratch()
                }
            }
        }
    }
}

@Composable
fun Scratch(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        ImageScratch(
            modifier = Modifier.weight(0.8f),
            overlayImage = ImageBitmap.imageResource(R.drawable.overlay),
            baseImage =
            ImageBitmap.imageResource(R.drawable.base),
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(200.dp)
                .padding(start = 16.dp, end = 16.dp),
        ) {
            CardScratch(
                cardBackgroundColor = Color.Red.copy(0.6f),
                title = "Scratch & Win",
                titleTextColor = Color.White,
                scratchText = "Coupon code is: 457896",
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScratchCardTheme {
        Scratch()
    }
}
