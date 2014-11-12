package com.house.crime.view;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.house.crime.CrimeActivity;
import com.house.crime.R;
import com.house.crime.activity.CrimePagerActivity;
import com.house.crime.model.Crime;
import com.house.crime.model.CrimeLab;

public class ListCrimeFragment extends ListFragment {
 
	private ArrayList<Crime> mCrimes;
    private static final int REQUEST_CRIME = 1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().setTitle("list");
		mCrimes = CrimeLab.get(getActivity()).getCrimes();

		CrimeAdatper adapter = new CrimeAdatper(mCrimes);
		setListAdapter(adapter);

	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == REQUEST_CRIME ){
			
		
//			String tes =data.getStringExtra("test");
//			Toast.makeText(getActivity(), tes, Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub

		Crime c = (Crime) getListAdapter().getItem(position);

		Toast.makeText(getActivity(), c.getTitle(), Toast.LENGTH_SHORT).show();
		
		Intent intent =new Intent(getActivity(), CrimePagerActivity.class);
		intent.putExtra(CrimeFragment.EXTRE_CRIME_ID, c.getId());
		
		startActivity(intent);
	}


	private class CrimeAdatper extends ArrayAdapter<Crime> {

		public CrimeAdatper(ArrayList<Crime> crimes) {

			super(getActivity(), 0, crimes);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.list_item_crime, null);
			}

			Crime c = getItem(position);
			
			TextView title = (TextView) convertView.findViewById(R.id.crime_item_title);
			title.setText(c.getTitle());
			TextView date = (TextView)convertView.findViewById(R.id.crime_item_date);
			date.setText(c.getDate().toString());
			CheckBox solvedCheckbox = (CheckBox)convertView.findViewById(R.id.check_solved);
			solvedCheckbox.setChecked(c.isSolved());
			return convertView;
		}
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		((CrimeAdatper)getListAdapter()).notifyDataSetChanged();
	}
}
