package com.example.ugcsap2013;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Reserch extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.res);
		
		
		
		
		Db db = new Db(this);
		
		  ArrayList<Journalpojo> contacts = db.listjur();       
	         
	        for (Journalpojo cn : contacts) {
	            String log = "Id: "+cn.getTitle()+" ,Name: " + cn.getNoOfAuth() + " ,Phone: " + cn.getIsbn();
	            Toast.makeText(getApplicationContext(), "hdbdbd",Toast.LENGTH_SHORT).show();
	            Toast.makeText(getApplicationContext(), log,Toast.LENGTH_LONG).show();
	        
	        }
	        
	        
	        
		
		
	
	

	}}
