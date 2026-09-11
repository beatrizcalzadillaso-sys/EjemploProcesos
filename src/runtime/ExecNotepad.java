/**
 * 
 */
package runtime;

import java.io.IOException;

/**
 * 
 */
public class ExecNotepad {

	public static void main(String[] args) {
		System.out.println("Vamos a lanzar el notepad...");
		
		String [] infoProceso = {"notepad"};
		
		try {
			
			Process procesoNotepad = Runtime.getRuntime().exec(infoProceso);
			
			System.out.println("El ID del proceso es "+procesoNotepad.pid());
			
			int returnCode= procesoNotepad.waitFor();
			
			if(returnCode ==0) {
				System.out.println("Cerrado el notepad, fin del Proceso con el codigo "+returnCode);
			}
			else {
				System.out.println("Hubo un error de ejecucion del notepad");
			}
			
			
			
		} catch (IOException|InterruptedException exception) {
			exception.printStackTrace();
		}
	}

}
