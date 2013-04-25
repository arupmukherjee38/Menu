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
        jurnal.setIndicator(null, resources.getDrawable(R.drawable.jurnalset));
        Intent jurnalIntent = new Intent(this, Jurnal.class);
        jurnal.setContent(jurnalIntent);
        tb.addTab(jurnal);
        TabSpec mine = tb.newTabSpec("mine");
        mine.setIndicator(null, resources.getDrawable(R.drawable.research));
        Intent mineIntent = new Intent(this, Article.class);
        mine.setContent(mineIntent);
        
        tb.addTab(mine);
       // tb.addTab(Conference);
       // tb.addTab(bookPublished);
    }
}

