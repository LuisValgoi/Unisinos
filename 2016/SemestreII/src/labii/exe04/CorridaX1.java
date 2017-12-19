package labii.exe04;
import java.util.Arrays;

public class CorridaX1 {	
	
	public PilotoEquipeInterface[] pilotos = new PilotoEquipeInterface[20];	
	private int ultimoIdx = 0;	
	
	public void addPilotosNaCorrida(PilotoEquipe piloto){
		this.pilotos[ultimoIdx++] = piloto;
	}
	
	public void exibirPilotos(){
		for (PilotoEquipeInterface p : pilotos) {
			if(p != null)
				System.out.println("Equipe: " + p.getEquipe() + ". Nome: " + p.getNome() + ". Pontos: " + p.getPontos() + ".");
		}
	}
	
	public void ordena(){
		Arrays.sort(this.pilotos);
	}
	
}
