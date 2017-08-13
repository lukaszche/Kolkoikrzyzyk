package com.example.kolkoikrzyzykk;

import com.example.kolkoikrzyzykk.Silnik.Gracze;

import android.app.AlertDialog;
import android.content.Context;

public class EndDialog extends AlertDialog {

	protected EndDialog(final Silnik graSilnik,Context context,final Gracze wygrany) {
		super(context);
		String tmp;
		if(wygrany == Gracze.Player1){
			tmp =context.getResources().getString(R.string.dialog_end_p1);
		}else{
			tmp =context.getResources().getString(R.string.dialog_end_p2);
		}
		setMessage(tmp);
		show();
	}
	
}
