package labi.aula04.exe01;


public class Cofrinho {
	private String nome;
	private double qtdDezCents;
	private double qtdVinteCincoCents;
	private double qtdCinquentaCents;
	
	public Cofrinho(String nomeT){
		this.nome = nomeT;
	}

	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void depositaUmaMoedaDezCentavos(double qtdMoeda){
		this.qtdDezCents = this.qtdDezCents + qtdMoeda;
	}
	
	public void depositaUmaMoedaVinteCincoCentavos(double qtdMoeda){
		this.qtdVinteCincoCents = this.qtdVinteCincoCents + qtdMoeda;
	}
	
	public void depositaUmaMoedaCinquentaCentavos(double qtdMoeda){
		this.qtdCinquentaCents = this.qtdCinquentaCents + qtdMoeda;
	}
	
	public double calculaTotal(){
		double valorTotalMoedaDez = this.qtdDezCents * 0.10;
		double valorTotalMoedaVinteCinco = this.qtdVinteCincoCents * 0.25;
		double valorTotalMoedaCinquenta = this.qtdCinquentaCents * 0.50;
		
		return valorTotalMoedaDez + valorTotalMoedaVinteCinco + valorTotalMoedaCinquenta;
	}
	
	public double calculaTotal(double valorDolar){
		return this.calculaTotal() * valorDolar;
	}
}
