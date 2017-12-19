package labi.aula14.exe02;


public class Turma {
	private Aluno[] alu;
	private int qtdAlunosCadastrados;

	// Ctors
	public Turma(int qtdMaximaAlunosArray){
		this.qtdAlunosCadastrados = 0;
		this.alu = new Aluno[qtdMaximaAlunosArray];
	}

	// Especifics
	public void cadastraUmAluno(String nome, double nga, double ngb){
		if(getQtdAlunosCadastrados() < getAlunos().length){
			getAlunos()[qtdAlunosCadastrados] = new Aluno(nome, nga, ngb);
			this.qtdAlunosCadastrados++;
		}
	}

	public void exibeAlunos(){
		for (int i = 0; i < getQtdAlunosCadastrados(); i++) {
			Helpers.wr("Nome Aluno: " + getAlunos()[i].getNome());
			Helpers.wr("Nota GA: " + getAlunos()[i].getNga());
			Helpers.wr("Nota GB: " + getAlunos()[i].getNgb());
			Helpers.wr("Média Final: " + getAlunos()[i].getMediaFinal());
		}
	}

	public double calculaMediaTurma(){
		if(getQtdAlunosCadastrados() == 0){
			return 0;
		}

		double somatorio = 0;		
		for (int i = 0; i < getQtdAlunosCadastrados(); i++) {
			somatorio += getAlunos()[i].getMediaFinal();
		}

		return somatorio / getQtdAlunosCadastrados();
	}

	public double calculaPercentualAprovados(){
		int qtdAprovados = 0;

		for (int i = 0; i < getQtdAlunosCadastrados(); i++) {
			if(getAlunos()[i].getMediaFinal() >= 6){
				qtdAprovados++;
			}
		}

		return (qtdAprovados / getQtdAlunosCadastrados()) * 100;
	}

	public void classificaOrdemAlfabetica(){
		Aluno salva = null;

		for (int i = 0; i < getQtdAlunosCadastrados(); i++){
			for (int j = i + 1; j < getQtdAlunosCadastrados(); j++){
				if(getAlunos()[j].getNome().compareToIgnoreCase(getAlunos()[i].getNome()) < 0){
					salva = getAlunos()[i];
					getAlunos()[i] = getAlunos()[j];
					getAlunos()[j] = salva;
				}
			}
		}
	}

	public void classificaOrdemMediaFinal(){
		Aluno salva = null;

		for (int i = 0; i < getQtdAlunosCadastrados(); i++){
			for (int j = i + 1; j < getQtdAlunosCadastrados(); j++){
				if(getAlunos()[j].getMediaFinal() > getAlunos()[i].getMediaFinal()){
					salva = getAlunos()[i];
					getAlunos()[i] = getAlunos()[j];
					getAlunos()[j] = salva;
				}
			}
		}
	}

	// Getters
	public Aluno[] getAlunos() {
		return alu;
	}

	public int getQtdAlunosCadastrados()
	{
		return qtdAlunosCadastrados;
	}

	public Aluno getUmAluno(int indice){
		if(indice < getQtdAlunosCadastrados() && indice >= 0 ){
			return getAlunos()[indice];
		}			
		else {
			return getUmAluno();
		}
	}

	public Aluno getUmAluno()
	{
		if(getQtdAlunosCadastrados() >= 1){
			return getAlunos()[getQtdAlunosCadastrados() - 1];
		}			
		else{
			return null;
		}
	}
}
