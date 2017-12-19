package labi.aula16ProvaGB;

/** Alunos : Luis Valgoi Prova GB LAB 1 Turma: 33 */

public class FreteEspecial extends Frete{
	private int distancia;

	public FreteEspecial(int peso, int distancia){
		super(peso);
		
		if(distancia <= 50){
			distancia = 51;
		}else{
			this.distancia = distancia;
		}
	}

	public void calculaPreco(){
		super.calculaPreco();

		double precoExtra = 0;
		double precoAtual = this.getPreco();
		
		if(getDistancia() <= 170){
			precoExtra = precoAtual * 0.3;			
		}
		if(getDistancia() >= 171 && getDistancia() <= 400){
			precoExtra = precoAtual * 0.65;
		}
		if(getDistancia() > 400){
			precoExtra = precoAtual * 1;
			double rand = 30 + (int)(Math.random() * (51-30));
			precoExtra = precoExtra + rand;
		}
		
		this.setPreco(precoAtual + precoExtra);
	}

	public int getDistancia(){
		return this.distancia;
	}
}
