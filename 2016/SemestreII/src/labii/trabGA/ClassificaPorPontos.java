package labii.trabGA;

import java.util.Comparator;

public class ClassificaPorPontos implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Piloto p1 = (Piloto)o1;
        Piloto p2 = (Piloto)o2;
        
        int resultado = 0;        
        if(p1 != null & p2 != null)
        	resultado = p2.getPontosObtidos() - p1.getPontosObtidos();
        
        return resultado;
	}

}
