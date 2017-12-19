package labii.exe10;

public class Terreno {
	protected String bairro;
	protected String quadra;
	protected String lote;
	protected String rua;
	protected double frente;
	protected double fundos;

	public Terreno(String bairro, String quadra, String lote, String rua, double frente, double fundos) {
		this.bairro = bairro;
		this.quadra = quadra;
		this.lote = lote;
		this.rua = rua;
		this.frente = frente;
		this.fundos = fundos;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getQuadra() {
		return quadra;
	}

	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public double getFrente() {
		return frente;
	}

	public void setFrente(double frente) {
		this.frente = frente;
	}

	public double getFundos() {
		return fundos;
	}

	public void setFundos(double fundos) {
		this.fundos = fundos;
	}

	public double calculaArea(){
		return frente * fundos;
	}
	
}
