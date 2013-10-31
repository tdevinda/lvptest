package lk.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBModule {
	public static final String DBNAME = "userdb";
	public static final String TABLENAME = "users";
	
	public void addToDB(Context context, String user, String number) {
		DBHelper helper = new DBHelper(context);
		SQLiteDatabase db = helper.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("name", user);
		values.put("number", number);
		
		db.insert("users", null, values);
		db.close();
		helper.close();
		
	}
	
	private class DBHelper extends SQLiteOpenHelper {

		public DBHelper(Context context) {
			super(context, DBNAME, null, 1);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			
			db.execSQL("create table users (name text, number text)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
