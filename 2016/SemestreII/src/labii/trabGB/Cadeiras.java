package labii.trabGB;

import labii.trabGB.estruturas.ArrayQueue;
import labii.trabGB.estruturas.NodeQueue;

public class Cadeiras {
	private NodeQueue<Ficha> filaPRServicoA;
	private NodeQueue<Ficha> filaNPRServicoA;

	private NodeQueue<Ficha> filaPRServicoB;
	private NodeQueue<Ficha> filaNPRServicoB;

	private NodeQueue<Ficha> filaPRServicoC;
	private NodeQueue<Ficha> filaNPRServicoC;
	
	// construtor
	public Cadeiras(){
		this.filaPRServicoA = new NodeQueue<Ficha>();
		this.filaNPRServicoA = new NodeQueue<Ficha>();

		this.filaPRServicoB = new NodeQueue<Ficha>();
		this.filaNPRServicoB = new NodeQueue<Ficha>();

		this.filaPRServicoC = new NodeQueue<Ficha>();
		this.filaNPRServicoC = new NodeQueue<Ficha>();
	}

	// m publicos
	public boolean isAlgumaCadeiraLotada(){
		return isAlgumaCadeiraACheia() || isAlgumaCadeiraBCheia() || isAlgumaCadeiraCCheia();
	}

	public boolean isCadeirasVazias(){
		return filaNPRServicoA.isEmpty() && 
				filaNPRServicoB.isEmpty() && 
				filaNPRServicoC.isEmpty() && 
				filaPRServicoA.isEmpty() && 
				filaPRServicoB.isEmpty() && 
				filaPRServicoC.isEmpty();
	}
	
	public void preencheCadeiras(ArrayQueue<Ficha> filaGeral){

		while(!filaGeral.isEmpty()){
			// a
			Ficha ficha = filaGeral.front();

			if(isFichaServicoTal(ficha, "A")){
				if(ficha.isPrioritario()){
					if(filaPRServicoA.size() < 3){
						filaPRServicoA.enqueue(filaGeral.dequeue());
					}else{
						break;
					}
				}else{
					if(filaNPRServicoA.size() < 5){
						filaNPRServicoA.enqueue(filaGeral.dequeue());
					}else{
						break;
					}
				}
			}

			// b
			else if(isFichaServicoTal(ficha, "B")){
				if(ficha.isPrioritario()){
					if(filaPRServicoB.size() < 3){
						filaPRServicoB.enqueue(filaGeral.dequeue());
					}else{
						break;
					}
				}else{
					if(filaNPRServicoB.size() < 5){
						filaNPRServicoB.enqueue(filaGeral.dequeue());
					}else{
						break;
					}
				}
			}

			// c
			else {
				if(ficha.isPrioritario()){
					if(filaPRServicoC.size() < 3){
						filaPRServicoC.enqueue(filaGeral.dequeue());
					}else{
						break;
					}
				}else{
					if(filaNPRServicoC.size() < 5){
						filaNPRServicoC.enqueue(filaGeral.dequeue());
					}else{
						break;
					}
				}
			}
		}		
	}

	public void atende(ArrayQueue<Ficha> filaGeral, Relatorio relatorioDia){
		// a		
		if(this.filaNPRServicoA.size() > 0){
			Ficha primeiroNPRServicoA = this.filaNPRServicoA.front();
			if(isAptoRemover(primeiroNPRServicoA)){
				relatorioDia.addRelatorio(this.filaNPRServicoA.dequeue());
			}	
		}
		
		if(this.filaPRServicoA.size() > 0){
			Ficha primeiroPRServicoA = this.filaPRServicoA.front();
			if(isAptoRemover(primeiroPRServicoA)){
				relatorioDia.addRelatorio(this.filaPRServicoA.dequeue());
			}
		}

		// b
		if(this.filaNPRServicoB.size() > 0){
			Ficha primeiroNPRServicoB = this.filaNPRServicoB.front();
			if(isAptoRemover(primeiroNPRServicoB)){
				relatorioDia.addRelatorio(this.filaNPRServicoB.dequeue());
			}
		}
		if(this.filaPRServicoB.size() > 0){
			Ficha primeiroPRServicoB = this.filaPRServicoB.front();
			if(isAptoRemover(primeiroPRServicoB)){
				relatorioDia.addRelatorio(this.filaPRServicoB.dequeue());
			}
		}

		// c
		if(this.filaNPRServicoC.size() > 0){
			Ficha primeiroNPRServicoC = this.filaNPRServicoC.front();
			if(isAptoRemover(primeiroNPRServicoC)){
				relatorioDia.addRelatorio(this.filaNPRServicoC.dequeue());
			}
		}
		if(this.filaPRServicoC.size() > 0){
			Ficha primeiroPRServicoC = this.filaPRServicoC.front();
			if(isAptoRemover(primeiroPRServicoC)){
				relatorioDia.addRelatorio(this.filaPRServicoC.dequeue());
			}
		}
	}

	// m privados	
	private boolean isFichaServicoTal(Ficha ficha, String servicoDesignacao){
		return ficha.getServicoDesignacao().equalsIgnoreCase(servicoDesignacao);			
	}

	private boolean isAptoRemover(Ficha front){
		if(front != null){
			front.setTempoRestante(front.getTempoRestante() - 1);

			if(front.getTempoRestante() == 0){
				return true;
			}else{
				return false;
			}	
		}else{
			return false;
		}		
	}

	private boolean isAlgumaCadeiraACheia(){
		return (filaNPRServicoA.size() == 5 || filaPRServicoA.size() == 3);
	}

	private boolean isAlgumaCadeiraBCheia(){
		return (filaNPRServicoB.size() == 5 || filaPRServicoB.size() == 3);
	}

	private boolean isAlgumaCadeiraCCheia(){
		return (filaNPRServicoC.size() == 5 || filaPRServicoC.size() == 3);
	}

}
