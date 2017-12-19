package labii.exe05;

import java.util.Comparator;

public class ClassPilotos implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Piloto p1 = (Piloto)o1;
        Piloto p2 = (Piloto)o2;
        
        String nomePiloto1 = p1.getNomePiloto();
        String nomePiloto2 = p2.getNomePiloto();
        
        return nomePiloto1.compareTo(nomePiloto2);        
    }
    
}
