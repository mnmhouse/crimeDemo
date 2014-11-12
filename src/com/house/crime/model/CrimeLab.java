package com.house.crime.model;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class CrimeLab {

	private ArrayList<Crime> mCrimes;
	private static CrimeLab sCrimeLab;
	private Context mAppContext;

	private CrimeLab(Context contxt) {
		this.mAppContext = contxt;
		mCrimes = new ArrayList<Crime>();
		for (int i = 0; i < 100; i++) {
			Crime c = new Crime();
			c.setTitle("Crime #" + i);
			c.setSolved(i % 2 == 0);
			mCrimes.add(c);
		}

	}
	public static CrimeLab get(Context c){
		if(sCrimeLab == null){
			//保证单例总有context可以使用
			sCrimeLab = new CrimeLab(c.getApplicationContext());
		}
		return sCrimeLab;
	}

	public Crime getCrime(UUID id){
		  for(Crime c : mCrimes){
			  if(c.getId().equals(id)){
				  return c;
			  }
		  }
		  return null;
	  }

	public ArrayList<Crime> getCrimes() {
		return mCrimes;
	}

	public void setCrimes(ArrayList<Crime> crimes) {
		mCrimes = crimes;
	}
}
