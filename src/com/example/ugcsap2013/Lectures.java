package com.example.ugcsap2013;

import android.app.Activity;
import android.graphics.AvoidXfermode.Mode;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Lectures extends Activity{
	
	
	Button time,date;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lectures);
        String[] items = new String[] {"Seminars", "Tutorials", "Practical","Lecture Time"};
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        time=(Button)findViewById(R.id.Time);
        time.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFFFFFFF));
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
        
		
    }
	
	
}
