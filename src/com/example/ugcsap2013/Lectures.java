package com.example.ugcsap2013;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.AvoidXfermode.Mode;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.NumberPicker.OnValueChangeListener;


public class Lectures extends Activity implements TextWatcher{
	
	
	Button time,date;
     
	AutoCompleteTextView myAutoComplete,myAutoComplete1;
	String item[]={
	  "cse", "it", "mca", "Ece",
	  
	};
	
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
				
			final	 Dialog dialog = new Dialog(context);
			View view = getLayoutInflater().inflate(R.layout.customtime, null);
			dialog.setContentView (view);
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
				dialog.setTitle("Time");
				dialog.show();
				
			}
		});
        date=(Button)findViewById(R.id.Date);
        date.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFFFFFFF));
        String[] items2 = new String[] {"Nationl", "States", "University","College","International"};
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, items2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        String[] items3 = new String[] {"Aloweted", "Extra"};
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, items3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
 myAutoComplete1 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
        
        myAutoComplete1.addTextChangedListener(this);
        myAutoComplete1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item));
		
        myAutoComplete = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        
        myAutoComplete.addTextChangedListener(this);
        myAutoComplete.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item));
       
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
