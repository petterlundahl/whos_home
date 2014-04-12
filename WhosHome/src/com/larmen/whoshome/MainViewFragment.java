package com.larmen.whoshome;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainViewFragment extends Fragment {

	private ListView peopleList;
	private ArrayAdapter<String> mPeopleListAdapter;
	private ArrayList<String> objects = new ArrayList<String>();
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		for(int i = 0; i < 4; i++){
			objects.add("ITEM NUMBER "+i);
		}
		View view = inflater.inflate(R.layout.main_view_layout, container,false);
		
		if (getActivity().findViewById(R.id.people_list) != null) {		
			Log.i("k3", "getActivity().findViewById(R.id.people_list) != null");
			peopleList = (ListView) view.findViewById(R.id.people_list);
			mPeopleListAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1,objects);
			peopleList.setAdapter(mPeopleListAdapter);			
		}
		
		return view;

	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
	}

}
