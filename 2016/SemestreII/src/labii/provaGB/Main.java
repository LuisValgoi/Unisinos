package labii.provaGB;

public class Main {

	public static void main(String[] args) {
		// cria
		ArrayQueue<Veiculo> rodovia = new ArrayQueue<Veiculo>(1000);		
		
		// preenche
		preencheRodovia(rodovia);
		
		// cria os guiches com os elementos prontos
		Guiches guiches = criaRetornandoPronto();
		
		// atende
		guiches.atende(rodovia);	
		
		// gera relatorio
		guiches.geraRelatorio();
	}
	
	private static void preencheRodovia(ArrayQueue<Veiculo> rodovia){
		int i = 0;
		
		while(i < 1000){		
			int aleatorio = 1 + (int)(Math.random() * 2);
			
			Veiculo novo = null;		
			if(aleatorio == 1){
				novo = new Veiculo(1);
			}else{
				novo = new Veiculo(2);
			}
			
			rodovia.enqueue(novo);
			i++;
		}
		
		int ab = 0;
	}
	
	private static Guiches criaRetornandoPronto(){
		Guiches guiches = new Guiches();
		guiches.preenchimentoInicial();
		
		return guiches;
	}
}
