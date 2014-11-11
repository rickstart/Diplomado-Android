package com.rickstart.listviewsample;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ListView listview;

	 protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.activity_main);

		    listview = (ListView) findViewById(R.id.listview);
		    String[] values = new String[] { "Irving", "Jose", "Alex",
		        "Marco", "Antonio", "Ricardo" };

		    MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);
		
		    listview.setAdapter(adapter);
		    
		    
		    
		    
//			final ArrayList<String> list = new ArrayList<String>();
//		    for (int i = 0; i < values.length; ++i) {
//		      list.add(values[i]);
//		    }
//		    final StableArrayAdapter adapter = new StableArrayAdapter(this,
//		        android.R.layout.simple_list_item_1, list);
		   

//		    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//		      @SuppressLint("NewApi")
//			@Override
//		      public void onItemClick(AdapterView<?> parent, final View view,
//		          int position, long id) {
//		        final String item = (String) parent.getItemAtPosition(position);
//		        view.animate().setDuration(2000).alpha(0)
//		            .withEndAction(new Runnable() {
//		              @Override
//		              public void run() {
//		                list.remove(item);
//		                adapter.notifyDataSetChanged();
//		                view.setAlpha(1);
//		              }
//		            });
//		      }
//
//		    });
		  }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
