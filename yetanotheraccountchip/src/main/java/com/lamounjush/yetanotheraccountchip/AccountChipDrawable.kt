/*
 * Copyright Fahim Salam Chowdhury (fahim44@duck.com) 2022
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.lamounjush.yetanotheraccountchip

import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.text.TextPaint
import androidx.annotation.ColorInt


class AccountChipDrawable(
    private val backgroundShape: Int,
    @ColorInt private val backgroundColor: Int,
    private val typeface: Typeface,
    private val textSizeInPx: Float,
    @ColorInt private val textColor: Int,
    private val chipTextStyle: ChipTextStyle,
    private val text: String
) : Drawable() {

    private var drawable: Drawable? = null

    override fun draw(canvas: Canvas) {
        // draw background oval
        val gradientDrawable = GradientDrawable()
        gradientDrawable.bounds = bounds
        gradientDrawable.shape = backgroundShape
        gradientDrawable.setColor(backgroundColor)
        drawable = gradientDrawable
        drawable?.draw(canvas)

        // draw text
        val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        textPaint.color = textColor
        textPaint.typeface = typeface
        textPaint.textSize = textSizeInPx
        val rect = Rect()
        canvas.getClipBounds(rect)
        val cHeight = rect.height()
        val cWidth = rect.width()
        textPaint.textAlign = Paint.Align.LEFT
        textPaint.getTextBounds(text, 0, text.length, rect)
        val textX = cWidth / 2f - rect.width() / 2f - rect.left
        val textY = cHeight / 2f + rect.height() / 2f - rect.bottom
        canvas.drawText(text, textX, textY, textPaint)
    }

    override fun setAlpha(alpha: Int) {
        drawable?.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        drawable?.colorFilter = colorFilter
    }

    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int {
        return drawable?.opacity ?: PixelFormat.TRANSPARENT
    }
}