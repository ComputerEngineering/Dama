package Dama_Database;

import java.util.ArrayList;
import java.util.List;

import Dama_Utente.Utente;
import Dama_Database.DatabaseStorageUtente;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UtenteDao {
	private SQLiteDatabase database ;
	private DatabaseStorageUtente dbHelper;
	private static String[] allColumns={
		DatabaseStorageUtente.COLUMN_ID,
		DatabaseStorageUtente.COLUMN_NAME,
		DatabaseStorageUtente.COLUMN_SURNAME,
		DatabaseStorageUtente.COLUMN_EMAIL,
		DatabaseStorageUtente.COLUMN_PASSWORD
	};
	
	public UtenteDao(Context context){
		dbHelper = new DatabaseStorageUtente(context);
	}
	
	public void open() throws SQLException{
		if((database != null) && (database.isOpen())){
			return;
		}else{
			database = dbHelper.getWritableDatabase();
		}
	}
	
	public void close(){
		if(database.isOpen()){
			dbHelper.close();
		}
	}
	
	public void insertOnDbUtente(Dama_Utente.Utente mUtente)throws Exception{
		Log.d("myapp", mUtente.getKeyUtente());
		ContentValues values = new ContentValues();
		values.put(DatabaseStorageUtente.COLUMN_ID,"" + mUtente.getKeyUtente() + "");
		values.put(DatabaseStorageUtente.COLUMN_NAME,"" + mUtente.getName() + "");
		values.put(DatabaseStorageUtente.COLUMN_SURNAME, "" + mUtente.getSurname() + "");
		values.put(DatabaseStorageUtente.COLUMN_EMAIL,""+ mUtente.getEmail() + "");
		values.put(DatabaseStorageUtente.COLUMN_PASSWORD,""+ mUtente.getPassword() + "");
		long insertId = database.insert(DatabaseStorageUtente.TABLE_UTENTE, null, values);
	}
	
	public void deleteOnDbAllUtente(){
		database.delete(DatabaseStorageUtente.TABLE_UTENTE, null,null);
	}
	
	public void deleteOnDbOneUtente(Utente mUtente){
		String guid = mUtente.getKeyUtente();
		System.out.print("Key Utente that we have delete is : " + guid);
		database.delete(DatabaseStorageUtente.TABLE_UTENTE, DatabaseStorageUtente.COLUMN_ID +"='" + guid+ "'" , null);
	}
	
	public int deleteOnDbSomeUtente(List<Utente> mUtente){
		String guid=null;
		int db=-1;
		for(Utente utente: mUtente){
			guid=utente.getKeyUtente();
			db=database.delete(DatabaseStorageUtente.TABLE_UTENTE, DatabaseStorageUtente.COLUMN_ID+ "='" + guid+ "'", null);
		}return db;
	}
	
	public List<Utente> getAllUtente(){
		List<Utente> listUtente = new ArrayList<Utente>();
		Cursor cursor = database.query(DatabaseStorageUtente.TABLE_UTENTE, allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Utente utente=cursorsUtente(cursor);
			listUtente.add(utente);
			cursor.moveToNext();
		}
				cursor.close();
				return listUtente;
	}

	
	private Utente cursorsUtente(Cursor cursor) {
		Utente utente = new Utente();
		utente.setKeyUtente(cursor.getString(DatabaseStorageUtente.COLUMN_ID_INDEX));
		utente.setName(cursor.getString(DatabaseStorageUtente.COLUMN_NAME_INDEX));
		utente.setSurname(cursor.getString(DatabaseStorageUtente.COLUMN_SURNAME_INDEX));
	//	utente.setPassword(cursor.getString(DatabaseStorageUtente.COLUMN_PASSWORD_INDEX));
		return  utente;
	}

	@Override
	protected void finalize() throws Throwable {
		close();
		super.finalize();
	}
}
