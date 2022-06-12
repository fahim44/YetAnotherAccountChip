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

import android.R.attr.text
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.text.TextPaint


class AccountChipDrawable : Drawable() {

    private var drawable : Drawable? = null


    override fun draw(canvas: Canvas) {
        // draw background oval
        val gradientDrawable = GradientDrawable()
        gradientDrawable.bounds = bounds

        gradientDrawable.shape = GradientDrawable.OVAL
        gradientDrawable.setColor(Color.RED)

        drawable = gradientDrawable
        drawable?.draw(canvas)

        // draw text
        val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)

        textPaint.color = Color.WHITE
        textPaint.typeface = Typeface.create("Arial", Typeface.BOLD)
        textPaint.textSize = 50.0f


        val rect = Rect()
        canvas.getClipBounds(rect)
        val cHeight = rect.height()
        val cWidth = rect.width()
        textPaint.textAlign = Paint.Align.LEFT

        textPaint.getTextBounds("FSC", 0, "FSC".length, rect)
        val textX = cWidth / 2f - rect.width() / 2f - rect.left
        val textY = cHeight / 2f + rect.height() / 2f - rect.bottom

        canvas.drawText("FSC", textX, textY, textPaint)
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