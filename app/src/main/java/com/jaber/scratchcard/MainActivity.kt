package com.jaber.scratchcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scratch()
                }
            }
        }
    }
}

@Composable
fun Scratch(modifier: Modifier = Modifier) {
    Column {
        CardScratch(
            cardBackgroundColor = Color.Blue.copy(0.7f),
            title = "Please scratch the card",
            titleTextColor = Color.White,
            scratchText = "No coupon code found",
        )
        Spacer(modifier = Modifier.height(20.dp))
        ImageScratch(
            overlayImage = ImageBitmap.imageResource(R.drawable.overlay),
            baseImage =
            ImageBitmap.imageResource(R.drawable.base),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScratchCardTheme {
        Scratch()
    }
}
