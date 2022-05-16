package org.sopt.careerly_android.util

import android.graphics.*
import java.lang.Float.min

fun Bitmap.borderedCircularBitmap(
    borderColor: Int,
    borderWidth: Int
): Bitmap {
    val bitmap = Bitmap.createBitmap(
        width,
        height,
        Bitmap.Config.ARGB_8888
    )

    val canvas = Canvas(bitmap)

    val radius = min(width / 2f, height / 2f)

    val borderPath = Path().apply {
        addCircle(
            width / 2f,
            height / 2f,
            radius,
            Path.Direction.CCW
        )
    }

    canvas.clipPath(borderPath)
    canvas.drawColor(borderColor)

    val bitmapPath = Path().apply {
        addCircle(
            width / 2f,
            height / 2f,
            radius - borderWidth,
            Path.Direction.CCW
        )
    }

    canvas.clipPath(bitmapPath)
    val paint = Paint().apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        isAntiAlias = true
    }

    canvas.drawBitmap(this, 0f, 0f, paint)

    canvas.drawBitmap(this, 0f, 0f, null)

    val diameter = (radius * 2).toInt()
    val x = (width - diameter) / 2
    val y = (height - diameter) / 2

    return Bitmap.createBitmap(
        bitmap,
        x,
        y,
        diameter,
        diameter
    )
}
