package labi.trabCarroLuxo;


public class CarroLuxo extends Carro{	
	private boolean isArCondicionadoLigado;	
		
	public CarroLuxo(boolean isArCondicionadoLigado) {
		super();
		setArCondicionadoLigado(isArCondicionadoLigado);
	}
		
	public CarroLuxo(double qtdNoTanque, double consumo, double kilometragem) {
		super(qtdNoTanque, consumo, kilometragem);		
	}

	public void setArCondicionadoLigado(boolean isArCondicionadoLigado) {
		this.isArCondicionadoLigado = isArCondicionadoLigado;
	}

	public void ligarAr(){
		setArCondicionadoLigado(true);
		
		double extra = this.getConsumo() * 0.10;
		double consumoFinal = this.getConsumo() + extra;
		this.setConsumo(consumoFinal);
	}
	
	public void desligaAr(){
		setArCondicionadoLigado(false);
		
		double extra = this.getConsumo() * 0.10;
		double consumoFinal = this.getConsumo() - extra;
		this.setConsumo(consumoFinal);
	}
}
