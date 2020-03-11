
public class NicoTest {
	public static void main(String[] args) {
		String test1 = "HELLO";
		String test2 = "WORLD";
		String test3 = "NICO";
		String test4 = "man";
		
//		System.out.println(test1+" with the ceasar cipher should be LIPPS: " 
//		+ CryptoManager.encryptCaesar(test1, 4));
//		System.out.println(CryptoManager.encryptCaesar(test1, 4)+ 
//				" decrypted should be "+ test1 +": " 
//				+ CryptoManager.decryptCaesar(CryptoManager.encryptCaesar(test1, 4), 4));
//		
//		System.out.println(test2 + " with the ceasar cipher should be "+(char)(92)+"TWQI: " 
//				+ CryptoManager.encryptCaesar(test2, 5));
//		System.out.println(CryptoManager.encryptCaesar(test2, 5)+ 
//				" decrypted should be " + test2 + ": " 
//				+ CryptoManager.decryptCaesar(CryptoManager.encryptCaesar(test2, 5), 5));
		
		System.out.println(test3 + " with the bellaso cipher should be PX"+(char)(92)+"Q: " 
				+ CryptoManager.encryptBellaso(test3, "BOY"));
		System.out.println(CryptoManager.encryptBellaso(test3, "BOY")+ 
				" decrypted should be "+ test3+": " 
				+ CryptoManager.decryptBellaso(CryptoManager.encryptBellaso(test3, "BOY"), "BOY"));
		System.out.println(test4 + " should fail for being out of bounds. Is it in bounds? " 
				+ CryptoManager.stringInBounds(test4));
	}
}
