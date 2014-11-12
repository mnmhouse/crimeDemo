package com.house.crime.activity;

import com.house.crime.R;
import com.house.crime.view.CrimeFragment;
import com.house.crime.view.ListCrimeFragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;

public class ListCrimeActivity extends SingleFragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
       
    	
    
    }
	
	@Override
	public Fragment createFragment() {
		// TODO Auto-generated method stub
		return new ListCrimeFragment();
	}
}
