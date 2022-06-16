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

package com.lamounjush.yetanotheraccountchip;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;

public class DefaultConfiguration {

    private static int backgroundShape = GradientDrawable.OVAL;
    private static String[] backgroundColors = new String[]{
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
    };
    private static String[] textColors = new String[]{
            "#FFFFFF"  // white
    };
    private static Typeface typeface = Typeface.DEFAULT_BOLD;
    private static float textSizeInPx = 50.0f;
    private static ChipTextStyle chipTextStyle = ChipTextStyle.FIRST_CHAR_UPPERCASE;

    public static void setBackgroundShape(int backgroundShape) {
        DefaultConfiguration.backgroundShape = backgroundShape;
    }

    public static void setBackgroundColors(String[] backgroundColors) {
        DefaultConfiguration.backgroundColors = backgroundColors;
    }

    public static void setTextColors(String[] textColors) {
        DefaultConfiguration.textColors = textColors;
    }

    public static void setTypeface(Typeface typeface) {
        DefaultConfiguration.typeface = typeface;
    }

    public static void setTextSizeInSp(Context context, float textSizeInSp) {
        if (context == null) {
            return;
        }
        DefaultConfiguration.textSizeInPx = Utility.getTextSizeInPx(context, textSizeInSp);
    }

    public static void setChipTextStyle(ChipTextStyle chipTextStyle) {
        DefaultConfiguration.chipTextStyle = chipTextStyle;
    }

    static int getBackgroundShape() {
        return backgroundShape;
    }

    static String[] getBackgroundColors() {
        return backgroundColors;
    }

    static String[] getTextColors() {
        return textColors;
    }

    static Typeface getTypeface() {
        return typeface;
    }

    static float getTextSizeInPx() {
        return textSizeInPx;
    }

    static ChipTextStyle getChipTextStyle() {
        return chipTextStyle;
    }

    private DefaultConfiguration() {
    }
}
