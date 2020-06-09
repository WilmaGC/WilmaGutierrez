import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
public class ClienteTCP {
	public static void main(String[] args) throws IOException {
		Socket socketCliente = null;
		BufferedReader entrada = null;
		PrintWriter salida = null;		
		System.out.println("********CLIENTE*******");
		System.out.println("Ingresar el numero de la opcion elegida");
		System.out.println("1 Para la primera opcion ");
		System.out.println("2 Para la segunda opcion ");
		System.out.println("3 Para la tercera opcion ");
		System.out.println("exit para salir");
		try {
			socketCliente = new Socket("localhost",4673);
			entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
			salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);
		} catch (Exception e) {
			System.out.println(e);
		}		
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true){
				String cad = sc.readLine();				
				salida.println(cad);
				if(cad.equals("exit")) break;
				cad = entrada.readLine();
				System.out.println("la respuesta del servidor es "+cad);				
			}			
		} catch (Exception e) {
			System.out.println(e);
		}
		salida.close();
		entrada.close();
		sc.close();
		socketCliente.close();
	}
}
