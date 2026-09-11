package processBuilder;

import java.io.IOException;
import java.util.Map;

public class ProcessBuilderNotepad {

	public static void main(String[] args) {
		
		System.out.println("Vamos a lanzar el Notepad con ProcessBuilder...");
		String procesoNotepad = "Notepad.exe";
		
		try {
			ProcessBuilder abrirNotepad = new ProcessBuilder(procesoNotepad);
			
			Map<String,String> environmentValues = abrirNotepad.environment();
			System.out.println("Numero de procesadores: "+ environmentValues.get("NUMBER_OF_PROCESSORS"));
			
			for (Map.Entry<?, ?> entry : environmentValues.entrySet()) {
			     System.out.printf("%-35s : %s%n", entry.getKey(), entry.getValue());
			}
			
			Process ejecutarNotepad = abrirNotepad.start();
			
			System.out.println("El id de proceso es "+ejecutarNotepad.pid());
			
			int codCierre = ejecutarNotepad.waitFor();
			
			if (codCierre == 0) {
				System.out.println("Se ha cerrado manualmente el notepad con el codigo "+codCierre);
				System.out.println("Codigo de proceso: "+ejecutarNotepad.pid());
			}
			else {
				System.out.println("Ha ocurrido un error");
			}
			
		} catch (IOException|InterruptedException exc) {
			exc.printStackTrace();
		}

	}

}
