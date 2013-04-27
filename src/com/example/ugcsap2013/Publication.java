package com.example.ugcsap2013;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Publication extends TabActivity{

    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.pubtab);
    	
    	TabHost tb=getTabHost();
    	Resources resources = getResources(); 
    	TabSpec jurnal = tb.newTabSpec("Jurnal");
    	
        // setting Title and Icon for the Tab
        jurnal.setIndicator("", resources.getDrawable(R.drawable.jurnal));
        Intent jurnalIntent = new Intent(this, Jurnal.class);
        jurnal.setContent(jurnalIntent);
        tb.addTab(jurnal);
        TabSpec art = tb.newTabSpec("art");
        art.setIndicator(null, resources.getDrawable(R.drawable.research));
        Intent mineIntent = new Intent(this, Article.class);
        art.setContent(mineIntent);        
        tb.addTab(art);
        
        TabSpec conf = tb.newTabSpec("conf");
        conf.setIndicator(null,resources.getDrawable(R.drawable.research));
        Intent confIntent = new Intent(this,Conference.class);
        conf.setContent(confIntent);        
        tb.addTab(conf);
        
        TabSpec book = tb.newTabSpec("book");
        book.setIndicator(null,resources.getDrawable(R.drawable.research));
        Intent bookIntent = new Intent(this,Book.class);
        book.setContent(bookIntent);      
        tb.addTab(book);
        
       }
}

