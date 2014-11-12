package com.house.crime;

import com.house.crime.activity.SingleFragmentActivity;
import com.house.crime.view.CrimeFragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CrimeActivity extends SingleFragmentActivity {

	@Override
	public Fragment createFragment() {
		// TODO Auto-generated method stub
		return new CrimeFragment();
	}                              
 

	
}
