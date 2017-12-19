package labii.provaGA;

import java.util.Arrays;

public class Paciente implements Comparable<Paciente>{

	private Paciente[] pacientes;
	private int lastIndex;
	private String nomePaciente;
	private double peso;
	private int altura;
	
	public Paciente(String nomePaciente, double peso, int altura) {
		this.nomePaciente = nomePaciente;
		this.peso = peso;
		this.altura = altura;
		this.pacientes = new Paciente[200];
		this.lastIndex = 0;
	}
	
	public Paciente() {
		this.pacientes = new Paciente[200];
		this.lastIndex = 0;
	}
	
	public Paciente(int size) {
		this.pacientes = new Paciente[70];
		this.lastIndex = 0;
	}
	

	public Paciente[] getPacientes() {
		return pacientes;
	}

	public void setPacientes(Paciente[] pacientes) {
		this.pacientes = pacientes;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public double calcIMC(Paciente p){
		int alturaInt = p.getAltura();
		double alturaDouble = converte_CM_M(alturaInt);
		double f = alturaDouble * alturaDouble;
		
		return p.getPeso() / f;
	}
	
	public double converte_CM_M(int alturaCM){
		double valor = alturaCM / 100.00;
		return valor;
	}

	
	@Override
	public int compareTo(Paciente o) {
		int valor = 0;
		
		if(o != null){		
			String nome1 = this.getNomePaciente();
			String nome2 = o.getNomePaciente();
			
			valor = nome1.compareTo(nome2);
		}		
		
		return valor;
	}
	
	public void inserePaciente(Paciente p){
		if(lastIndex < pacientes.length){
			pacientes[lastIndex++] = p;
		}
	}
	
	public void inserePaciente(String nomePaciente, double peso, int altura){
		if(lastIndex < pacientes.length){
			pacientes[lastIndex++] = new Paciente(nomePaciente, peso, altura);
		}
	}

	public void classifica(Paciente[] p){
		Arrays.sort(p);
	}

	@Override
	public String toString() {
		return getNomePaciente() + " => " + getAltura() + " =>" + getPeso();
	}
}
