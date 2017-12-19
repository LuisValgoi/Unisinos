package progii.abstracts;

public class FolhaDePagamento {
	public Empregado[] empregados;
	private int lastIdx;

	public FolhaDePagamento(int nEmp) {
		this.empregados = new Empregado[nEmp];
	}

	public void insereEmpregado(Empregado emp){
		Empregado temp = emp;
		this.empregados[lastIdx] = temp; 
	}

	public void removeEmpregado(int idx){
		this.empregados[idx] = null;
	}

	public void listaEmpregados(){
		for (Empregado e : empregados) {
			if(e != null)
				System.out.println(e.getNome());
		}
	}

	public Empregado maiorSalario(){
		double maiorSalario = empregados[0].calculaSalario();
		Empregado empMaiorSalario = null;

		for (Empregado e : empregados) {
			if(e != null){
				double salarioCurrent = e.calculaSalario();
				
				if(salarioCurrent > maiorSalario){
					maiorSalario = salarioCurrent;					
					Empregado temp = e;
					empMaiorSalario = temp;
				}
			}
		}

		return empMaiorSalario;
	}

	public Empregado menorSalario(){
		double menorSalario = empregados[0].calculaSalario();
		Empregado empMenorSalario = null;

		for (Empregado e : empregados) {
			if(e != null){
				double salarioCurrent = e.calculaSalario();
				
				if(salarioCurrent < menorSalario){
					menorSalario = salarioCurrent;					
					Empregado temp = e;
					empMenorSalario = temp;
				}
			}
		}

		return empMenorSalario;
	}

	public double mediaSalarial(){
		double total = 0.0;
		int countEmpregados = 0;
		
		for (Empregado e : empregados) {
			if(e != null){
				countEmpregados++;
				total += e.calculaSalario();
			}
		}

		return total / countEmpregados;
	}
}
