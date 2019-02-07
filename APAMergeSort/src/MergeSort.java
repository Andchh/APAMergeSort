import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o numero de elementos no array:\n");
		int n = s.nextInt();
		int[] entry = new int[n];
		System.out.print("Digite os numeros que serao organizados com enter apos cada:\n");
		
		for(int i = 0; i < n; i++){  //vai lendo e salvando no array os valores
			entry[i] = s.nextInt();
		}
		s.close();
		MergeSort.split(entry, entry.length);
		for(int j = 0; j < entry.length; j++){
			System.out.print(entry[j]+"\n");
		}
		
	}
	public static void split(int[] array, int size){  //pode dividir recursivamente em partes para eficácia 
		
		if(size < 2){ //já dividiu o máximo
			return;
		}
		
		//size = array.length;  //encontra o numero de itens no array 
		int meio = size / 2; //encontra o meio
		int[] esquerda = new int[meio]; //cria array da esquerda ao meio
		int[] direita = new int[size - meio]; //cria array do meio ao fim
		
		//preenche o array esquerda
		for(int i = 0; i < meio; i++){
			esquerda[i] = array[i];
		}
		//preenche o array direita
		for(int i = meio; i < size; i++){
			direita[i-meio] = array[i];
		}
		
		split(esquerda, meio); //chama função que organiza o array, passando array e local
		split(direita, size - meio);
		
		Sort(array, esquerda, direita, meio, size - meio);
	}
	
	
	//pega os arrays, o começo e o fim para colocar o menor na frente
	
	public static void Sort(int[] array, int[] esquerda, int[] direita, int esq, int dir){
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < esq && j < dir){
			if(esquerda[i] <= direita[j]){ //se o valor da esquerda for < que direita
				array[k++] = esquerda[i++];  //o array[2]recebe o valor da esquerda
			}
			else {
				array[k++] = direita[j++];
			}
		}
		//ao chegar no fim dos arrays os elementos são copiados para outro array
		while (i < esq){
			array[k++] = esquerda[i++];
		}
		while(j < dir){
			array[k++] = direita[j++];
			
		}
		
	}
	
}
