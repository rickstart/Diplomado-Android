package com.rickstart.droidcontact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
	  private final Context context;
	  private final String[] values;
	  private final String[] phones;
	  String number;
	  Intent intent;

	  public MySimpleArrayAdapter(Context context, String[] values, String[] phones) {
	    super(context, R.layout.item_list, values);
	    this.context = context;
	    this.values = values;
	    this.phones = phones;
	  }

	  @Override
	  public View getView(int position, View convertView, final ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.item_list, parent, false);
	   
	    TextView textView = (TextView) rowView.findViewById(R.id.name);
	    ImageButton phone = (ImageButton) rowView.findViewById(R.id.call);
	   	textView.setText(values[position]);
	   
	    number = phones[position];
	  
	    phone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				intent = new Intent(Intent.ACTION_DIAL);
			    intent.setData(Uri.parse("tel:"+number));

			    context.startActivity(intent);
			}
		});
	    
	   
	    String s = values[position];

	    return rowView;
	  }
	  
		public static class ViewHolder {
			
			TextView textView;
		    ImageButton phone;
		}
	} 