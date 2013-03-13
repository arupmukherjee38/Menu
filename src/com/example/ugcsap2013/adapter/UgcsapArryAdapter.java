package com.example.ugcsap2013.adapter;




import com.example.ugcsap2013.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UgcsapArryAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;

	public UgcsapArryAdapter(Context context, String[] values) {
		super(context, R.layout.menu, values);
		this.context = context;
		this.values = values;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.menu, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.title);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.list_image);
		textView.setText(values[position]);

		// Change icon based on name
		String s = values[position];

		System.out.println(s);

		if (s.equals("Lectures")) {
			imageView.setImageResource(R.drawable.download);
		} else if (s.equals("Teaching Duty")) {
			imageView.setImageResource(R.drawable.download1);
		} else if (s.equals("Reserch")) {
			imageView.setImageResource(R.drawable.download2);
		} else {
			imageView.setImageResource(R.drawable.download3);
		}

		return rowView;
	}
}
