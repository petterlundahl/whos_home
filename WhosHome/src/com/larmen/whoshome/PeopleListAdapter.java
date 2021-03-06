
package com.larmen.whoshome;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PeopleListAdapter extends ArrayAdapter<String> {

	private ArrayList<String> objects;
	private Activity context;

	public PeopleListAdapter(Activity _context, int layoutResourceId,
			ArrayList<String> _objects) {
		super(_context, R.layout.people_list_item);
		objects = _objects;
		context = _context;

		for (int i = 0; i < objects.size(); i++) {
			Log.i("k3", "objects(" + i + "): " + objects.get(i));
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return objects.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return objects.get(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.people_list_item, parent,
				false);
		TextView nameTextView = (TextView) rowView
				.findViewById(R.id.people_list_item_name);

		Log.i("k3", "rowView.findViewById(R.id.people_list_item_name): "
				+ rowView.findViewById(R.id.people_list_item_name));

		TextView scoreTextView = (TextView) rowView.findViewById(R.id.people_list_item_score);
		int tempScore = (int)(Math.random()*100000000);
		scoreTextView.setText(Integer.toString(tempScore));
		

		String people_name = objects.get(position);

		Log.i("k3", "people_name: " + people_name);

		nameTextView.setText(people_name);
		MainActivity mActivity = (MainActivity) context;
		if (mActivity != null && mActivity.getTypeface("hHero") != null) {
			Typeface hHero = mActivity.getTypeface("hHero");
			nameTextView.setTypeface(hHero);
			scoreTextView.setTypeface(hHero);
		}

		return rowView;
	}

}

