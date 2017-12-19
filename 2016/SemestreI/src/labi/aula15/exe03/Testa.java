package labi.aula15.exe03;

public class Testa {

	public static void main(String[] args) {
		Urna u = new Urna(1, 10);
		u.recebeVoto(3);
		u.recebeVoto(3);
		u.recebeVoto(3);
		u.recebeVoto(3);
		u.recebeVoto(6);
		u.recebeVoto(6);
		u.recebeVoto(6);
		u.recebeVoto(10);
		u.recebeVoto(11);
		u.recebeVoto(14);
		u.exibeResultado();
	}

}
