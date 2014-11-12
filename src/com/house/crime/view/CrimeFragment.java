package com.house.crime.view;

import java.util.UUID;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

import com.house.crime.R;
import com.house.crime.model.Crime;
import com.house.crime.model.CrimeLab;

public class CrimeFragment extends Fragment {
	private Crime mCrime;
	private EditText mCrimeTitle;
	private Button mDateButton;
	private CheckBox mSolvedCheckBox;
	  public static final String EXTRE_CRIME_ID ="crime_id";
	  public static final String DIALOG_DATE ="date";
	public static CrimeFragment newInstance(UUID id){
		Bundle args = new Bundle();
		args.putSerializable(EXTRE_CRIME_ID, id);
		CrimeFragment fragment = new CrimeFragment();
		fragment.setArguments(args);
		return fragment;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mCrime = new Crime();
		
		UUID crimeId = (UUID) getArguments().getSerializable(EXTRE_CRIME_ID);
		mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
	}
	


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_crime, container, false);
		mCrimeTitle = (EditText) v.findViewById(R.id.crime_title);
		mCrimeTitle.setText(mCrime.getTitle());
		
		mDateButton = (Button) v.findViewById(R.id.date_button);
		mDateButton.setText(mCrime.getDate().toString());
		mDateButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fm =getActivity().getSupportFragmentManager();
				DatePickerFragment dialog = new DatePickerFragment();
				dialog.show(fm, DIALOG_DATE);
			}
		});
		
		mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
		mSolvedCheckBox.setChecked(mCrime.isSolved());
		mSolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				mCrime.setSolved(isChecked);
				setShowResutForFragment();
			}

		
		});
		mCrimeTitle.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				mCrime.setTitle(s.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
		return v;
	}
	
	private void setShowResutForFragment() {
		// TODO Auto-generated method stub
		Intent dateL = new Intent();
		dateL.putExtra("test", "just a test");
		getActivity().setResult(1, dateL);
	}
}
