# androidsvgCOLOR

[![Release](https://jitpack.io/v/MPArnold/androidsvgCOLOR.svg)](https://jitpack.io/#MPArnold/androidsvgCOLOR)

The well-known [AndroidSVG](https://github.com/BigBadaboom/androidsvg) does not (as at November 2020) allow full user control over FILL and STROKE colour because of a clumsy CSS-based method not currently supporting **!important**. See [here](https://stackoverflow.com/questions/64472191).

This fork gives users the final word on colour by deploying a callback fired whenever the `Paint` colour is set and came about because I needed to paint user-defined Inkscape SVGs with appropriately contrasted colours over variously-coloured raster map layers.

## Implementation
Add the following to your **project** build.gradle:
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
and the following to your **app** build.gradle:

```gradle
dependencies {
    implementation 'com.github.androidsvgCOLOR:1.4.3@aar'
}
```

## Deployment
You must first instantiate `com.caverock.androidsvg.SVG.java`.

```
SVG svg
...
svg.setColourCallback(new SVGBase.ColourCallback(...))
```
Supply integer paint colours to the callback.
