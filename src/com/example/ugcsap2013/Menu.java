package com.example.ugcsap2013;

import com.example.ugcsap2013.adapter.UgcsapArryAdapter;


import android.R.string;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.app.ListActivity;
//import android.view.Menu;
import android.content.Intent;

public class Menu extends ListActivity {

	static final String[] item = { "Lectures", "Teaching Duty",
		"Reserch", "Publication"};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new UgcsapArryAdapter(this, item));
		
    }

    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		//get selected items
		String selectedValue = (String) getListAdapter().getItem(position);
		try{
			Class ourClass=Class.forName("com.example.ugcsap2013."+selectedValue);
			Intent intent=new Intent(this,ourClass);
			startActivity(intent);
			finish();

			}catch(ClassNotFoundException e)
			{
			e.printStackTrace();
			}

		//Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();

	} 
 
    
}
