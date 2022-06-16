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

object DefaultInstance {

    var backgroundShape = GradientDrawable.OVAL
    var backgroundColors = listOf(
        "#FFB300", // Amber
        "#FB8C00", // Orange
        "#E53935", // Red
        "#C0CA33", // Lime
        "#7CB342", // Light green
        "#388E3C", // green
        "#00897B", // teal
        "#00ACC1", // cyan
        "#039BE5", // light blue
        "#1976D2", // blue
        "#3949AB", // indigo
        "#E91E63", // pink
        "#8E24AA", // purple
        "#5E35B1", // deep purple
        "#455A64"  // blue gray
    )
    var textColors = listOf(
        "#FFFFFF"  // white
    )
    var typeFace: Typeface = Typeface.create("Arial", Typeface.BOLD)
    var textSizeInSp = 14.0f
}