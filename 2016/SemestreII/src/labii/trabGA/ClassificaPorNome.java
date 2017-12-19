package labii.trabGA;

import java.util.Comparator;

public class ClassificaPorNome implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Piloto p1 = (Piloto)o1;
        Piloto p2 = (Piloto)o2;        

        int resultado = 0;        
        if(p1 != null & p2 != null)
        	resultado = p1.getNomePiloto().compareTo(p2.getNomePiloto());
        
        return resultado;
	}

}
