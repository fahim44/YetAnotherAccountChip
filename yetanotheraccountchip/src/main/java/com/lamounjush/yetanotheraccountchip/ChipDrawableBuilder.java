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
import android.graphics.Color;
import android.graphics.Typeface;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Locale;

public class ChipDrawableBuilder {

    private int backgroundShape = DefaultConfiguration.getBackgroundShape();
    private Typeface typeface = DefaultConfiguration.getTypeface();
    private float textSizeInPx = DefaultConfiguration.getTextSizeInPx();
    private ChipTextStyle chipTextStyle = DefaultConfiguration.getChipTextStyle();
    private @ColorInt Integer backgroundColor;
    private @ColorInt Integer textColor;

    public ChipDrawableBuilder setBackgroundShape(int backgroundShape) {
        this.backgroundShape = backgroundShape;
        return this;
    }

    public ChipDrawableBuilder setTypeface(Typeface typeface) {
        this.typeface = typeface;
        return this;
    }

    public ChipDrawableBuilder setTextSizeInSp(Context context, float textSizeInSp) {
        if (context != null) {
            this.textSizeInPx = Utility.getTextSizeInPx(context, textSizeInSp);
        }
        return this;
    }

    public ChipDrawableBuilder setBackgroundColor(@ColorInt int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public ChipDrawableBuilder setTextColor(@ColorInt int textColor) {
        this.textColor = textColor;
        return this;
    }

    public ChipDrawableBuilder setChipTextStyle(ChipTextStyle chipTextStyle) {
        this.chipTextStyle = chipTextStyle;
        return this;
    }

    @NonNull
    public AccountChipDrawable build(String account) {
       int index = Math.abs(account.hashCode());
        return build(account, index);
    }

    @NonNull
    public AccountChipDrawable build(String account, int index) {
        if (index < 0) {
            index = 0;
        }
        updateColors(index);
        if (!Utility.isEmpty(account)) {
            account = getFormattedText(account);
        } else {
            account = "";
        }
        return new AccountChipDrawable(backgroundShape, backgroundColor, typeface, textSizeInPx, textColor, chipTextStyle, account);
    }

    private String getFormattedText(String account) {
        if (!Utility.isEmpty(account)) {
            switch (chipTextStyle) {
                case FIRST_CHAR:
                    return Utility.getSubString(account, 1);
                case FIRST_TWO_CHAR:
                    return Utility.getSubString(account, 2);
                case FIRST_THREE_CHAR:
                    return Utility.getSubString(account, 3);
                case FIRST_TWO_CHAR_UPPERCASE:
                    return Utility.getSubString(account, 2).toUpperCase(Locale.ROOT);
                case FIRST_THREE_CHAR_UPPERCASE:
                    return Utility.getSubString(account, 3).toUpperCase(Locale.ROOT);
                case FIRST_CHAR_LOWERCASE:
                    return Utility.getSubString(account, 1).toLowerCase(Locale.ROOT);
                case FIRST_TWO_CHAR_LOWERCASE:
                    return Utility.getSubString(account, 2).toLowerCase(Locale.ROOT);
                case FIRST_THREE_CHAR_LOWERCASE:
                    return Utility.getSubString(account, 3).toLowerCase(Locale.ROOT);
                case FIRST_CHARS_OF_WORDS:
                    return Utility.getFirstCharOfWords(account);
                case FIRST_CHAR_OF_WORDS_UPPERCASE:
                    return Utility.getFirstCharOfWords(account).toUpperCase(Locale.ROOT);
                case FIRST_CHAR_OF_WORDS_LOWERCASE:
                    return Utility.getFirstCharOfWords(account).toLowerCase(Locale.ROOT);
                default:
                    return Utility.getSubString(account, 1).toUpperCase(Locale.ROOT);
            }
        }
        return "";
    }

    private void updateColors(int providedIndex) {
        if (backgroundColor == null) {
            int index = providedIndex % DefaultConfiguration.getBackgroundColors().length;
            backgroundColor = Color.parseColor(DefaultConfiguration.getBackgroundColors()[index]);
        }
        if (textColor == null) {
            int index = providedIndex % DefaultConfiguration.getTextColors().length;
            textColor = Color.parseColor(DefaultConfiguration.getTextColors()[index]);
        }
    }
}
