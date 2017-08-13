package com.example.kolkoikrzyzykk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	private Silnik graSilnik;
	private FrameLayout graFrame;
 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		graSilnik = new Silnik(this);
		graFrame = (FrameLayout)findViewById(R.id.graFrame);
		graFrame.setOnTouchListener(new GraListener(graSilnik));
		graFrame.addView(new Grafika(this,graSilnik));
	}
}
