# androidsvgCOLOR

[![Release](https://jitpack.io/v/MPArnold/androidsvgCOLOR.svg)](https://jitpack.io/#MPArnold/androidsvgCOLOR)

The well-known [AndroidSVG](https://github.com/BigBadaboom/androidsvg) does not (as at November 2020) allow full user control over FILL and STROKE colour because of a clumsy CSS-based method not currently supporting **!important**. See [here](https://stackoverflow.com/questions/64472191).

This fork gives users the final word on colour by deploying a callback fired whenever the `Paint` colour is set and came about because I needed to paint user-defined Inkscape SVGs with appropriately contrasted colours over varying raster map layers.

## Implementation
Add the following to your (project) build.gradle with:
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
and the following to your (app) build.gradle:

```gradle
dependencies {
    implementation 'com.github.androidsvgCOLOR:4.3@aar'
}
```

## Deployment
You must instantiate `com.caverock.androidsvg.SVG.java` ...

```
SVG svg
...
svg.setColourCallback(new SVGBase.ColourCallback(...))
```
Supply integer paint colours to the callback.
















# AndroidSVG

AndroidSVG is a SVG parser and renderer for Android.  It has almost complete support for the static
visual elements of the SVG 1.1 and SVG 1.2 Tiny specifications (except for filters).

*AndroidSVG is licensed under the [Apache License v2.0](http://www.apache.org/licenses/LICENSE-2.0)*.

[More information, including downloads and documentation, is available at the main AndroidSVG site.](http://bigbadaboom.github.io/androidsvg/)


### Find a bug?

Please file a [bug report](https://github.com/BigBadaboom/androidsvg/issues) and include as much detail as you can.
If possible, please include a sample SVG file showing the error.

If you wish to contact the author with feedback on this project, you can email me at
[androidsvgfeedback@gmail.com](mailto:androidsvgfeedback@gmail.com).


### Using AndroidSVG in your app?

If you have found AndroidSVG useful and are using it in your project, please let me know. I'd love to hear about it!
