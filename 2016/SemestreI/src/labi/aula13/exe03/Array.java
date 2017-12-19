package labi.aula13.exe03;

public class Array {

	public static void setValoresAleatorios (int v[]){
		int tamanhoArray = v.length;

		for (int i = 0; i < tamanhoArray; i++){
			int random = 10 + (int)(Math.random() * 100);
			v[i] = random;
		}
	}

	public static void setValoresDoTeclado(int v[]){
		int tamanhoDoArray = v.length, numeroEscolhido = 0;

		for (int i = 1; i < tamanhoDoArray; i++) {
			Helpers.wr("Digite o 1º número inteiro de " + tamanhoDoArray);
			numeroEscolhido = Helpers.leInt();

			v[i] = numeroEscolhido;
		}
	}

	public static void setSerieFibonacci(int v[]){
		// set o tamanho da serie de fibonacci
		int[] feb = new int[v.length];
		// por default, a serie de fibonacci tem esses valores pre-fixados 
		feb[0] = 0;
		feb[1] = 1;
		// por default, eles não mudarão
		v[0] = 0;
		v[1] = 1;

		for(int i = 2; i < v.length; i++){
			feb[i] = feb[i-1] + feb[i-2];
			v[i] = feb[i];
		}
	}

	public static void setFatoriais(int v[]){
		for (int i = 0; i < v.length; i ++) {
			v[i] = Array.calculaFatorial(i);
		}
	}

	private static int calculaFatorial(int n){
		int fat = 1;
		for (int i = n; i >= 1; i--) {
			fat = fat * 1;
		}

		return fat;
	}

	public static double calculaMediaAritmetica(int v[]){
		int soma = 0;
		for (int i = 0; i < v.length; i++) {
			soma = soma + v[i];  
		}
		return soma/v.length;
	}

	public static double calculaMediaAritmetica(int v[], int i, int j){
		int soma = 0;
		int count = 0;
		for (int x = i; x < j; i++) {
			soma = soma + v[x];
			count++;
		}
		return soma/count;
	}
	
	public static int contaMultiplosDe3 (int v[]){
		int count = 0;
		for (int i : v) {
			if(i%3==0){
				count++;
			}
		}
		return count;
	}
	
	public static int getMaiorValor (int v[]){
		int maior = Integer.MIN_VALUE;		
		for (Integer integer : v) {
			if(integer > maior){
				maior = integer;
			}		
		}
		
		return maior;
	}
	
	public static int getMenorValor(int v[]){
		int min = Integer.MIN_VALUE;		
		for (Integer integer : v) {
			if(integer < min){
				min = integer;
			}		
		}
		
		return min;
	}
	
	public static int getIndiceMenorValor(int v[]){
		int menorValor = getMenorValor(v);
		int indiceMenorValor = Integer.MIN_VALUE;
		
		for (int i = 0; i < v.length; i++) {
			if(i == menorValor){
				indiceMenorValor = i;
			}
		}
		return indiceMenorValor;
	}
	
	public static void exibeArray(int v[]){
		for (int i : v) {			
			Helpers.wr("" + i);
		}	
	}
	
	public static void exibeArray(int v[], String titulo){
		Helpers.wr(titulo);
		for (int i : v) {
			Helpers.wr("" + i);
		}	
	}
	
	public static boolean pesquisa(int v[], int valor){
		for (int i : v) {
			if(i == valor){				
				return true;
			}			
		}
		
		return false;		
	}

	public static int[] getArraySoma(int a[], int b[]){
		int[] arrayFinal = null;
		
		// descubro o maior array 
		int maiorTamanho = 0;		
		if(a.length > b.length){
			maiorTamanho = a.length;
		}else if(b.length > a.length){
			maiorTamanho = b.length;
		}else{
			maiorTamanho = a.length;
		}
		
		for (int i = 0; i < maiorTamanho; i++) {
			
			do{
				arrayFinal = new int[maiorTamanho];
				arrayFinal[i] = a[i] + b[i];
			}while(i < a.length && i < b.length);
			
			if(i >= a.length && i < b.length){
				arrayFinal[i] = b[i];
			}
			
			if(i >= b.length && i < a.length){
				arrayFinal[i] = a[i];
			}
		}
		
		return arrayFinal;
	}

	public static int[] getArrayUniao(int a[], int b[]){
		int[] arrayTemp, arrayFinal;
		int countLogico = 0;
		int qtdLinhasDuplicadas = 0;		
		
		// preenche com os duplicados
		arrayTemp = new int[a.length + b.length];		
		for (int i = 0; i < a.length; i++) {
			arrayTemp[i] = a[i];
		}		
		for (int i = a.length; i < b.length; i++) {
			arrayTemp[i] = b[i];
		}
		
		// acha os duplicados e elimina-os
		for (int i = 0; i < arrayTemp.length; i++) {
			if(pesquisa(arrayTemp, arrayTemp[i])){
				qtdLinhasDuplicadas++;
				arrayTemp[i] = Integer.MIN_VALUE;
			}
		}
		
		// cria sem os duplicados
		arrayFinal = new int[arrayTemp.length - qtdLinhasDuplicadas];
		for(int i = 0; i < arrayTemp.length; i++){
			if(arrayTemp[i] != Integer.MIN_VALUE){
				arrayFinal[countLogico++] = arrayTemp[i];
			}
		}		
		
		return arrayFinal;		
	}

	public static void classificaOrdemCrescente(int v[]){
		int salva;
		// i fica parado 
		// j anda

		// de comeco, o i vai valer o valor da primeira posicao
		// de comeco, o j vai valer o valor da segunda posicao e andando...
		
		// j compara os valores de todas as posicoes do meu array com o i que ficou parado
		// se for menor, troca		
		for (int i = 0; i < v.length -1; i++){
			for (int j = i + 1; j < v.length; j++){
				if(v[j] < v[i]){ //troca a[i] com a[j]
					salva = v[i];
					v[i] = v[j];
					v[j] = salva;					
				}
			}
		}
	}
	
	public static void classificaOrdemCrescente(int v[], int x, int z){
		int salva;
		for (int i = x; i < z -1; i++){
			for (int j = i + 1; j < z; j++){
				if(v[j] < v[i]){
					salva = v[i];
					v[i] = v[j];
					v[j] = salva;					
				}
			}
		}
	}
	
	public static void classificaOrdemDecrescente(int v[]){
		for (int i = 0; i < v.length -1; i++){
			for (int j = i + 1; j < v.length; j++){
				if(v[j] > v[i]){
					int temp = v[i];
					v[i] = v[j];
					v[j] = temp;					
				}
			}
		}
	}
}
