# YetAnotherAccountChip
General Android account drawable generator

<a href="https://www.buymeacoffee.com/fahim44" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/default-orange.png" alt="Buy Me A Coffee" height="41" width="174"></a>

Dynamic account icon drawable generator for android.

## SetUp

Add it in your project level `build.gradle` at the end of repositories:
```gradle
repositories {
        mavenCentral()
        maven { url "https://jitpack.io" }
   }
```

Add the dependency in your app level `build.gradle` file:
```gradle
dependencies {
   }
```

## Example

- Create new account chip drawable for account `John Doe`

```kotlin
ChipDrawableBuilder().build("John Doe") // create drawable with default configuration values. Background & text colors will be calculated by string's hashCode 

ChipDrawableBuilder().build("John Doe", 10) // create drawable with default configuration values. Here, index=10. Background & text colors will be selected from the predefine color list. & select the color = color[listSize % index]
```

- Create account chip drawable for `john@example.com` with all configurations

```kotlin
ChipDrawableBuilder()
    .setBackgroundShape(GradientDrawable.OVAL) // set the background shape. Can be OVAL / RECTANGLE
    .setBackgroundColor(ContextCompat.getColor(context, R.color.purple_500)) // set background shape's color
    .setTypeFace(Typeface.create("Arial", Typeface.ITALIC)) // inside text font & style
    .setTextSizeInSp(context, 14.0f) // inside text size
    .setTextColor(ContextCompat.getColor(context, R.color.white)) // inside text color
    .setChipTextStyle(ChipTextStyle.FIRST_CHAR_LOWERCASE) // set the text character count & case
                                                          // ChipTextStyle all options are:
                                                          // FIRST_CHAR, FIRST_CHAR_UPPERCASE, FIRST_CHAR_LOWERCASE,
                                                          // FIRST_TWO_CHAR, FIRST_TWO_CHAR_UPPERCASE, FIRST_TWO_CHAR_LOWERCASE,
                                                          // FIRST_THREE_CHAR, FIRST_THREE_CHAR_UPPERCASE, FIRST_THREE_CHAR_LOWERCASE,
                                                          // FIRST_CHARS_OF_WORDS, FIRST_CHAR_OF_WORDS_UPPERCASE, FIRST_CHAR_OF_WORDS_LOWERCASE
    .build("john@example.com") // build drawable for john@example.com account name
```

- Change the Default configuration values

```kotlin
DefaultConfiguration.setBackgroundShape(GradientDrawable.RECTANGLE) // default value: OVAL
DefaultConfiguration.setBackgroundColors(listOf("#FF0000", "#00FF00", "#0000FF").toTypedArray()) // background shape's color list. 
                                                                                                 // For any item if the background color is not set, color will be selected from this list.
                                                                                                 // default values: Amber, Orange, Red, Lime, Light green, green, teal, cyan, light blue, blue, indigo, pink, purple, deep purple, blue gray
DefaultConfiguration.setTextColors(listOf("#FFFFFF").toTypedArray()) // text color list.
                                                                     // For any item if the text color is not set, one color will be selected from this list.
                                                                     // default values: white
DefaultConfiguration.setTypeface(Typeface.create("Arial", Typeface.NORMAL)) // default value: DEFAULT_BOLD
DefaultConfiguration.setTextSizeInSp(context, 14.0f) // default value: 50 pixel
DefaultConfiguration.setChipTextStyle(ChipTextStyle.FIRST_CHAR) // default value: FIRST_CHAR_UPPERCASE
```
