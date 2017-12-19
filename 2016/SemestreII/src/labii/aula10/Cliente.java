package labii.aula10;

public class Cliente{

	private String nome;
	private String genero;
	private String dataAniversario;
	private double ultimaCompra;

	public Cliente(String nome, String genero, String dataAniversario, double ultimaCompra) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.dataAniversario = dataAniversario;
		this.ultimaCompra = ultimaCompra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(String dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public double getUltimaCompra() {
		return ultimaCompra;
	}

	public void setUltimaCompra(double ultimaCompra) {
		this.ultimaCompra = ultimaCompra;
	}
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + ". Genero: " + getGenero() + ". Data Aniversario: " + getDataAniversario() + ". Ultima Compra: R$ " + getUltimaCompra();
	}
}
