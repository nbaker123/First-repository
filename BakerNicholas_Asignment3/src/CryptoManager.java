
 // The main purpose of this class is to encrypt and decrypt string with charcters within
//the range ' ' to '_' with the ceasar or bellaso ciphers.
//Programmer: Nicholas Baker

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		
		//Scans each character in the string and returns false if any of them are out of bounds
		for(int i = 0; i < plainText.length(); i++) {
			if(plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND)
				return false;
		}
		
		//returns true if the string is within bounds
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		
		//Declare necessary variables
		String encrypted = "";
		char c = ' ';
		
		//Runs through each character in the string and encrypts them with the key
		for(int i = 0; i < plainText.length(); i++) {
			
			//Storing current character and encrypting it
			c = plainText.charAt(i);
			c += key;
			
			//If the resulting character is out of bounds, that will be fixed 
			if(c > UPPER_BOUND) {
				while(c > UPPER_BOUND)
					c -= RANGE;
			}
			else if(c < LOWER_BOUND) {
				while(c < LOWER_BOUND)
					c += RANGE;
			}
			
			//Adds encrypted character to the string
			encrypted = encrypted + c;
		}
		
		//Returns the encrypted String
		return encrypted;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		
		//Necessary variables
		//**bellasoIndex allows us to use bellasoStr without extending it
		int bellasoIndex = 0;
		char c = ' ';
		String encrypted = "";
		
		for(int i = 0; i < plainText.length(); i++) {
			
			//Takes the current character and offsets it by the corresponding character in
			//bellasoStr
			c = plainText.charAt(i);
			c += bellasoStr.charAt(bellasoIndex);
			
			//If the resulting character is out of bounds, that will be fixed 
			if(c > UPPER_BOUND) {
				while(c > UPPER_BOUND)
					c -= RANGE;
			}
			else if(c < LOWER_BOUND) {
				while(c < LOWER_BOUND)
					c += RANGE;
			}
			
			//Adds the encrypted character to the final string
			encrypted = encrypted + c;
			
			//Advances to the next index in bellasoStr
			bellasoIndex++;
			
			//If the index of bellasoStr is out of range, set it back to 0
			if(bellasoIndex == bellasoStr.length())
				bellasoIndex = 0;
		}
		
		//Returns the encrypted String
		return encrypted;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		
		//Declare necessary variables
				String decrypted = "";
				char c = ' ';
				
				//Runs through each character in the string and decrypts them with the key
				for(int i = 0; i < encryptedText.length(); i++) {
					
					//Storing current character and decrypting it
					c = encryptedText.charAt(i);
					c -= key;
					
					//If the resulting character is out of bounds, that will be fixed 
					if(c > UPPER_BOUND) {
						while(c > UPPER_BOUND)
							c -= RANGE;
					}
					else if(c < LOWER_BOUND) {
						while(c < LOWER_BOUND)
							c += RANGE;
					}
					
					//Adds decrypted character to the string
					decrypted = decrypted + c;
				}
				
				//Returns the decrypted string
				return decrypted;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {

		//Necessary variables
		//**bellasoIndex allows us to use bellasoStr without extending it
		int bellasoIndex = 0;
		char c = ' ';
		String decrypted = "";
		
		for(int i = 0; i < encryptedText.length(); i++) {
			
			//Takes the current character and offsets it by the corresponding character in
			//bellasoStr
			c = encryptedText.charAt(i);
			c -= bellasoStr.charAt(bellasoIndex);
			
			//If the resulting character is out of bounds, that will be fixed 
			if(c > UPPER_BOUND) {
				while(c > UPPER_BOUND)
					c -= RANGE;
			}
			else if(c < LOWER_BOUND) {
				while(c < LOWER_BOUND)
					c += RANGE;
			}
			
			//Adds the decrypted character to the final string
			decrypted = decrypted + c;
			
			//Goes to the previous index in bellasoStr
			bellasoIndex++;
			
			//If the index of bellasoStr is out of range, set it back to the last index
			if(bellasoIndex == bellasoStr.length())
				bellasoIndex = 0;
		}
		
		//Returns the decrypted String
		return decrypted;
	}
}