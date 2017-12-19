package labii.exe04;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControleFederacao {

	public static void main(String[] args) {
		// variaveis
		int qtdEquipes = 10;
		int qtdPilotosPorEquipe = 2;
		boolean continuar = true;
		Scanner t;
		CorridaX1 corrida = new CorridaX1();
		
		// operacao
		do {			
			try {
				for (int i = 0; i < qtdEquipes; i++) {				
					// variaveis
					t = new Scanner(System.in);
					String nomeEquipe = "";
					String nomePiloto = "";
					double pontosPiloto = 0.0;

					// perguntas
					wr("--------");
					wr("Equipe nº: " + (i+1));					
					wr("Nome Equipe?");					
					nomeEquipe = t.nextLine();					
					
					for (int j = 0; j < qtdPilotosPorEquipe; j++) {
						wr("Piloto nº: " + (j+1));						
						wr("Nome piloto?");
						nomePiloto = t.next();					
						wr("Pontos piloto?");
						pontosPiloto = t.nextDouble();

						// criacao e adicao do piloto
						corrida.addPilotosNaCorrida(new PilotoEquipe(nomePiloto, nomeEquipe, pontosPiloto));
					}			
				}
			} catch (InputMismatchException e) {
				continuar = false;
				wr("Ops, Ocorreu o seguinte erro: " +e.toString() + ". Vamos comecar novamente!");
			} catch (Exception e) {
				continuar = false;
				wr("Ops, Ocorreu o seguinte erro: " +e.toString() + ". Vamos comecar novamente!");
			}
			
			wr("-------");
			// resultado nao ordenado
			corrida.exibirPilotos();
			
			// ordenacao
			corrida.ordena();
			
			wr("-------");
			// resultado ordenado
			corrida.exibirPilotos();
			
		} while (!continuar);		
	}

	private static void wr(String text){
		System.out.println(text);
	}

}
