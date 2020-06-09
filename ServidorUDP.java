import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.StringTokenizer;

public class ServidorUDP {

	public static void main(String[] args) {
		System.out.println("*****SERVIDOR*****");
		try {
			DatagramSocket socketUDP = new DatagramSocket(6543);
			byte mensajeEnviar[] = new byte[1000];
			while(true) {
				DatagramPacket paqueteRecibido = new DatagramPacket(new byte[1024],1024);
				socketUDP.receive(paqueteRecibido);					
				String mensajeRecibido = new String(paqueteRecibido.getData());
				
				
				String respuestaCliente = " el tamano de la cadena es: "+ Integer.toString(contar(mensajeRecibido));				
				mensajeEnviar = respuestaCliente.getBytes();
				DatagramPacket paqueteEnviar = new DatagramPacket(mensajeEnviar, mensajeEnviar.length,paqueteRecibido.getAddress(),paqueteRecibido.getPort());
				socketUDP.send(paqueteEnviar);
				
				
				System.out.println("mensaje del Cliente "+ new String(paqueteRecibido.getData()));
			}			
		} catch (Exception e) {
			System.out.println(e);
		}

	}	
	public static int contar(String x) {
		StringTokenizer palabra = new StringTokenizer(x);
		return palabra.countTokens();
	}

}
