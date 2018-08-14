public class Classe03{
	
	public static void main(String[] args){
		String palavra = "a loja estava cheia";
		System.out.printf("%n%nTamanho da String %s e de %d%n", palavra, palavra.length());
		palavra = palavra.replace("a", " ");
		System.out.printf("Palavra %s apos substituicao de 'a' por ' '%n", palavra);
	}
}
