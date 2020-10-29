# androidsvgCOLOR

[![Release](https://jitpack.io/v/MPArnold/androidsvgCOLOR.svg)](https://jitpack.io/#MPArnold/androidsvgCOLOR)

The well-known [AndroidSVG](https://github.com/BigBadaboom/androidsvg) does not (as at November 2020) allow full user control over FILL and STROKE colour because of a clumsy CSS-based method not currently supporting **!important**. See [here](https://stackoverflow.com/questions/64472191).

This fork gives users the final word on colour by deploying a callback fired whenever the `Paint` colour is set and came about because my app needs to paint user-defined Inkscape SVGs with appropriately contrasted colours over variously-coloured raster map layers.

It arose because the original author wished to enforce the inferior CSS-based method "_for the sake of standards_", thereby denying his users the flexibility of deciding for themselves which technique would best suit them.

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
SVG svg;
...
svg.setColourCallback(new SVGBase.ColourCallback(...));
```
Supply integer paint colours to the callback.

## Note

For completeness, here is a _HowTo_ for applying this patch to your fork of the original master.
```
// AndroidSVG: Allow full user control over FILL and STROKE colours.
// Author: MPArnold
// Date: Halloween 2020

/* ---------------------------------------------------------------------
(1) com.caverock.androidsvg.utils.SVGBase
Add the following anywhere ...
--------------------------------------------------------------------- */
	//===============================================================================
	// Define optional STROKE / FILL colour callback

	/** Callback allowing user the final word on FILL/STROKE colour.
	@see SVG#setColourCallback(SVGBase.ColourCallback colourCB)
	@see SVGAndroidRenderer#setPaintColour(SVGAndroidRenderer.RendererState, boolean, SvgPaint) */
	public interface ColourCallback { int getPaintColour(boolean isFill, int defaultColor); }
    public ColourCallback colourCB=null;
    public void setColourCallBack(ColourCallback colourCB) { this.colourCB = colourCB; }

/* ---------------------------------------------------------------------
(2) com.caverock.androidsvg.SVG
Add the following anywhere ...
--------------------------------------------------------------------- */
    /** Set optional STROKE / FILL colour callback. Example: <br>
	svg.setColourCallback(new SVGBase.ColourCallback() {
		@Override public int getPaintColour(boolean isFill, int defaultColour) { return anyColour; }
	});
	@see SVGAndroidRenderer#setPaintColour(SVGAndroidRenderer.RendererState, boolean, SvgPaint) */
    public void setColourCallback(SVGBase.ColourCallback colourCB) {
        if (base==null) return;
        base.setColourCallBack(colourCB);
    }

/* ---------------------------------------------------------------------
(3) com.caverock.androidsvg.utils.SVGAndroidRenderer
Add the following to method setPaintColour() after the line ...
	col = colourWithOpacity(col, paintOpacity);
--------------------------------------------------------------------- */
	// Allow user the final word on FILL and STROKE colour.
	if (document.colourCB!=null) { col = document.colourCB.getPaintColour(isFill, col); }

```
NB: These were part of my original notes and although superceded still illustrate the approach.
