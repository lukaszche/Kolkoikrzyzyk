package com.example.kolkoikrzyzykk;

import com.example.kolkoikrzyzykk.Silnik.Gracze;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

public class Grafika extends View {

	private Silnik graSilnik;
	private Paint paint;
	private Bitmap bitmapX, bitmapO;
	private float sizeOfElement;

	public Grafika(Context context, Silnik graSilnik) {
		super(context);

		this.graSilnik = graSilnik;
		paint = new Paint();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		if (graSilnik.getGridSize() == 0) {
			graSilnik.setGridSize(canvas.getWidth());

			sizeOfElement = graSilnik.getGridSize() / graSilnik.getGridNumber();

			loadCreateBitmap();
		}

		drawGrid(canvas);

		drawPlayers(canvas);

		invalidate();
	}

	private void drawPlayers(Canvas canvas) {
		for (int y = 0; y < graSilnik.getGridNumber(); y++) {
			for (int x = 0; x < graSilnik.getGridNumber(); x++) {
				if (graSilnik.getPlayerAt(x, y) != Gracze.None) {
					Bitmap tmpBitmap = null;
					if (graSilnik.getPlayerAt(x, y) == Gracze.Player1) {
						tmpBitmap = bitmapX;
					} else {
						tmpBitmap = bitmapO;
					}

					canvas.drawBitmap(tmpBitmap, sizeOfElement * x,
							sizeOfElement * y, paint);
				}
			}
		}

	}

	private void loadCreateBitmap() {
		// Wczytywanie obrazow
		bitmapX = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.x);
		bitmapO = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.o);
		// Zmiana rozmiaru

		bitmapX = Bitmap.createScaledBitmap(bitmapX, (int) sizeOfElement,
				(int) sizeOfElement, true);
		bitmapO = Bitmap.createScaledBitmap(bitmapO, (int) sizeOfElement,
				(int) sizeOfElement, true);
	}

	private void drawGrid(Canvas canvas) {
		for (int i = 0; i < graSilnik.getGridNumber() + 1; i++) {
			// linie poziome
			canvas.drawLine(0, sizeOfElement * i, graSilnik.getGridSize(),
					sizeOfElement * i, paint);
			// linie pionowe
			canvas.drawLine(sizeOfElement * i, 0, sizeOfElement * i,
					graSilnik.getGridSize(), paint);
		}
	}

}
