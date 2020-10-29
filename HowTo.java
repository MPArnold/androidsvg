// AndroidSVG: Allow full user control over FILL and STROKE colours.
// Author: MPArnold
// Date: Halloween 2020

/* ---------------------------------------------------------------------
(1) com.caverock.androidsvg.utils.SVGBase
Add the following anywhere ...
--------------------------------------------------------------------- */
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
		&#x0040;Override public int getPaintColour(boolean isFill, int defaultColour) { return anyColour; }
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

