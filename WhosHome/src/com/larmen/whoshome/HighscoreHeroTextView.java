package com.larmen.whoshome;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class HighscoreHeroTextView extends TextView {

	// Custom class created from from tutorial at
	// http://android-dev-tidbits.blogspot.se/2013/05/using-custom-fonts-with-android.html

	public HighscoreHeroTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		if (attrs != null) {
			// Get Custom Attribute Name and value
			TypedArray styledAttrs = context.obtainStyledAttributes(attrs,
					R.styleable.TypefacedTextView);
			int typefaceCode = styledAttrs.getInt(
					R.styleable.TypefacedTextView_font, -1);
			styledAttrs.recycle();

			// Typeface.createFromAsset doesn't work in the layout editor.
			// Skipping...
			if (isInEditMode()) {
				return;
			}

			Typeface typeface = Typeface.createFromAsset(getContext()
					.getAssets(), "fonts/HighscoreHero.ttf");
			setTypeface(typeface);
		}
	}
}
