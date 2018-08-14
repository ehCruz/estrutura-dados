public class Classe04 {
	
	public static void main(String[] args){
		String alfabeto = "abcdefghijklmnopqrstuvxyz";
		int alfabetoSize = alfabeto.length();
		System.out.printf("%s ==> normal %n", alfabeto);
		for(int i = 0; i < alfabetoSize; i++){
			System.out.printf("%c", alfabeto.charAt((alfabetoSize-1) - i));
		}
		System.out.printf(" ==> inverso%n");
	}
} 
