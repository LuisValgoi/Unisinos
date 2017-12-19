package labi.aula06.exe07.A;

import java.util.ArrayList;
import java.util.Collections;

public class TresNumerosInteiros {
	private int primeiro;
	private int segundo;
	private int terceiro;
	
	public TresNumerosInteiros(int pri, int seg, int ter){
		this.primeiro = pri;
		this.segundo = seg;
		this.terceiro = ter;
	}

	public int getPrimeiroNumero() {
		return primeiro;
	}

	public void setPrimeiroNumero(int primeiro) {
		if(primeiro > 0){
			this.primeiro = primeiro;	
		}else{
			this.primeiro = 1;
		}		
	}

	public int getSegundoNumero() {
		return segundo;
	}

	public void setSegundoNumero(int segundo) {
		if(segundo > 0){
			this.segundo = segundo;	
		}else{
			this.segundo = 1;
		}
	}

	public int getTerceiroNumero() {
		return terceiro;
	}

	public void setTerceiroNumero(int terceiro) {
		if(terceiro > 0){
			this.terceiro = terceiro;	
		}else{
			this.terceiro = 1;
		}
	}
	
	public int getMaior(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(this.primeiro);
		lista.add(this.segundo);
		lista.add(this.terceiro);
		
		for(int i = 1; i < lista.size(); i++) {
	        if((lista.get(0) == lista.get(i)) && (lista.get(i) != lista.get(0))) 
	        	return this.primeiro; 
	     }
		
		return Collections.max(lista);
	}
	
	public int getMenor(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(this.primeiro);
		lista.add(this.segundo);
		lista.add(this.terceiro);

		for(int i = 1; i < lista.size(); i++) {
	        if((lista.get(0) == lista.get(i)) && (lista.get(i) != lista.get(0))) 
	        	return this.primeiro; 
	     }

		return Collections.min(lista);
	}
	
	public void classificaOrdemCrescente(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(this.primeiro);
		lista.add(this.segundo);
		lista.add(this.terceiro);
		
		Collections.sort(lista);		
		
		this.primeiro = lista.get(0);
		this.segundo = lista.get(1);
		this.terceiro = lista.get(2);		
	}
}
