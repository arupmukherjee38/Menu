package com.example.ugcsap2013;

import java.lang.reflect.Type;
import java.text.DateFormatSymbols;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.text.InputType;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Jurnal extends Activity implements OnClickListener{
Button save,date,impact;
EditText title,pageno,yop,isbn,noofauth;
DatePicker d;
Calendar c;
RadioGroup r,mauth;
RadioButton x,mauthb;
static final int DATE_DIALOG_ID = 1;
private int year, month, day;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jurnal);
		connectxml();		
       
        date.setOnClickListener(this);		
		save.setOnClickListener(this);		
		impact.setOnClickListener(this);

		final Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);  		
		
	}
	protected void connectxml() {
		title=(EditText)findViewById(R.id.jouredView1);
		pageno=(EditText) findViewById(R.id.jouredView2);
		yop=(EditText) findViewById(R.id.jouredView3);
		isbn=(EditText) findViewById(R.id.jouredView4);
		noofauth=(EditText) findViewById(R.id.jouredView5);
		date = (Button)findViewById(R.id.jourDate);
		save=(Button)findViewById(R.id.jouraccessGraphe);
		r=(RadioGroup) findViewById(R.id.jourreffered);
		mauth=(RadioGroup) findViewById(R.id.jourmainauth);
		impact=(Button) findViewById(R.id.jourImpact);
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.jouraccessGraphe:
			int selectedId = r.getCheckedRadioButtonId();
			 
			// find the radiobutton by returned id
		    x = (RadioButton) findViewById(selectedId);
		    
		    int selectedIdm=mauth.getCheckedRadioButtonId();
		    mauthb=(RadioButton) findViewById(selectedIdm);
			String s="Title :"+title.getText().toString()+"\nPage No :"+pageno.getText().toString()+"\nYOP :"+yop.getText().toString()+"\nReffered or not :"+x.getText().toString()+"\nIsbn :"+isbn.getText().toString()+"\nMain Author ? :"+mauthb.getText().toString()+"\nNo Of Author :"+noofauth.getText().toString();
			Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
			break;
			
			//When date button clicked this case will do its job
		case  R.id.jourDate: 		
			
			showDialog(DATE_DIALOG_ID);           
			
			break;
			
			//When Impact button clicked this case will do its job
			
			case R.id.jourImpact:
				
				//setting alert dialouge box for Impact factor
				AlertDialog.Builder alert = new AlertDialog.Builder(this);				
				alert.setTitle("Impact Factor");
				alert.setMessage("Enter Impact factor 1 to 10");

				// Set an EditText view to get user input 
				final EditText input = new EditText(this);
				input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
				alert.setView(input);

				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
				  String value = input.getText().toString();
				  // Do something with value!
				  }
				});

				alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				  public void onClick(DialogInterface dialog, int whichButton) {
				    // Canceled.
				  }
				});
				
				alert.show();
				
			break;

		
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
	 protected Dialog onCreateDialog(int id) {
         switch (id) {
         case DATE_DIALOG_ID:
        	 return new DatePickerDialog(this, dateListener, year, month, day);
         
         }
         return null;
     }
	
	

}
