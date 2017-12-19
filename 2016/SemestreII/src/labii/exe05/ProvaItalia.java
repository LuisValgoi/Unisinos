package labii.exe05;

import java.util.Arrays;

public class ProvaItalia {
    private Piloto[] pilotos;
    private int lastIndex;

    public ProvaItalia(int qtdPilotos) {
        this.pilotos = new Piloto[qtdPilotos];
    }
    
	public Piloto[] getPilotos() {
		return pilotos;
	}

	public void inserePilotos(Piloto p){
        this.pilotos[lastIndex++] = p;
    }
    
    public void exibePilotos(){
        for (Piloto p : pilotos) {
            if(p != null)
                System.out.println(p.toString());
        }
    }
    
    public void ordenaPorOrdemAlfabetica(){
        Arrays.sort(pilotos, new ClassPilotos());
    }
    
    public void ordenaPorPontos(){
        Arrays.sort(pilotos);
    }
}
