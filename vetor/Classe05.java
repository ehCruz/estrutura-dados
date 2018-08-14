import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Classe05 {
        
        public static void main(String[] args){
                String aux;
                Double soma = 0.0;
                Integer contador = 0;
                try{
                        BufferedReader in = new BufferedReader(new FileReader("a.txt"));
                        while(in.ready()){
                                aux = in.readLine();
                                aux = aux.replace(",",".");
                                String[] vetAuxiliar = aux.split(" ");
                                for(int i = 0; i < vetAuxiliar.length; i++){
                                        System.out.println(vetAuxiliar[i]);
                                        soma += Double.parseDouble(vetAuxiliar[i]);
                                }
                                contador++;
                        }
                        if(soma > 0 && contador > 0){
                                soma /= contador;
                                System.out.printf("Soma dos valores é igual a %.2f%n", soma);      
                        }else{
                                System.out.println("Nenhum valor somado");
                        }
			in.close();
                }catch(IOException e){
                        e.printStackTrace();
                }
        }
}
