import java.util.Scanner;
public class Vignere{
	public static void main(String[] args) {
		String plaintext = "";
		String key;
		String ciphertext = "";
		int choice;
		System.out.println("1 to encrypt\t2 to decrypt");
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		switch(choice){
			case 1:
			System.out.println("Enter Plain Text");
			plaintext = sc.nextLine();
			plaintext = sc.nextLine();
			System.out.println("Enter Key");
			key = sc.nextLine();
			plaintext = plaintext.toUpperCase();
			key = key.toUpperCase();
			for(int i = 0; i < plaintext.length(); i++){
				ciphertext += (char)(((plaintext.charAt(i) + key.charAt(i%key.length()))%26)+65);
			}
			System.out.println(ciphertext);
			break;
			case 2:
			System.out.println("Enter Cipher Text");
			ciphertext = sc.nextLine();
			ciphertext = sc.nextLine();
			System.out.println("Enter Key");
			key = sc.nextLine();
			ciphertext = ciphertext.toUpperCase();
			key = key.toUpperCase();
			for(int i = 0; i < ciphertext.length(); i++){
				if((ciphertext.charAt(i) - key.charAt(i%key.length())) < 0){
					int res = 26+((ciphertext.charAt(i) - key.charAt(i%key.length())));
					plaintext += (char)(res+65);
				}
				else
					plaintext += (char)(((ciphertext.charAt(i) - key.charAt(i%key.length()))%26)+65);
			}
			System.out.println(plaintext);
		}
	}
}