package Dama_Database;
/**Raffaella*/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;

/**This class is responsible for creating the database.
 * SQLiteDatabase is the base class for working with a SQLite database in Android and 
 * provides methods to open, query, update and close the database.
 * More specifically SQLiteDatabase provides the insert(), update() and delete() methods.
 * In addition it provides the execSQL() method, which allows to execute SQL directly.*/

public class DatabaseStorageUtente extends SQLiteOpenHelper  {
	
	static final String TABLE_UTENTE = "Utente";

	static final String COLUMN_ID="id";
	static final String COLUMN_NAME="nome";
	static final String COLUMN_SURNAME="surname";
	static final String COLUMN_EMAIL="email";
	static final String COLUMN_PASSWORD="password";
	
	static final int COLUMN_ID_INDEX=0;
	static final int COLUMN_NAME_INDEX=1;
	static final int COLUMN_SURNAME_INDEX=2;;
	static final int COLUMN_EMAIL_INDEX=3;
	static final int COLUMN_PASSWORD_INDEX=4;
	
	private  static  final  int DATABASE_VERSION =  1;
	private static final String DATABASE_NAME= "Utente.db";
	
	private static final String DATABASE_CREATE = "create table" + TABLE_UTENTE + "("
			+ COLUMN_ID + " _id vachar(45) PRIMARY KEY, "
			+ COLUMN_NAME + " vachar(15) NOT NULL,"
			+ COLUMN_SURNAME + " vachar(15) NOT NULL,"
			+ COLUMN_EMAIL + " vachar(15) NOT NULL,"
			+ COLUMN_PASSWORD + " vachar(15) NOT NULL,"
			+ ");";

	public DatabaseStorageUtente(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DatabaseStorageUtente.class.getName(),"Upgrading database from version " + oldVersion 
				+ "to" + newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS "+ TABLE_UTENTE);
		onCreate(db);
	}

}
