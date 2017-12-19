package labi.aula08.exe02;

public class GeraExibeSequenciaInteiros {
	private int limiteUm;
	private int limiteDois;

	public GeraExibeSequenciaInteiros(int limiteUm, int limiteDois){
		if(limiteUm > limiteDois){
			this.limiteUm = limiteDois;
			this.limiteDois = limiteUm;	
		}else{
			this.limiteUm = limiteUm;
			this.limiteDois = limiteDois;
		}
	}

	public void geraExibeInt(){
		for (int i = this.limiteUm; i <= this.limiteDois; i++){
			System.out.println(i);
		}
	}

	public void geraExibePares(){
		for (int i = this.limiteUm; i <= this.limiteDois; i++){
			if(i % 2 == 0){
				System.out.println(i);	
			}			
		}
	}

	public void geraExibeMultiplos(){
		for (int i = this.limiteUm; i <= this.limiteDois; i++){
			if(i % 3 == 0 && i % 5 == 0){
				System.out.println(i);
			}	
		}
	}

	public void geraExibeMultiplosCalcMed(int m){
		double valor = 0;
		int count = 0;

		for (int i = this.limiteUm; i <= this.limiteDois; i++){
			if(i % m == 0){
				valor += i;
				count++;
				System.out.println(i);
			}	
		}
		System.out.println("A media é: " + valor/count);
	}

	public void geraExibeDivisores(){
		for (int i = 1; i <= this.limiteDois; i++){
			if(this.limiteDois % i == 0){
				System.out.println(i);
			}
		}
	}

	public void geraExibePrimos(){
		boolean ehPrimo;
		int num, inicio;

		inicio = limiteUm;
		if (inicio == 1)
			inicio++; 
		
		for (num = inicio; num <= limiteDois; num++){

			ehPrimo = true;
			for(int i=2; i<= Math.sqrt(num)&& ehPrimo; i++)

				if (num%i == 0)

					ehPrimo = false;
			// fim for i

			if (ehPrimo)
				System.out.println( num );
		}//fim for num 
	}
}	
