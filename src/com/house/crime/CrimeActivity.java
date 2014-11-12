package com.house.crime;

import java.util.UUID;


import android.support.v4.app.Fragment;

import com.house.crime.activity.SingleFragmentActivity;
import com.house.crime.view.CrimeFragment;

public class CrimeActivity extends SingleFragmentActivity {

	@Override
	public  Fragment createFragment() {
		// TODO Auto-generated method stub
		
		UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRE_CRIME_ID);
		return CrimeFragment.newInstance(crimeId);
 

	}	
}
