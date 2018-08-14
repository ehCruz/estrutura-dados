public class Classe02{
	
	public static void main(String[] args){
		String palavra = "a loja estava cheia";
		System.out.printf("%n%nTamanho da String %s é de %d%n", palavra, palavra.length());
		for(int i = 0; i < palavra.length(); i++){
			if(palavra.charAt(i) == 'a')
				System.out.printf("%c ==> posicao de 'a'%n", palavra.charAt(i)) ;
			else
				System.out.printf("%c%n",palavra.charAt(i));
		}
		System.out.println();
	}
}
