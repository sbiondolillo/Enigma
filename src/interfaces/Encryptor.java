package interfaces;

import encryption.Dictionary;

public interface Encryptor {

	/** @return a listing of all characters which can be encoded */
	Dictionary getValidCharacters();
	
	/** @return the number of characters in the Dictionary */
	int getDictionaryLength();
	
}
