package progii.streams;

import java.io.File;

public class ListaDir {
	
	public static void main (String args []) {
		String nomeDir = ".";
		File f1 = new File (nomeDir);
		if (f1.isDirectory ( ))
		{
			System.out.println ("Diretório "+nomeDir);
			String s[ ] = f1.list( );
			for (int i=0; i<s.length; i++)
			{
				File f = new File (s[i]);
				System.out.print (s[i]);
				if (f.isDirectory ( )) System.out.println (" <dir> ");
				else System.out.println (" <file>");
			}
		}
		else System.out.println (nomeDir + " não é um diretório.");
	}
	
}