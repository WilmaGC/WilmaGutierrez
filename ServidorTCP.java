import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class ServidorTCP {
	public static void main(String[] args) throws IOException{
		ServerSocket socketServidor =null;
		Socket socketCliente = null;
		BufferedReader entrada = null;
		PrintWriter salida = null;
		System.out.println("*******SERVIDOR******");
		try {
			socketServidor = new ServerSocket(4673); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			socketCliente = socketServidor.accept();
			entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
			salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);		
			while(true) {
				String cad = entrada.readLine();
				if(cad.equals("exit")) break;
				System.out.println("se recibio el mensaje "+cad);
				String respuesta = "nulo";
				if(cad.equals("1")) respuesta="papel";
				if(cad.equals("2")) respuesta="piedra";
				if(cad.equals("3")) respuesta="tijera";
				salida.println(respuesta);				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		salida.close();
		entrada.close();
		socketServidor.close();
		socketCliente.close();
	}
}
