package labi.aula07.exe02;

public class Teste {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Luis");
		pessoa.setEmail("luisvalgoi@outlook.com");
		pessoa.setAltura(1.79);
		pessoa.setPeso(78);		
		pessoa.setDataNascimento(new Data(10,3,1997));
		
		Teste.escreve("O nome �: " + pessoa.getNome());
		Teste.escreve("O email �: " + pessoa.getEmail());
		Teste.escreve("O peso �: " + pessoa.getPeso() + "kg.");
		Teste.escreve("A altura �: " + pessoa.getAltura() + "cm.");
		Teste.escreve("A data de nascimento �: " + pessoa.getDataNascimento());
		Teste.escreve("A idade �: " + pessoa.getIdade());
		
		if(pessoa.isFaixaEtariaMaioridade()){
			Teste.escreve("A pessoa **�** da maioridade");	
		}else{
			Teste.escreve("A pessoa **N�o** � da maioridade");
		}
		
		if(pessoa.podeComprarBebida()){
			Teste.escreve("A pessoa **PODE** comprar bebida");
		}else{
			Teste.escreve("A pessoa **N�O PODE** comprar bebida");
		}
	}
	
	private static void escreve(String valor){
		System.out.println(valor);
	}
}
