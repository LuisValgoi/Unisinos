package labi.aula04.exe04;


public class TesteData {

	public static void main(String[] args) {
		Data data = new Data(20160305);		
		System.out.println(data.getDataPadrao());
		System.out.println(data.getDataInvertida());
		
		System.out.println("=========================");
				
		Data data2 = new Data(5,03,2016);		
		System.out.println(data2.getDataPadrao());
		System.out.println(data2.getDataInvertida());
	}
}
