package labii.aula10;

import java.util.Comparator;

public class ClassificaPorUltimaCompra implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Cliente c1 = (Cliente)o1;
		Cliente c2 = (Cliente)o2;
        
        double resultadoAux = c2.getUltimaCompra() -  c1.getUltimaCompra();
        int resultado = (int)resultadoAux;
        
        return resultado;
	}

}