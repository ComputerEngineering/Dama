package _Dama;
/**Raffaella*/

import java.util.Date;

public interface MyUtente {

	String getKeyUtente();
	String getName();
	String getSurname();
	char getEmail();
	char getPassword();
	void setKeyUtente(String keyUtente);
	void setName(String name);
	void setSurname(String surname);
	void setEmail(char email);
	void setPassword(char password);
}
