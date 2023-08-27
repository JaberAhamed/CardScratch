package com.jaber.scractch
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.vivek.scratchcardeffect.models.DraggedPath

@Composable
fun ImageScratch(
    overlayImage: ImageBitmap,
    baseImage: ImageBitmap,
    isIntersect: Boolean = true,
    startPadding: Dp = 16.dp,
    endPadding: Dp = 16.dp,
) {
    val currentPathState = remember { mutableStateOf(DraggedPath(path = Path())) }
    val movedOffsetState = remember { mutableStateOf<Offset?>(null) }

    Box(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .padding(start = startPadding, end = endPadding),
    ) {
        var clipOp = ClipOp.Intersect
        Canvas(
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(size = 6.dp))
                .pointerInput(true) {
                    detectDragGestures { change, _ ->
                        movedOffsetState.value = change.position
                    }
                },
        ) {
            val imageSize = IntSize(width = size.width.toInt(), height = size.height.toInt())

            drawImage(overlayImage, dstSize = imageSize)

            movedOffsetState.value?.let {
                currentPathState.value.path.addOval(oval = Rect(it, 50f))
            }

            if (!isIntersect) {
                clipOp = ClipOp.Difference
            }

            clipPath(path = currentPathState.value.path, clipOp = clipOp) {
                drawImage(baseImage, dstSize = imageSize)
            }
        }
    }
}

@Composable
@Preview(device = Devices.PIXEL_4)
fun ImageScratchPreview() {
}
