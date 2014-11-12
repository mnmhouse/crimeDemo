package com.house.crime.activity;

import com.house.crime.R;
import com.house.crime.view.ListCrimeFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {
  public abstract Fragment createFragment();
  protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragmet);
		 FragmentManager fm = getSupportFragmentManager();
		
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		if(fragment == null){
			fragment =createFragment();
			fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
	}
}
}
