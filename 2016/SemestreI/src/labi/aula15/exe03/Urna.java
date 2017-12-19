package labi.aula15.exe03;

public class Urna{
	private int numero;
	private int[] qtdVotos;

	public Urna(int n, int qtdCandidatos){
		this.numero = n;
		this.qtdVotos = new int[qtdCandidatos+1];			
	}

	public void recebeVoto(int candidato){
		if(candidato == 0){
			this.qtdVotos[0]++; 
		}
		else if(candidato > 0 && candidato < qtdVotos.length){
			this.qtdVotos[candidato]++;
		}else{
			this.qtdVotos[0]++; 
		}
	}

	public void exibeResultado(){
		int count = qtdVotos.length-1;			
		
		System.out.println("C | V");
		for (int i = 1; i < qtdVotos.length; i++) {
			System.out.println(i + " | " + qtdVotos[i]);
		}
		System.out.println("---------");
		System.out.println("nulos | " + qtdVotos[0]);
		
		System.out.println("---------");
		System.out.println("T | " + count);
		System.out.println("---------");
	}
}