package labi.aula15.exe04;

public class Vendedor {
	private String nome;
	private double[] somaVendas;
	private static final String[] meses = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };
	
	public Vendedor(String n){
		this.nome = n;
		this.somaVendas = new double[13];
	}

	public String getNome() {
		return this.nome;
	}
	
	public void vende(int numeroMesDaVenda, double valorVenda){
		somaVendas[numeroMesDaVenda] += valorVenda;
	}
	
	public double totalizaVendasAno(){
		double valorT = 0;
		for (int i = 1; i < somaVendas.length; i++) {
			valorT = valorT + somaVendas[i];
		}
		
		return valorT;
	}
	
	public String resumeVendasAno(){
		String texto = "";
		
		texto = "Vendas do ano do vendedor: " + getNome();
		texto = texto + "\n";		
		texto = texto + "Mês | Total Vendido (R$)";
		texto = texto + "\n";
		for (int i = 1; i < meses.length; i++) {
			texto = texto + meses[i] + " | " + somaVendas[i] + "\n";			
		}
		texto = texto + "\n";
		
		
		double valorTotal = 0;
		for (int i = 1; i < somaVendas.length; i++) {
			valorTotal = valorTotal + somaVendas[i];			
		}		
		texto = texto + "Total do ano (R$) | " + valorTotal;
		
		return texto;
	}
	
}
