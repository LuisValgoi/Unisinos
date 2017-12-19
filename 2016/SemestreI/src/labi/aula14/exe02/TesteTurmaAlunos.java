package labi.aula14.exe02;

public class TesteTurmaAlunos{
	
	static Teclado t = new Teclado();
	
	private static char resposta(String msg) {
		char resp;
		
		do{
			resp= Character.toUpperCase(t.leChar( msg + " [S-sim N-não] ? "));
		}while (resp != 'S'&& resp != 'N');
		
		return resp;
	}
	
	public static void main(String args[]){
		Turma turma = new Turma(t.leInt("Digite a quantidade máxima de alunos"));
		
		while (resposta("Quer cadastrar aluno") == 'S') {
			turma.cadastraUmAluno(t.leString("Nome do aluno"), t.leDouble("Nota do Grau A"), t.leDouble("Nota do Grau B"));			
			
			if (resposta("substituiu grau A") == 'S'){
				turma.getUmAluno().substituiGrau('A', t.leDouble("Nota do Grau C"));
				
			}else if (resposta("substituiu grau B") == 'S'){
				turma.getUmAluno().substituiGrau('B', t.leDouble("Nota do Grau C"));
				
				// exibe na tela a média do aluno e a mensagem “Aprovado” ou “Reprovado”
				double nota = turma.getUmAluno().getMediaFinal();
				System.out.println(nota + "|" + (nota >= 6 ? "Aprovado" : "Reprovado"));	
			}
		}
		
		// exibe, na tela, a turma de alunos, o percentual de aprovados e a média da turma
		turma.exibeAlunos();
		turma.calculaPercentualAprovados();
		turma.calculaMediaTurma();

		// classifica e exibe, na tela, a turma de alunos em ordem alfabética
		turma.classificaOrdemAlfabetica();
		turma.exibeAlunos();
		
		// classifica e exibe, na tela, a turma de alunos em ordem decrescente de média final
		turma.classificaOrdemMediaFinal();;
		turma.exibeAlunos();
	}	
}
