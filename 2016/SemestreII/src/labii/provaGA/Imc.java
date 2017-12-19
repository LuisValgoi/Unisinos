package labii.provaGA;

import java.io.*;
import java.util.ArrayList;

public class Imc {

	public static void main(String[] args) {
		Paciente paciente = pegaPacienteDosArquivos("IMC.txt");

		ArrayList pacientes = setaPacientesArrayList(paciente.getPacientes());
		File file = new File("AvalPaciente.txt");
		setNoArquivo(file, pacientes);

		Paciente pacientePesoIdeal = pegaPacientePesoIdeal(pacientes);
		pacientePesoIdeal.classifica(pacientePesoIdeal.getPacientes());	

		mostraTelaPesoIdeal(pacientePesoIdeal.getPacientes());
	}


	private static Paciente pegaPacienteDosArquivos (String fileName) {		
		String fileN = fileName;
		Paciente paciente = new Paciente();

		try {					
			FileReader fr = new FileReader (fileN);
			BufferedReader in = new BufferedReader (fr);

			in.readLine();
			in.readLine();
			in.readLine();

			String line = in.readLine();
			while (line != null)
			{
				String[] lineData = data(line);
				paciente.inserePaciente(lineData[0], Double.parseDouble(lineData[1]), Integer.parseInt(lineData[2]));
				line = in.readLine();
			}

			in.close ();

		}catch (IOException e) {
			System.out.println ("Erro na leitura do arquivo " + fileN);
		}catch (Exception e)  {
			System.out.println ("Ops. Ocorreu algum erro" + e.toString());
		}

		return paciente;
	}

	private static ArrayList setaPacientesArrayList(Paciente[] paciente){
		ArrayList pacientes = new ArrayList();

		for (Paciente p : paciente) {
			if(p != null){
				pacientes.add(p);
			}			
		} 

		return pacientes;
	}

	public static void setNoArquivo (File file, ArrayList pacientes) {
		try	{
			FileWriter fw = new FileWriter (file);
			PrintWriter out = new PrintWriter (fw);

			for (int i = 0; i < pacientes.size(); i++) {
				Paciente paciente = (Paciente)pacientes.get(i);

				if(paciente != null){					
					String msg = pegaMsg(paciente);
					out.println(paciente.getNomePaciente() + " / " + msg);
				}				
			}	

			out.close ();			

		}catch (IOException e)  {
			System.out.println ("Erro ao gravar objeto." + e.toString());
		}catch (Exception e)  {
			System.out.println ("Ops. Ocorreu algum erro" + e.toString());
		}
	}

	private static Paciente pegaPacientePesoIdeal(ArrayList pacientes) {
		int count = 0;
		for (int i = 0; i < pacientes.size(); i++) {
			Paciente paciente = (Paciente)pacientes.get(i);

			if(paciente != null){
				double imc = paciente.calcIMC(paciente);
				if(imc >= 18.5 && imc < 25){
					count++;					
				}
			}
		}	

		Paciente p = new Paciente(count);
		for (int i = 0; i < pacientes.size(); i++) {
			Paciente paciente = (Paciente)pacientes.get(i);

			if(paciente != null){
				double imc = paciente.calcIMC(paciente);
				if(imc >= 18.5 && imc < 25){
					p.inserePaciente(paciente);					
				}
			}
		}
		return p;
	}

	private static void mostraTelaPesoIdeal(Paciente[] pacientesPesoIdeal){
		for (int i = 0; i < pacientesPesoIdeal.length; i++) {
			if(pacientesPesoIdeal[i].getPacientes() != null){
				esc("Esses pacientes estão com o peso ideal");
				esc(pacientesPesoIdeal[i].getNomePaciente() + " => " + pacientesPesoIdeal[i].getAltura() + " =>" + pacientesPesoIdeal[i].getPeso());
			}
		}	
	}
	private static String pegaMsg(Paciente paciente) {
		double imc = paciente.calcIMC(paciente);

		String msg = "";

		if(imc < 18.5){
			msg = "Você está abaixo do peso ideal";
		}else if(imc >= 18.5 && imc < 25){
			msg = "Parabéns - voce está com o peso ideal!";
		}else if(imc >= 25.0 && imc < 30){
			msg = "Voce está com sobrepeso - acima do peso";
		}else if(imc >= 30.0 && imc < 35){
			msg = "Apresenta obesidade grau I";
		}else if(imc >= 35.0 && imc < 40){
			msg = "Apresenta obesidade grau II";
		}else if(imc >= 40){
			msg = "Apresenta obesidade grau III";
		}

		return msg;
	}

	private static String[] data (String line) {
		return line.split("@");
	}

	private static void esc(String v) {
		System.out.println(v);
	}


}
