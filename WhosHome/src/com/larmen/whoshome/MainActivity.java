package com.larmen.whoshome;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.widget.FrameLayout;

/**
 * This is where the magic happens...
 * 
 * @author Petter
 */
public class MainActivity extends Activity {	
	
	private FrameLayout fragmentHolder;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		
		 if (findViewById(R.id.fragment_holder) != null) {
	            
	            if (savedInstanceState != null) {
	                return;
	            }
	            
	            MainViewFragment mainFragment = new MainViewFragment();
	            getFragmentManager().beginTransaction()
	                    .add(R.id.fragment_holder, mainFragment).commit();
	            
	        }
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
