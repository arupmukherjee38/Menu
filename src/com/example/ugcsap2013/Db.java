package com.example.ugcsap2013;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class Db {

	public static final String KEY_ROWID="_id";
	public static final String KEY_NAME="Work Type";
	public static final String KEY_TIME="Time"; 
	public static final String KEY_DATE="Date";
	public static final String KEY_PAPER="Paper";
	public static final String KEY_WHERE="Where1";
	public static final String KEY_MODE="MODE";
	public static final String KEY_NOTE="Note";
	
	
	public static final String DATABASE_NAME="TAKE Hour";
	public static final String DATABASE_TABLE="Lecture";
	public static final int DATABASE_VERSION=1;
	
	
	private Dbhelper ourdbDbhelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	public static class Dbhelper extends SQLiteOpenHelper{

		public Dbhelper(Context context) {
			super(context, DATABASE_NAME, null,DATABASE_VERSION);
			// TODO Auto-generated constructor stub
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
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
			db.execSQL("DROP TABLE IF EXITS"+DATABASE_TABLE);
			onCreate(db);
			
		}
		
	}
	
	public Db(Context c)
	{
		ourContext=c;
	}
	public Db open() throws SQLiteException{
	
		ourdbDbhelper=new Dbhelper(ourContext);
		ourDatabase=ourdbDbhelper.getWritableDatabase();
		return this;
	}
	public void close(){
		ourdbDbhelper.close();
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
	public void createntry(Dbsetandget dbsetandget) {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(KEY_NAME, dbsetandget.getSpin1());
		cv.put(KEY_TIME, dbsetandget.getTime());
		cv.put(KEY_DATE, dbsetandget.getDate());
		cv.put(KEY_PAPER, dbsetandget.getAuto1());
		cv.put(KEY_WHERE, dbsetandget.getSpin2());
		cv.put(KEY_MODE, dbsetandget.getSpin3());
		cv.put(KEY_NOTE, dbsetandget.getAuto2());
		ourDatabase.insert(DATABASE_TABLE, null, cv);
		
	}
}
