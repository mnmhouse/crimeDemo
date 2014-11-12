package com.house.crime.activity;

import com.house.crime.R;
import com.house.crime.view.ListCrimeFragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public abstract class SingleFragmentActivity extends Activity {
  public abstract Fragment createFragment();
  protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragmet);
		 FragmentManager fm = getFragmentManager();
		
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		if(fragment == null){
			fragment =createFragment();
			fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
	}
}
}
