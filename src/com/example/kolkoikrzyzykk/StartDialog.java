package com.example.kolkoikrzyzykk;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.kolkoikrzyzykk.Silnik.Gracze;

public class StartDialog extends AlertDialog {

	protected StartDialog(final Silnik graSilnik, Context context) {
		super(context);
		setMessage(context.getResources().getString(R.string.dialog_start));
		setButton(BUTTON_POSITIVE,
				context.getResources().getString(R.string.dialog_start_p1),
				new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						graSilnik.startGra(Gracze.Player1);		
					}
				});
		setButton(BUTTON_NEGATIVE,
				context.getResources().getString(R.string.dialog_start_p2),
				new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						graSilnik.startGra(Gracze.Player2);		
					}
				});
		show();
	}

}
