package com.rickstart.droidcontact;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ListView listview;

	 protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.activity_main);

		    listview = (ListView) findViewById(R.id.lv_contacts);
		    Contact irving = new Contact("Irving","irv@gmail.com","552423255242","irving","@irev");
		    Contact antonio = new Contact("Antonio","irv@gmail.com","552423255242","irv","@irev");
		    Contact jose = new Contact("Jose","irv@gmail.com","552423255242","irv","@irev");
		    Contact alex = new Contact("Alex","irv@gmail.com","552423255242","irv","@irev");
		    Contact marco = new Contact("Marco","irv@gmail.com","552423255242","irv","@irev");
		    Contact ricardo = new Contact("Ricardo Centeno","ricardo.celj@gmail.com","5514382887","ricardo.centeno.lugo","@rickstart");
		    Contact[] contacts = new Contact[]{irving, antonio, jose, alex, marco, ricardo};
		    

		    MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, contacts);
		
		    listview.setAdapter(adapter);
		    

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
