package progii.comparable;
import java.util.Arrays;

public class SortCarObjectCars1 {

	public static void main(String args[]){

		Cars1[] carros = new Cars1[4];
		Cars1 gol = new Cars1("Gol", "Economico",70); 
		Cars1 fusca = new Cars1("Fusca", "Esportivo",165); 
		Cars1 golf = new Cars1("Golf", "Esportivo",95); 
		Cars1 tuareg = new Cars1("Tuareg", "SUV",180); 

		carros[0]=gol;
		carros[1]=fusca;
		carros[2]=golf;
		carros[3]=tuareg;

		Arrays.sort(carros);

		int i=0;
		for(Cars1 temp: carros){
			System.out.println("carros " + ++i + " : " + temp.getcarName() + ", Potencia : " + temp.getPower());
		}

	}	
}    
