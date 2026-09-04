/**
 * 
 */
package es;
import java.io.File;
/**
 * 
 */
public class MainProcess {

	
	public static void main(String[] args) {
		System.out.println("Estamos ejecutando el proceso secundario...");
		try {
			ProcessBuilder builder;
			
			builder = new ProcessBuilder("java","es.SecondaryProcess");
			builder.directory(new File("bin"));
			Process process = builder.start();
			
			int returnedValue= process.waitFor();
			
			if (returnedValue==0) {
				System.out.println("Proceso secundario finalizado con exito");
			} else {
				System.out.println("Proceso secundario ha fallado");
				System.out.println("Codigo de error: "+returnedValue);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
