package com.example.ugcsap2013;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Dbview extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);
		TextView tv=(TextView)findViewById(R.id.textView1);
	}
	
	

}
