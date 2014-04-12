package com.larmen.whoshome;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 * This is where the magic happens...
 * 
 * @author Petter
 */
public class MainActivity extends Activity {
	
	//Testing first commit
	//Also testing first commit
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
