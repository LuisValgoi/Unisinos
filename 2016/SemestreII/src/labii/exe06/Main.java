package labii.exe06;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		// Numero 01
		ArrayList clientes = buscaDadosDoArquivo("credito.txt");

		// Numero 02
		File file = new File("ClientesIdadesSel.arq");
		gravaObjetosNoArquivo(file, clientes);

		// Numero 03
		ArrayList clientesIdadeSeleta = leObjetosDoArquivo(file, clientes);
		
		// Numero 04
		gravaClientesComRendaAlta("SeletosRendaAlta.txt", clientesIdadeSeleta);
		
	}

	public static ArrayList buscaDadosDoArquivo (String fileName) {
		ArrayList clientes = new ArrayList();
		String f_name = fileName;	

		try {
			FileReader fr = new FileReader (f_name);
			BufferedReader in = new BufferedReader (fr);

			in.readLine();
			String line = in.readLine();
			while ((line = in.readLine()) != null)
			{				
				Cliente cliente = AchaTokens (line);
				clientes.add (cliente);
			}

			in.close ();
		}catch (IOException e) {
			System.out.println ("Erro na leitura do arquivo "+ f_name);
		}		

		return clientes;
	}

	public static Cliente AchaTokens (String line) {
		Cliente p;
		String tk[] = line.split(",");		
		p = new Cliente (tk[0], Integer.parseInt(tk[1]), tk[2], tk[3], tk[4], tk[5]);
		return p;
	}

	public static void gravaObjetosNoArquivo (File f, ArrayList clientes) {
		try	{
			FileOutputStream fos = new FileOutputStream (f);
			ObjectOutputStream os = new ObjectOutputStream (fos);

			for (int i = 0; i < clientes.size(); i++) {
				Cliente cliente = (Cliente) clientes.get(i);

				if(cliente != null){
					if(cliente.getIdade() > 29 && cliente.getIdade() < 61){
						os.writeObject (cliente);	
					}	
				}				
			}	
			
			os.close ();			

		}catch (IOException e)  {
			System.out.println ("Erro ao gravar objeto.");
		}
	}

	
	public static ArrayList leObjetosDoArquivo (File f, ArrayList clientes) {
		ArrayList clienteTemp = new ArrayList();

		try	{
			FileInputStream fos = new FileInputStream (f);
			ObjectInputStream os = new ObjectInputStream (fos);
			
			for (int i = 0; i < clientes.size(); i++) {				
				clienteTemp.add(os.readObject());
			}

			os.close ();		
		} catch (IOException e) {
			System.out.println ("Erro ao abrir arquivo.");
		}
		catch (ClassNotFoundException ce) {
			System.out.println ("Objeto não encontrado.");
		}

		return clienteTemp;
	}

	
	public static void gravaClientesComRendaAlta(String fileName, ArrayList clientesIdadeSeleta){
		File file = new File(fileName);			
			
		try {
			FileWriter fr = new FileWriter (file);
			PrintWriter out = new PrintWriter (fr);
			boolean isCabecalho = true;
			
			if(isCabecalho){
				out.println("Esses clientes são os caras com idade seleta e renda alta");
				out.print("Nome=>Idade=>Credito\n");
				isCabecalho = false;
			}
			
			for (int i = 0; i < clientesIdadeSeleta.size(); i++) {				
				Cliente clienteCurrente = (Cliente)clientesIdadeSeleta.get(i);
				if(clienteCurrente.getRenda().equalsIgnoreCase("Alta")){
					String lineCustom = clienteCurrente.getNome() + "=>" + clienteCurrente.getIdade() + "=>" + clienteCurrente.getCredito();
					out.println(lineCustom);					
				}
			}
			
			out.close();
		} catch (FileNotFoundException ex) {
			System.out.println ("Arquivo não encontrado "+ fileName);
		} catch (Exception ex) {
			System.out.println ("Ocorreu algum erro "+ ex.toString());
		}		
		
	}
	
}
