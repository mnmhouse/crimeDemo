package com.house.crime.view;

import com.house.crime.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;

public class DatePickerFragment extends DialogFragment {

	@Override
	@NonNull
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v =getActivity().getLayoutInflater().inflate(R.layout.dialog_date, null);
		return new AlertDialog.Builder(getActivity()).setView(v).setTitle("date of crime")
				.setPositiveButton("ok", null).create();

	}
}
