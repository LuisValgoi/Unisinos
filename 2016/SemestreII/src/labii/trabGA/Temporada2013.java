package labii.trabGA;

import java.io.*;
import java.util.Arrays;

public class Temporada2013 {
	private Piloto[] pilotosQuePontuaram;
	private int lastIndex;

	public Temporada2013(int nPilotos) {
		this.pilotosQuePontuaram = new Piloto[nPilotos];
	}

	public Piloto[] getPilotosQuePontuaram() {
		return pilotosQuePontuaram;
	}

	public void inserePilotosQuePontuaram(String nomePiloto, String nomeEquipe, int pontosObtidos) throws InsercaoPilotoException{
		if(lastIndex >= pilotosQuePontuaram.length)
			throw new InsercaoPilotoException();

		if(pontosObtidos > 0){
			if(estePilotoPorNomeJaExiste(nomePiloto))		
				buscaPilotoPorNome(nomePiloto).setPontosObtidos(buscaPilotoPorNome(nomePiloto).getPontosObtidos() + pontosObtidos);			
			else
				pilotosQuePontuaram[lastIndex++] = new Piloto(nomePiloto, nomeEquipe, pontosObtidos);	
		}					
	}

	public void classificaPorNome(Piloto[] pilotos){
		Arrays.sort(pilotos, new ClassificaPorNome());
	}
	
	public void classificaPorPonto(Piloto[] pilotos){
		Arrays.sort(pilotos, new ClassificaPorPontos());
	}

	public void registrarPilotosEmArquivo(Piloto[] pilotos){
		try {

			File file = new File("ClassificacaoTemporada2013_F1.txt");
			FileWriter fr = new FileWriter(file);
			PrintWriter out = new PrintWriter(fr);	
			
			for (Piloto p : pilotos) {
				if(p != null)
					out.write(p.getNomePiloto() + " - " + p.getNomeEquipe() + " - " + p.getPontosObtidos() + "\n");
			}
			
			out.close();
			
		} catch (FileNotFoundException e) {
			Util.wr("Arquivo não encontado: " + e.toString());	
		} catch (Exception e) {
			Util.wr("Ocorreu um erro: " + e.toString());
		}		
	}
	
	private boolean estePilotoPorNomeJaExiste(String nomePiloto){ 
		for (int i = 0; i < lastIndex; i++) {
			if(pilotosQuePontuaram[i] != null){
				if(pilotosQuePontuaram[i].getNomePiloto().equalsIgnoreCase(nomePiloto))
					return true;	
			}								
		}

		return false;
	}

	private Piloto buscaPilotoPorNome(String nomePiloto){ 
		for (int i = 0; i < lastIndex; i++) {
			if(pilotosQuePontuaram[i].getNomePiloto().equalsIgnoreCase(nomePiloto))
				return pilotosQuePontuaram[i];					
		}
		
		return null;
	}

}
