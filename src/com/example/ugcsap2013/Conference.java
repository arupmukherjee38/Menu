package com.example.ugcsap2013;



import java.text.DateFormatSymbols;
import java.util.Calendar;

import com.example.ugcsap2013.R.id;

import android.R.color;
import android.R.layout;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Conference extends Activity implements OnClickListener{

	Button save,date,time,loc;
	EditText title,pageno,yop,isbn,noofauth;
	DatePicker d;
	AutoCompleteTextView auto;
	
	RadioGroup mainAuth;
	RadioButton x;
	
	static final int DATE_DIALOG_ID = 1,TIME_DIALOG_ID=2,AUTO_COMPLETE=3;
	private int year, month, day,hour,min;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.conference);
		connectxml();	
		final Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);  	
        
        hour = cal.get(Calendar.HOUR_OF_DAY);
		min = cal.get(Calendar.MINUTE);
        
		date.setOnClickListener(this);
		time.setOnClickListener(this);
		loc.setOnClickListener(this);
		save.setOnClickListener(this);
	}
	
	protected void connectxml() {
		title=(EditText)findViewById(R.id.confedView1);
		pageno=(EditText) findViewById(R.id.confpage_no_edit);
		yop=(EditText) findViewById(R.id.confyop_edit);
		isbn=(EditText) findViewById(R.id.confisbn_edit);
		noofauth=(EditText) findViewById(R.id.confno_of_auth_edit);
		date = (Button)findViewById(R.id.conf_date);
		time=(Button)findViewById(R.id.conf_time);
		save=(Button)findViewById(R.id.confaccessGraphe);
		loc=(Button) findViewById(R.id.conf_loc);
		mainAuth=(RadioGroup) findViewById(R.id.confmainauth);
		
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.conf_date:	
			showDialog(DATE_DIALOG_ID);
			break;
		case R.id.conf_time:
				showDialog(TIME_DIALOG_ID);			
			break;
		case R.id.conf_loc:
			
			AlertDialog.Builder a=new AlertDialog.Builder(Conference.this);
			a.setTitle("Conference Location");
			a.setMessage("Enter Location");
			auto=new AutoCompleteTextView(Conference.this);
			auto.setBackgroundColor(Color.WHITE);
			auto.setThreshold(1);
			auto.setDropDownBackgroundResource(color.black);
			auto.setFocusable(true);
			auto.setFocusableInTouchMode(true);
			auto.setHint("Location");
			
			final String location[]=getResources().getStringArray(R.array.location_array);
			ArrayAdapter<String> locarray=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,location);
			auto.setAdapter(locarray);
			a.setView(auto);
			a.setPositiveButton("ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
					loc.setText("Location\n"+auto.getText().toString());
				}
			});
            a.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					
				}
			});
			
			a.show();
			
			
			break;
			
			
		case R.id.confaccessGraphe:
				
			int selectedIdm=mainAuth.getCheckedRadioButtonId();
		    x=(RadioButton) findViewById(selectedIdm);
		    
		    String monthString = new DateFormatSymbols().getMonths()[month];;
		    String datedb=day+"-"+monthString+"-"+year;
		    String timedb=Integer.toString(hour)+" : "+Integer.toString(min);
		    Boolean work=true;
		    
		    String test=title.getText().toString()+ pageno.getText().toString()+
			yop.getText().toString()+ isbn.getText().toString()+ datedb+ 
			timedb+auto.getText().toString()+noofauth.getText().toString()+ x.getText().toString();
		    
		    Toast.makeText(getApplicationContext(), test,Toast.LENGTH_SHORT).show();
		    
				Db confentry=new Db(Conference.this);
				
				
				
				
				confentry.createConfEntry(new Confpojo(title.getText().toString(), pageno.getText().toString(),
						yop.getText().toString(), isbn.getText().toString(), datedb, 
						timedb,auto.getText().toString(),noofauth.getText().toString(), x.getText().toString()));
				
		
				// TODO Auto-generated catch block
				
				Dialog d1=new Dialog(Conference.this);
				d1.setTitle("Sucess");
				TextView tv=new TextView(Conference.this);
				tv.setText("Suc");
				d1.setContentView(tv);
				
				
				d1.show();
			
		    String s="Title :"+title.getText().toString()+"\nPage No :"+pageno.getText().toString()+"\nYOP :"+yop.getText().toString()+"\nLocation  :"+auto.getText().toString()+"\nIsbn :"+isbn.getText().toString()+"\nMain Author ? :"+x.getText().toString()+"\nNo Of Author :"+noofauth.getText().toString()+"\nTime :"+timedb+"\nDate  :"+datedb;
		    Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
			break;

	//	default:
		//	break;
		}
		
	}
	
	private DatePickerDialog.OnDateSetListener dateListener = 
	        new DatePickerDialog.OnDateSetListener() {

	            @Override
	            public void onDateSet(DatePicker view, int yr, int monthOfYear,
	                    int dayOfMonth) {
	                year = yr;
	                month = monthOfYear;
	                day = dayOfMonth;
	                String monthString = new DateFormatSymbols().getMonths()[month];;
	                date.setText("Date"+"\n"+Integer.toString(day)+"  "+monthString+"  "+Integer.toString(year));
	               
	            }
	    };
	    private TimePickerDialog.OnTimeSetListener timeListener=new TimePickerDialog.OnTimeSetListener(){

			@Override
			public void onTimeSet(TimePicker arg0, int hr, int mn) {
				// TODO Auto-generated method stub
				hour=hr;
				min=mn;
			
				time.setText("Time\n"+Integer.toString(hour)+" : "+Integer.toString(min));
			}
	    	
	    };
	
	    
	protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DATE_DIALOG_ID:
       	 return new DatePickerDialog(this, dateListener, year, month, day);
       	
       	case TIME_DIALOG_ID:
       	 return new TimePickerDialog(this, timeListener, hour, min,Boolean.TRUE);
       
        }
        return null;
    }
	

}

