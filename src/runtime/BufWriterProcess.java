package runtime;

import java.io.IOException;
import java.io.OutputStream;

public class BufWriterProcess {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("CMD");
		
		try {
			Process proceso = pb.start();
			OutputStream outStream = proceso.getOutputStream();
			String dato = "DatoParaElPrograma\\n";
			outStream.write(dato.getBytes());
			outStream.flush();
			
			outStream.close();
		} catch(IOException e) {
			
		}

	}

}
