package labi.aula16ProvaGB;

/** Alunos : Luis Valgoi Prova GB LAB 1 Turma: 33 */

public class Frete {
	private int peso;
	private double preco;

	public Frete(int umPeso){
		this.peso = umPeso;
	}

	public Frete(){
		this.peso = 10;
	}
	
	public void setPreco(double p){
		this.preco = p;
	}

	public double getPreco(){
		return this.preco;
	}
	
	public int getPeso(){
		return this.peso;
	}
	
	public void calculaPreco(){
		if(this.peso <= 30){
			this.preco = this.peso * 5.0;
		}
		if(this.peso >= 30 && this.peso <= 100){
			this.preco = this.peso * 4.5;
		}
		if(this.peso > 100){
			this.preco = this.peso * 4.0;
		}
	}
	
	public String toString(){
		return "Peso: " + getPeso() + " kg | Preço: R$ " + getPreco(); 
	}
}
