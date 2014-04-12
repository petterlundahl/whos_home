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
	private PeopleListAdapter mPeopleListAdapter;
	private ArrayList<String> objects = new ArrayList<String>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		for (int i = 0; i < 4; i++) {
			objects.add("ITEM NUMBER " + i);
		}
		View view = inflater.inflate(R.layout.main_view_layout, container,false);
		peopleList = (ListView) view.findViewById(R.id.people_list);
		mPeopleListAdapter = new PeopleListAdapter(this.getActivity(),R.layout.people_list_item, objects);
		Log.i("k3", "mPeopleListAdapter: "+mPeopleListAdapter);
		peopleList.setAdapter(mPeopleListAdapter);
		
		
		return view;

	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		

	}

}
