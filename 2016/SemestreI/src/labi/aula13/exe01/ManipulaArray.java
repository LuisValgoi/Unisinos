package labi.aula13.exe01;

public class ManipulaArray {
	private int[] array;

	public ManipulaArray(){
		this.array = new int[10];
	}

	public ManipulaArray(int tamanhoArray){
		this.array = new int[tamanhoArray];
	}

	public void exibeArray(){
		for (int i : getArray()) {
			Helpers.wr("O valor é: " + i);
		}	
	}
	
	public void exibeArray(int i, int j){
		for (int index = getArray()[i]; index < getArray()[j]; index++) {
			Helpers.wr("O valor é: " + index);
		}
	}
	
	public void setValoresAleatorios(){
		// valores inteiros aleatórios no intervalo [-50 , 100) 
		int random = -50 + (int)(Math.random() * (100 - (-50)));
		
		for (int i : getArray()) {
			this.array[i] = random;
		}
	}
	
	public void setValoresDoTeclado(){
		int tamanhoDoArray = getArray().length, numeroEscolhido = 0;
		
		for (int i = 1; i < tamanhoDoArray; i++) {
			Helpers.wr("Digite o 1º número inteiro de " + tamanhoDoArray);
			numeroEscolhido = Helpers.leInt();
			
			this.array[i] = numeroEscolhido;
		}
	}
	
	public double getMedAritmetica(){
		int valorTotal = 0;		
		for (int i : getArray()) {
			valorTotal += i;
		}
		
		return valorTotal / getArray().length;		
	}
	
	public int[] getArray(){
		return this.array;
	}

	public int getMaiorValor(){
		int maior = Integer.MIN_VALUE;		
		for (Integer integer : this.getArray()) {
			if(integer > maior){
				maior = integer;
			}		
		}
		
		return maior;
	}
	
	public int getMenorValor(){
		int min = Integer.MIN_VALUE;		
		for (Integer integer : this.getArray()) {
			if(integer < min){
				min = integer;
			}		
		}
		
		return min;
	}
	
	public boolean pesquisa(int valor){
		for (int i : getArray()) {
			if(i == valor){				
				return true;
			}			
		}
		
		return false;		
	}

	public void exibeDados(String titulo){
		Helpers.wr(titulo);
		for (int i : getArray()) {			
			Helpers.wr("O valor é: " + i);
		}	
	}
	
	public void setSerieFibonacci(){
		// set o tamanho da serie de fibonacci
		int[] feb = new int[getArray().length];
		// por default, a serie de fibonacci tem esses valores pre-fixados 
        feb[0] = 0;
        feb[1] = 1;
        // por default, eles não mudarão
        getArray()[0] = 0;
        getArray()[1] = 1;
        
        for(int i = 2; i < getArray().length; i++){
            feb[i] = feb[i-1] + feb[i-2];
            getArray()[i] = feb[i];
        }
	}
	
	public void setFatoriais(){
		for (int i = 0; i < getArray().length; i ++) {
			getArray()[i] = calculaFatorial(i);
		}
	}
	
	private int calculaFatorial(int n){
		int fat = 1;
		for (int i = n; i >= 1; i--) {
			fat = fat * 1;
		}
		
		return fat;
	}
	
	public double getMedAritmetica(int i, int j){
		int valorTotal = 0;
		int size = 0;
		
		for (int x = getArray()[i]; x < getArray()[j]; x++) {
			size++;
			getArray()[x]++;
		}
		
		return valorTotal/size;
	}
	
	public int getIndiceMenorValor(){
		int menorValor = getMenorValor();
		int indiceMenorValor = Integer.MIN_VALUE;
		
		for (int i = 0; i < this.getArray().length; i++) {
			if(i == menorValor){
				indiceMenorValor = i;
			}
		}
		return indiceMenorValor;
	}
}
