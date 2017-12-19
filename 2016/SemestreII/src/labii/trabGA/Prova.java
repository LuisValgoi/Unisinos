package labii.trabGA;

import java.util.Arrays;

public class Prova {
	private Piloto[] pilotos;
	private int lastIndex;	
	
	public Prova(int nPilotos) {
		this.pilotos = new Piloto[nPilotos];
	}

	public Piloto[] getPilotos() {
		return pilotos;
	}

	public void inserePilotos(Piloto p) throws InsercaoPilotoException {
		if(lastIndex >= pilotos.length)
			throw new InsercaoPilotoException();

		this.pilotos[lastIndex++] = p;
	}	

	public void classifica() throws ClassificaPilotoException {
		if(lastIndex <= 0)
			throw new ClassificaPilotoException();
		
		Arrays.sort(pilotos);
	}

}
