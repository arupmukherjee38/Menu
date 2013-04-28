package com.example.ugcsap2013;

import java.text.DateFormatSymbols;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Spinner;



public class Lectures extends Activity implements TextWatcher{
	
	
	Button time,date,course,note,save;
	TextView tv;
   AlertDialog dialog;
   static final int dialog_id=1;
	AutoCompleteTextView myAutoComplete1 ;
	String item[]={
	  "cse", "it", "mca", "Ece",
	  
	};
	static StringBuilder datepic;
	  int minits;
	 String s;
	 String s11,s1,s2,s3,datepica;
	
	final Context context = this;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lectures);
        String[] items = new String[] {"Seminars", "Tutorials", "Practical","Lecture Time"};
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        s1=spinner.getSelectedItem().toString();
      //  np1=(NumberPicker)findViewById(R.id.numberPicker1);
     // np1.setMaxValue(12);
      // np1.setMinValue(0);
     //   np1.setWrapSelectorWheel(false);
        time=(Button)findViewById(R.id.Time);
        time.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFFFFFFF));
        time.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			//LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
			View v=getLayoutInflater().inflate(R.layout.customtime, null);
		//	NumberPicker np1=(NumberPicker)v.findViewById(R.id.numberPicker1);
		//	np1.setMaxValue(12);
		//	np1.setMinValue(1);
		//	NumberPicker np2=(NumberPicker)v.findViewById(R.id.numberPicker2);
		//	np2.setMaxValue(60);
		//	np2.setMinValue(1);
			final TimePicker t1=(TimePicker)v.findViewById(R.id.timePicker1);
			t1.setIs24HourView(true);
            t1.setCurrentHour(0);
            t1.setCurrentMinute(0);
			AlertDialog.Builder build=new AlertDialog.Builder(Lectures.this);
			build.setTitle("Time");
			build.setView(v);
			build.setPositiveButton("ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					int h=t1.getCurrentHour();
					int m=t1.getCurrentMinute();
					//Toast.makeText(Lectures.this,String.valueOf(h)+"hours"+String.valueOf(m)+"minutes", Toast.LENGTH_LONG).show();
					time.setText("Time"+"\n"+Integer.toString(h)+" "+"Hours"+" "+Integer.toString(m)+" "+"Minutes");
                    minits=m+(h*60);
                     
					
				}
			});
			build.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					
				}
			});
		   
		       dialog = build.create();
		       dialog.show();
		        //dialog.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFFFFFFF));
				//dialog.setContentView(R.layout.customtime);
			//NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker1);
		  //  String[] nums = new String[20];
		  //  for(int i=0; i<nums.length; i++)
		  //         nums[i] = Integer.toString(i);
		  //  np.setMaxValue(20);
		//   np.setMinValue(1);
		   
		//   np.setWrapSelectorWheel(false);
		//   np.setDisplayedValues(nums);
		//   np.setValue(1);
				
				
			}
		});
        date=(Button)findViewById(R.id.Date);
        date.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFFFFFFF));
        date.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			View v=getLayoutInflater().inflate(R.layout.customdate, null);
			final DatePicker d=(DatePicker)v.findViewById(R.id.dpResult);
			final Calendar c=Calendar.getInstance();
			int year=c.get(Calendar.YEAR);
			int Month=c.get(Calendar.MONTH);
			int day=c.get(Calendar.DAY_OF_MONTH);
			d.init(year, Month, day, null);
			d.updateDate(year, Month, day);
			AlertDialog.Builder build=new AlertDialog.Builder(Lectures.this);
			build.setTitle("Date");
			build.setView(v);
			build.setPositiveButton("ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					int day=d.getDayOfMonth();
					int month=d.getMonth()+1;
					int year=d.getYear();
					String monthString = new DateFormatSymbols().getMonths()[month];;
                     datepica=day+"-"+monthString+"-"+year;
					date.setText("Date"+"\n"+Integer.toString(day)+"  "+monthString+"  "+Integer.toString(year));
					//Toast.makeText(Lectures.this,String.valueOf(day)+"/"+String.valueOf(mouth)+"/"+String.valueOf(year), Toast.LENGTH_LONG).show();
				}
			});
            build.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					
				}
			});
		   
		       dialog = build.create();
		       dialog.show();
			
			
			}
			
		});
        String[] items2 = new String[] {"Nationl", "States", "University","College","International"};
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, items2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        s2=spinner2.getSelectedItem().toString();
        String[] items3 = new String[] {"Aloweted", "Extra"};
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, items3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        s3=spinner3.getSelectedItem().toString();
        Toast.makeText(this, s3, Toast.LENGTH_LONG).show();
        
      //  myAutoComplete1 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
        
      //  myAutoComplete1.addTextChangedListener(this);
      //  myAutoComplete1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item));
		course=(Button)findViewById(R.id.Course);
		course.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFFFFFFF));
		course.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				View v=getLayoutInflater().inflate(R.layout.customautocomple, null);
				 final AutoCompleteTextView myAutoComplete = (AutoCompleteTextView)v.findViewById(R.id.autoCompleteTextView1);
		        
		        myAutoComplete.addTextChangedListener(Lectures.this);
		        myAutoComplete.setAdapter(new ArrayAdapter<String>(Lectures.this, android.R.layout.simple_dropdown_item_1line, item));
		        AlertDialog.Builder build=new AlertDialog.Builder(Lectures.this);
				build.setTitle("Course/paper");
				build.setView(v);
				build.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						 s11 = myAutoComplete.getEditableText().toString();
						Toast.makeText(Lectures.this,s11, Toast.LENGTH_LONG).show();
						course.setText("Course/paper"+"\n"+s11);
					}
				});
	            build.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						
					}
				});

	            dialog = build.create();
			       dialog.show();
				
		        
		        
			}
			
		});
		note = (Button)findViewById(R.id.Note);
		note.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFFFFFFF));
		note.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				View v1=getLayoutInflater().inflate(R.layout.customautofornote, null);
				 final AutoCompleteTextView myAutoComplete1 = (AutoCompleteTextView)v1.findViewById(R.id.autoCompleteTextView2);
		        
		        myAutoComplete1.addTextChangedListener(Lectures.this);
		        myAutoComplete1.setAdapter(new ArrayAdapter<String>(Lectures.this, android.R.layout.simple_dropdown_item_1line, item));
		        AlertDialog.Builder build=new AlertDialog.Builder(Lectures.this);
				build.setTitle("Note");
				build.setView(v1);
				build.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					 s = myAutoComplete1.getEditableText().toString();
						Toast.makeText(Lectures.this,s, Toast.LENGTH_LONG).show();
						
					}
				});
	            build.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						
					}
				});

	            dialog = build.create();
			       dialog.show();
				
		        
		        
			}
			
		});
		
		
	save=(Button)findViewById(R.id.accessGraphe);
	save.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			String auto1=s;
			String auto2=s11;
			String spin1=s1;
			String spin2=s2;
			String spin3=s3;
			int time=minits;
			String date=datepica; 
			Db entry=new Db(Lectures.this);
			//entry.open();
			
			entry.createntry(new Dbsetandget(spin1,time,date,auto1,spin2,spin3,auto2));
			Dialog d1=new Dialog(Lectures.this);
			d1.setTitle("Sucess");
			TextView tv=new TextView(Lectures.this);
			tv.setText("Suc");
			d1.setContentView(tv);
			
			
			d1.show();
			
		
		}});
        
       
    }
	@Override
	public void afterTextChanged(Editable arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	
	
}
