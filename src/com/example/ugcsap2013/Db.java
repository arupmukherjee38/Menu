package com.example.ugcsap2013;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.ugcsap2013.Journalpojo;

public class Db extends SQLiteOpenHelper{
	
	

	//Data table field for Lecture
	public static final String KEY_ROWID="_id";
	public static final String KEY_NAME="Work Type";
	public static final String KEY_TIME="Time"; 
	public static final String KEY_DATE="Date";
	public static final String KEY_PAPER="Paper";
	public static final String KEY_WHERE="Where1";
	public static final String KEY_MODE="MODE";
	public static final String KEY_NOTE="Note";
	
	//Data table field for Journal
	public static final String KEY_ROWIDJOUR="id";
	public static final String KEY_JOURTITLE="title";
	public static final String KEY_JOURPAGENO="pageNo";
	public static final String KEY_JOURYOP="yop";
	public static final String KEY_JOURISBN="isbn";
	public static final String KEY_JOURDATE="date";
	public static final String KEY_JOURIMPACT="impFact";
	public static final String KEY_JOURNO_OF_AUTH="noOfAuth";
	public static final String KEY_JOURREFF="reff";
	public static final String KEY_JOURMAIN_AUTH="mainAuth";
	
	public static final String JOUR_DATA_TABLE="Journal";
	
	public static final String KEY_ROWIDCONF="id";
	public static final String KEY_CONFTITLE="title";
	public static final String KEY_CONFPAGENO="pageNo";
	public static final String KEY_CONFYOP="yop";
	public static final String KEY_CONFISBN="isbn";
	public static final String KEY_CONFDATE="date";
	public static final String KEY_CONFTIME="time";
	public static final String KEY_CONFNO_OF_AUTH="noOfAuth";
	public static final String KEY_CONFLOC="loc";
	public static final String KEY_CONFMAIN_AUTH="mainAuth";
	
	public static final String CONF_DATA_TABLE="Conference";
	
	
	
	public static final String DATABASE_NAME="TAKEHour.db";
	public static final String DATABASE_TABLE="Lecture";
	public static final int DATABASE_VERSION=1;
	
	 public Db(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }

	
	
	
	

	

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + "(" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_NAME + " TEXT NOT NULL, " + KEY_TIME + " INTEGER NOT NULL, "
					+ KEY_DATE + " TEXT NOT NULL, " + KEY_PAPER + " TEXT NOT NULL, "
					 + KEY_WHERE + " TEXT NOT NULL, " + KEY_MODE + " TEXT NOT NULL, "
					 + KEY_NOTE + " TEXT NOT NULL);"
					
					
					
					
		);
			//Creating Jounal Table
			db.execSQL("CREATE TABLE " + JOUR_DATA_TABLE + "(" +
					KEY_ROWIDJOUR + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_JOURTITLE + " TEXT NOT NULL, " + KEY_JOURPAGENO + " TEXT NOT NULL, "
					+ KEY_JOURYOP + " TEXT NOT NULL, " + KEY_JOURISBN + " TEXT NOT NULL, "
					 + KEY_JOURDATE + " TEXT NOT NULL, " + KEY_JOURIMPACT + " TEXT NOT NULL, "
					 + KEY_JOURREFF + " TEXT NOT NULL,"+KEY_JOURMAIN_AUTH + " TEXT NOT NULL,"+ KEY_JOURNO_OF_AUTH + " TEXT NOT NULL);"
					 
					 );
			
			//Creating Conference Table
			
			db.execSQL("CREATE TABLE " + CONF_DATA_TABLE + "(" +
					KEY_ROWIDCONF + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_CONFTITLE + " TEXT NOT NULL, " + KEY_CONFPAGENO + " TEXT NOT NULL, "
					+ KEY_CONFYOP + " TEXT NOT NULL, " + KEY_CONFISBN + " TEXT NOT NULL, "
					 + KEY_CONFDATE + " TEXT NOT NULL, " + KEY_CONFTIME + " TEXT NOT NULL, "
					 + KEY_CONFLOC + " TEXT NOT NULL,"+KEY_CONFMAIN_AUTH + " TEXT NOT NULL,"+ KEY_CONFNO_OF_AUTH + " TEXT NOT NULL);"
					 
					 );
			
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
			db.execSQL("DROP TABLE IF EXITS"+DATABASE_TABLE);
			onCreate(db);
			
		}
		
	
	

	/*public long createntry(String spin1, int time, String date,
			String auto1, String spin2, String spin3, String auto2) {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(KEY_NAME, spin1);
		cv.put(KEY_TIME, time);
		cv.put(KEY_DATE,date);
		cv.put(KEY_PAPER, auto1);
		cv.put(KEY_WHERE, spin2);
		cv.put(KEY_MODE, spin3);
		cv.put(KEY_NOTE, auto2);
	    return	ourDatabase.insert(DATABASE_TABLE, null, cv);
		
		
	}*/
	public void createJourEntry(Journalpojo jourpojo)
	{
		 SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put(KEY_JOURTITLE,jourpojo.getTitle());
		cv.put(KEY_JOURPAGENO, jourpojo.getPageNo());
		cv.put(KEY_JOURYOP,jourpojo.getYop());
		cv.put(KEY_JOURISBN, jourpojo.getIsbn());
		cv.put(KEY_JOURDATE, jourpojo.getDate());
		cv.put(KEY_JOURNO_OF_AUTH,jourpojo.getNoOfAuth());
		cv.put(KEY_JOURIMPACT, jourpojo.getImpFact());
		cv.put(KEY_JOURMAIN_AUTH, jourpojo.getMainAuth());
		db.insert(JOUR_DATA_TABLE, null, cv);
		db.close(); 
	}
	
	public void createConfEntry(Confpojo confpojo)
	{
		 SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put(KEY_CONFTITLE,confpojo.getTitle());
		cv.put(KEY_CONFPAGENO, confpojo.getPageNo());
		cv.put(KEY_CONFYOP,confpojo.getYop());
		cv.put(KEY_CONFISBN, confpojo.getIsbn());
		cv.put(KEY_CONFDATE, confpojo.getDate());
		cv.put(KEY_CONFNO_OF_AUTH,confpojo.getNoOfAuth());
		cv.put(KEY_CONFLOC, confpojo.getLoc());
		cv.put(KEY_CONFTIME, confpojo.getTime());
		cv.put(KEY_CONFMAIN_AUTH, confpojo.getMainAuth());
		db.insert(CONF_DATA_TABLE, null, cv);
		db.close(); 
	}
	
	public ArrayList<Journalpojo> listjur(){
		
		
		
		ArrayList<Journalpojo> contactList = new ArrayList<Journalpojo>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + JOUR_DATA_TABLE;
	 
	    SQLiteDatabase db = this.getReadableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            Journalpojo Journalpojo = new Journalpojo(cursor.getString(0), cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
	            // Adding Journalpojo to list
	            contactList.add(Journalpojo);
	        } while (cursor.moveToNext());
	    }
	 
	    // return Journalpojo list
	    return contactList;		
		
	}
	
	public void createntry(Dbsetandget dbsetandget) {
		// TODO Auto-generated method stub
		 SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put(KEY_NAME, dbsetandget.getSpin1());
		cv.put(KEY_TIME, dbsetandget.getTime());
		cv.put(KEY_DATE, dbsetandget.getDate());
		cv.put(KEY_PAPER, dbsetandget.getAuto1());
		cv.put(KEY_WHERE, dbsetandget.getSpin2());
		cv.put(KEY_MODE, dbsetandget.getSpin3());
		cv.put(KEY_NOTE, dbsetandget.getAuto2());
		db.insert(DATABASE_TABLE, null, cv);
		db.close();
		
	}
}
