package labi.aula15.exe04;

public class Testa {
	public static void main(String[] args){
		Vendedor v = new Vendedor("Luis");
		v.vende(1, 1);
		v.vende(2, 2);
		v.vende(3, 3);		
		v.vende(4, 4);
		v.vende(5, 5);
		v.vende(6, 6);
		v.vende(7, 7);
		v.vende(8, 8);
		v.vende(9, 9);
		v.vende(10, 10);
		v.vende(11, 11);
		v.vende(12, 12);
		System.out.println(v.resumeVendasAno());
	}
}
