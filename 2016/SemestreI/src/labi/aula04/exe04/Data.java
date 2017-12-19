package labi.aula04.exe04;


public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int d, int m, int a){
		this.dia = d;
		this.mes = m;
		this.ano = a;
	}
	
	public Data(int AAAAmmDD){
		String dataString = AAAAmmDD + "";
		
		String tempDia = dataString.substring(6, 8);
		String tempMes = dataString.substring(4, 6);
		String tempAno = dataString.substring(0, 4);
		
		this.dia = Integer.parseInt(tempDia);
		this.mes = Integer.parseInt(tempMes);
		this.ano = Integer.parseInt(tempAno);
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDataPadrao(){		
		return String.format("%s/%s/%s", this.ano, this.mes, this.dia);		
	}
	
	public int getDataInvertida(){
		String temp = "";	
		
		temp = String.format("%s%s%s", this.ano, this.mes, this.dia);			
		
		return Integer.parseInt(temp);		
	}
}
