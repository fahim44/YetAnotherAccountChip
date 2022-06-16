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
import android.util.TypedValue;

class Utility {

    static float getTextSizeInPx(Context context, float textSizeInSp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, textSizeInSp, context.getResources().getDisplayMetrics());
    }

    static boolean isEmpty(String string) {
        return (string == null || string.trim().isEmpty());
    }

    static String getSubString(String string, int limit) {
        return (string.length() >= limit) ? string.substring(0, limit) : string;
    }

    static String getFirstCharOfWords(String string) {
        String[] strings = string.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            s = s.trim();
            if (!s.isEmpty()) {
                stringBuilder.append(s.charAt(0));
            }
        }
        return stringBuilder.toString();
    }

    private Utility() {
    }
}
