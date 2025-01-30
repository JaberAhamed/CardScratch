package com.jaber.scractch

import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivek.scratchcardeffect.models.DraggedPath

@Composable
fun CardScratch(
    cardBackgroundColor: Color = Color.Red.copy(alpha = 0.7f),
    scratchBoxColor: Color = Color.Gray,
    title: String = "Scratch & Win",
    titleTextColor: Color = Color.White,
    scratchText: String = "Scratch The Card",
) {
    val currentPathState = remember { mutableStateOf(DraggedPath(path = Path())) }
    val movedOffsetState = remember { mutableStateOf<Offset?>(null) }

    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    color = cardBackgroundColor,
                    shape = RoundedCornerShape(6.dp),

                    ),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                modifier = Modifier.padding(
                    top = 18.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
                text = title,
                color = titleTextColor,
                fontSize = 30.sp,
            )
            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(
                        top = 20.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
            ) {
                val paint = Paint().asFrameworkPaint()
                Canvas(
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(size = 5.dp))
                        .pointerInput(true) {
                            detectDragGestures { change, dragAmount ->
                                movedOffsetState.value = change.position
                            }
                        },
                ) {
                    paint.apply {
                        isAntiAlias = true
                        textSize = 34f
                        typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                        textScaleX = 2.0f
                    }

                    drawRoundRect(color = scratchBoxColor, size = Size(size.width, size.height))

                    movedOffsetState.value?.let {
                        currentPathState.value.path.addOval(oval = Rect(it, 23f))
                    }

                    clipPath(path = currentPathState.value.path, clipOp = ClipOp.Intersect) {
                        drawRoundRect(color = Color.White, size = Size(size.width, size.height))
                        drawIntoCanvas {
                            it.nativeCanvas.drawText(scratchText, 20.0f, center.y, paint)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}


@Composable
@Preview(device = Devices.PIXEL_4)
fun CircularClippedContentPreview() {
    CardScratch()
}
