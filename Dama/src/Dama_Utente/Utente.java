package Dama_Utente;

import java.util.Date;

import android.content.Context;
import _Dama.MyUtente;

public class Utente implements MyUtente{
	private String keyUtente;
	private String name;
	private String surname;
	private char email;
	private char password;
	private Context c;

	public Utente(String keyUtente, String name, String surname, char email,
			char password, Context c) {
		super();
		this.keyUtente = keyUtente;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.c = c;
	}

	public Utente() {
		super();
	}

	@Override
	public String getKeyUtente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSurname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getEmail() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char getPassword() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setKeyUtente(String keyUtente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSurname(String surname) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEmail(char email) {
		// TODO Auto-generated method stub

	}

	public Context getC() {
		return c;
	}

	public void setC(Context c) {
		this.c = c;
	}

	@Override
	public void setPassword(char password) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Utente [keyUtente=" + keyUtente + ", name=" + name
				+ ", surname=" + surname + ", email=" + email + ", password="
				+ password + "]";
	}



}
