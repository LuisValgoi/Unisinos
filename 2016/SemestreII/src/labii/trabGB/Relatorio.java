package labii.trabGB;

public class Relatorio {
	private int diaRelatorio;	
	private int totalAtendimentoDia;
	
	private int totalAtendimentoDiaPRServicoA;
	private int totalAtendimentoDiaPRServicoB;
	private int totalAtendimentoDiaPRServicoC;
	
	private int totalAtendimentoDiaNPRServicoA;
	private int totalAtendimentoDiaNPRServicoB;
	private int totalAtendimentoDiaNPRServicoC;

	// constructor
	public Relatorio(int dia){
		this.diaRelatorio = dia;
		this.totalAtendimentoDia = 0;
		
		this.totalAtendimentoDiaPRServicoA = 0;
		this.totalAtendimentoDiaPRServicoB = 0;
		this.totalAtendimentoDiaPRServicoC = 0;
		
		this.totalAtendimentoDiaNPRServicoA = 0;
		this.totalAtendimentoDiaNPRServicoB = 0;
		this.totalAtendimentoDiaNPRServicoC = 0;
	}
	
	// m publics
	public void addRelatorio(Ficha ficha){
		// a
		if(isFichaServicoTal(ficha, "A")){
			if(ficha.isPrioritario()){
				this.totalAtendimentoDiaPRServicoA++;
				this.totalAtendimentoDia++;
			}else{
				this.totalAtendimentoDiaNPRServicoA++;
				this.totalAtendimentoDia++;
			}
		}
		
		// b
		else if(isFichaServicoTal(ficha, "B")){
			if(ficha.isPrioritario()){
				this.totalAtendimentoDiaPRServicoB++;
				this.totalAtendimentoDia++;
			}else{
				this.totalAtendimentoDiaNPRServicoB++;
				this.totalAtendimentoDia++;
			}
		}
		
		// c
		else if(isFichaServicoTal(ficha, "C")){
			if(ficha.isPrioritario()){
				this.totalAtendimentoDiaPRServicoC++;
				this.totalAtendimentoDia++;
			}else{
				this.totalAtendimentoDiaNPRServicoC++;
				this.totalAtendimentoDia++;
			}
		}
	}
	
	public int getDia(){
		return diaRelatorio;
	}

	public int getTotalAntedimentos(){
		return this.totalAtendimentoDia;
	}
	
	public int getTotalAtendimentoServicoA(){
		return totalAtendimentoDiaPRServicoA + totalAtendimentoDiaNPRServicoA;
	}
	
	public int getTotalAtendimentoServicoB(){
		return totalAtendimentoDiaPRServicoB + totalAtendimentoDiaNPRServicoB;
	}
	
	public int getTotalAtendimentoServicoC(){
		return totalAtendimentoDiaPRServicoC + totalAtendimentoDiaNPRServicoC;
	}
	
	public int getTotalAtendimentoPRServicoA(){
		return this.totalAtendimentoDiaPRServicoA;
	}
	
	public int getTotalAtendimentoPRServicoB(){
		return this.totalAtendimentoDiaPRServicoB;
	}
	
	public int getTotalAtendimentoPRServicoC(){
		return this.totalAtendimentoDiaPRServicoC;
	}
	
	// m privados	
	private boolean isFichaServicoTal(Ficha ficha, String servicoDesignacao){
		return ficha.getServicoDesignacao().equalsIgnoreCase(servicoDesignacao);			
	}
}
