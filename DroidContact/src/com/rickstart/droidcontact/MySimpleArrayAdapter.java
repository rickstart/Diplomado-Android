package com.rickstart.droidcontact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MySimpleArrayAdapter extends ArrayAdapter<Contact> {
	  private final Context context;
	  private final Contact[] contacts;
	  
	  String number;
	  Intent intent;

	  public MySimpleArrayAdapter(Context context, Contact[] contacts) {
	    super(context, R.layout.item_list, contacts);
	    this.context = context;
	    this.contacts = contacts;
	    
	  }

	  @Override
	  public View getView(final int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.item_list, parent, false);
	   
	    TextView textView = (TextView) rowView.findViewById(R.id.name);
	    ImageButton phone = (ImageButton) rowView.findViewById(R.id.call);
	    ImageButton whats = (ImageButton) rowView.findViewById(R.id.whats);
	    ImageButton sms = (ImageButton) rowView.findViewById(R.id.sms);
	    ImageButton email = (ImageButton) rowView.findViewById(R.id.email);
	    ImageButton face = (ImageButton) rowView.findViewById(R.id.face);
	    
	   	textView.setText(contacts[position].getName());
	   
	
	  
	    phone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				intent = new Intent(Intent.ACTION_DIAL);
			    intent.setData(Uri.parse("tel:"+contacts[position].getPhone()));

			    context.startActivity(intent);
			}
		});
	    
	    whats.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				PackageManager pm = context.getPackageManager();
			    try {

			        Intent waIntent = new Intent(Intent.ACTION_SEND);
			        waIntent.setType("text/plain");
			        String text = "YOUR TEXT HERE";

			        PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
			        //Check if package exists or not. If not then code 
			        //in catch block will be called
			        waIntent.setPackage("com.whatsapp");

			            waIntent.putExtra(Intent.EXTRA_TEXT, text);
			            context.startActivity(Intent.createChooser(waIntent, "Share with"));

			   } catch (NameNotFoundException e) {
			        Toast.makeText(context, "WhatsApp not Installed", Toast.LENGTH_SHORT)
			                .show();
			   }  
				
			}
		});
	    
	    	sms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

			    try {
			    	intent = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms", contacts[position].getPhone(),null));
				 context.startActivity(intent);

			   } catch (Exception e) {
			        Toast.makeText(context, "SMS not Installed", Toast.LENGTH_SHORT)
			                .show();
			   }  
				
			}
		});
	    	
	       	email.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {

				    try {
				    	Intent intent = new Intent(Intent.ACTION_SEND);
				    	intent.setType("text/plain");
				    	intent.putExtra(Intent.EXTRA_EMAIL, contacts[position].getEmail());
				    	intent.putExtra(Intent.EXTRA_SUBJECT, "Greetings");
				    	intent.putExtra(Intent.EXTRA_TEXT, "Hey dude what's up");

				    	context.startActivity(Intent.createChooser(intent, "Send Email"));

				   } catch (Exception e) {
				        Toast.makeText(context, "Email not Installed", Toast.LENGTH_SHORT)
				                .show();
				   }  
					
				}
			});
	       	
	    	face.setOnClickListener(new OnClickListener() {
				
			@Override
			public void onClick(View arg0) {
				try {
					intent = new Intent(Intent.ACTION_VIEW,
								Uri.parse("http://www.facebook.com/"+contacts[position].getFacebook()));
					context.startActivity(intent);
	
					 } catch (Exception e) {
						 Toast.makeText(context, "Email not Installed", Toast.LENGTH_SHORT)
						                .show();
					 }  
							
			}
	    	});
	    	


	    return rowView;
	  }
	  
		public static class ViewHolder {
			
			TextView textView;
		    ImageButton phone;
		}
	} 