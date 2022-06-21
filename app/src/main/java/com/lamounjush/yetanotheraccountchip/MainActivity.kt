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

import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DefaultConfiguration.setBackgroundShape(GradientDrawable.OVAL)
        DefaultConfiguration.setTextSizeInSp(this, 30.0f)
        DefaultConfiguration.setChipTextStyle(ChipTextStyle.FIRST_CHAR_OF_WORDS_UPPERCASE)
        DefaultConfiguration.setTextColors(listOf("#FFFFFF").toTypedArray())

        val imageView1: ImageView = findViewById(R.id.image1)
        imageView1.setImageDrawable(
            ChipDrawableBuilder()
                .build("John Doe")
        )


        val imageView2: ImageView = findViewById(R.id.image2)
        imageView2.setImageDrawable(
            ChipDrawableBuilder()
                .setBackgroundShape(GradientDrawable.RECTANGLE)
                .setBackgroundColor(ContextCompat.getColor(this, R.color.purple_500))
                .setTextColor(ContextCompat.getColor(this, R.color.teal_700))
                .setTextSizeInSp(this, 20.0f)
                .setChipTextStyle(ChipTextStyle.FIRST_THREE_CHAR)
                .build("hello@kitty.com")
        )

        val imageView3: ImageView = findViewById(R.id.image3)
        imageView3.setImageDrawable(
            ChipDrawableBuilder()
                .setChipTextStyle(ChipTextStyle.FIRST_TWO_CHAR_LOWERCASE)
                .setTypeface(Typeface.create("Arial", Typeface.ITALIC))
                .build("ActiveUser  1122", 15)
        )
    }
}