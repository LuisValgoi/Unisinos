package labi.aula14.exe02;

public class Aluno {
	private String nome;
	private double nga;
	private double ngb;
	private double mediaFinal;

	public Aluno(String nomeAluno){
		this.nome = nomeAluno;
		this.setNga(0);
		this.setNgb(0);
		this.mediaFinal = 0;
	}

	public Aluno(String nomeAluno, double nga, double ngb){
		this.nome = nomeAluno;
		this.setNga(nga);
		this.setNgb(ngb);
		this.calculaMediaFinal();		
	}

	public void calculaMediaFinal(){		
		this.mediaFinal = (this.getNga() * 0.33) + (this.getNgb() * 0.67);
	}

	public void substituiGrau(char grauSubstituicao, double notaSubstituicao){
		char temp = Character.toUpperCase(grauSubstituicao);
		
		if(temp == 'A'){
			this.setNga(notaSubstituicao);
		}
		else if(temp == 'B'){
			this.setNgb(notaSubstituicao);
		}else{
			this.setNga(0);
		}
		
		this.calculaMediaFinal();
	}

	public void setNga(double nga) {
		if(nga < 0 || nga > 10){
			this.nga = 0;	
		}
		this.nga = nga;
	}

	public void setNgb(double ngb) {
		if(ngb < 0 || ngb > 10){
			this.ngb = 0;	
		}		
		this.ngb = ngb;
	}


	public String getNome() {
		return nome;
	}


	public double getNga() {
		return nga;
	}


	public double getNgb() {
		return ngb;
	}


	public double getMediaFinal() {
		return mediaFinal;
	}


}
