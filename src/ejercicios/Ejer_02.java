package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejer_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  ProcessBuilder pb =
	                new ProcessBuilder("cmd", "/c", "dir");

	        // Une la salida de errores con la salida normal para poder leer ambos desde el mismo stream
	        pb.redirectErrorStream(true);

	        try {

	            Process proceso = pb.start();

	            BufferedReader lector =
	                    new BufferedReader(
	                            new InputStreamReader(
	                                    proceso.getInputStream()
	                            )
	                    );

	            String linea;

	            while ((linea = lector.readLine()) != null) {
	                System.out.println(linea);
	            }

	            int codigoSalida = proceso.waitFor();

	            System.out.println(
	                    "Código de salida: " + codigoSalida
	            );

	        } catch (IOException | InterruptedException e) {

	            e.printStackTrace();
	        }

	}
}
