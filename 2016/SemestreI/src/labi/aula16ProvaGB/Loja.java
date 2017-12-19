package labi.aula16ProvaGB;

/** Alunos : Luis Valgoi Prova GB LAB 1 Turma: 33 */

public class Loja {
	private String nome;
	private Frete[] fretes;
	private double faturamento;

	public Loja(String nomeLoja, int tamanhoArrayFrete){
		this.nome = nomeLoja;
		this.fretes = new Frete[tamanhoArrayFrete];
		this.faturamento = 0;
	}	

	private int getProximaPosicaoLivre(){
		for (int i = 0; i < fretes.length; i++) {
			if(fretes[i] == null){
				return i;
			}
		}
		return -1;
	}

	public boolean insereFrete(){
		int indiceLivre = getProximaPosicaoLivre();

		if(indiceLivre == -1){
			return false;
		}

		Helpers.wr("Digite o peso");
		int peso = Helpers.leInt();

		Helpers.wr("Digite a distancia");
		int dist = Helpers.leInt();

		if(dist <= 50){
			fretes[indiceLivre] = new Frete(peso);
		}else{
			fretes[indiceLivre] = new FreteEspecial(peso, dist);			
		}

		// calcula o preco
		fretes[indiceLivre].calculaPreco();

		// atualizar o atr faturamento
		this.faturamento += fretes[indiceLivre].getPreco();

		return true;
	}

	public Frete freteMaisCaro(){

		int flagAlteracoes = 1;
		int indicePrimeiroArrayDeMaiorPreco = 0;

		int indiceArrayDeMaiorPreco = 0;
		double valorMaiorPreco = 0;		
		int countPosicoesNulas = 0;

		for (int i = 0; i < fretes.length; i++) {			
			if(fretes[i] == null){
				countPosicoesNulas++;
			}

			if(fretes[i] != null){
				if (fretes[i].getPreco() > valorMaiorPreco){
					indiceArrayDeMaiorPreco = i;
					valorMaiorPreco = fretes[i].getPreco();

					if(flagAlteracoes == 1){
						indicePrimeiroArrayDeMaiorPreco = i;
					}

					flagAlteracoes++;
				}				
			}
		}

		if(fretes.length == countPosicoesNulas){
			return null;
		}
		if(flagAlteracoes == 1){
			return fretes[indicePrimeiroArrayDeMaiorPreco];
		}else{
			return fretes[indiceArrayDeMaiorPreco];	
		}		
	}
	
	public int getFretesEspeciais(){
		int qtd = 0;
		int countPosicoesVazias = 0;
		
		for (int i = 0; i < fretes.length; i++) {
			if(fretes[i] != null){
				if(fretes[i] instanceof FreteEspecial && ((FreteEspecial)fretes[i]).getDistancia() > 100){
					qtd++;
				}	
			}else{
				countPosicoesVazias++;
			}
		}
		
		return countPosicoesVazias == fretes.length ? 0 : qtd;
	}
}
