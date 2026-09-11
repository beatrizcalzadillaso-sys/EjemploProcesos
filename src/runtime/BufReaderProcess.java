package runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufReaderProcess {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("CMD");
		
		try {
			Process proceso = pb.start();
			
			
			System.out.println("Parte 1");
		
			InputStream inStream = proceso.getInputStream();
			System.out.println();
			
			int character;
			while ((character = inStream.read())!=-1) {
				System.out.println((char)character);
			}
			
			inStream.close();
			
	
			System.out.println("Parte 2");
			InputStream er = proceso.getInputStream();
			BufferedReader bfrer = new BufferedReader(new InputStreamReader(er));
			
			String linea = null;
			while((linea = bfrer.readLine())!=null) {
				System.out.println(linea);
			}
			
			er.close(); 
			
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		
	}

}
