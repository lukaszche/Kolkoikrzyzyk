package com.example.kolkoikrzyzykk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class GraListener implements OnTouchListener {

	private Silnik graSilnik;

	private int startX, startY, stopX, stopY;

	public GraListener(Silnik graSilnik) {
		this.graSilnik = graSilnik;
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		float sizeOfElement = graSilnik.getGridSize()
				/ graSilnik.getGridNumber();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			startX = (int) (event.getX() / sizeOfElement);
			startY = (int) (event.getY() / sizeOfElement);
			break;
		case MotionEvent.ACTION_UP:
			stopX = (int) (event.getX() / sizeOfElement);
			stopY = (int) (event.getY() / sizeOfElement);
			break;
		default:
			break;
		}
		
		if(startX<graSilnik.getGridNumber() && startY <graSilnik.getGridNumber()){
			if(startX ==stopX && startY==stopY){
				graSilnik.addMark(startX,startY);
			}
		}
		return true;
	}
}
