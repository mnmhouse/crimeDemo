package com.house.crime.view;

import java.util.ArrayList;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.house.crime.R;
import com.house.crime.model.Crime;
import com.house.crime.model.CrimeLab;

public class ListCrimeFragment extends ListFragment {

	private ArrayList<Crime> mCrimes;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().setTitle("list");
		mCrimes = CrimeLab.get(getActivity()).getCrimes();

		ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(),
				android.R.layout.simple_list_item_1, mCrimes);
		setListAdapter(adapter);

	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub

		Crime c = (Crime) getListAdapter().getItem(position);

		Toast.makeText(getActivity(), c.getTitle(), Toast.LENGTH_SHORT).show();
	}

	@SuppressWarnings("unused")
	private class CrimeAdatper extends ArrayAdapter<Crime> {

		public CrimeAdatper(ArrayList<Crime> crimes) {

			super(getActivity(), 0, crimes);
		}

		@Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	// TODO Auto-generated method stub
    	if(convertView  == null){
    		convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
    	}
    	
    	Crime c = getItem(position);
    	
    	return convertView;
    }
	}
}
