package com.rickstart.intentsamples;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.rickstart.intentsamples.R;

public class MainActivity extends Activity {
	
	Button btn_second;
	Button btn_call;
	Button btn_camera;
	Button btn_browser;
	
	Intent intent = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_second = (Button) findViewById(R.id.btn_second);
		btn_call = (Button) findViewById(R.id.btn_call);
		btn_camera = (Button) findViewById(R.id.btn_camera);
		btn_browser = (Button) findViewById(R.id.btn_browser);
		
		btn_second.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(getApplicationContext(),SecondActivity.class);
				intent.putExtra("name", "Ricardo");
				startActivity(intent);
				
			}
		});
		
		btn_call.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(Intent.ACTION_CALL,
				          Uri.parse("tel:(+49)12345789"));
				      startActivity(intent);
			}
		});
		
		btn_camera.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent("android.media.action.IMAGE_CAPTURE");
				startActivity(intent);
				
			}
		});
		
		btn_browser.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 intent = new Intent(Intent.ACTION_VIEW,
				          Uri.parse("http://www.google.com"));
				 startActivity(intent);
				
			}
		});
		
		
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
