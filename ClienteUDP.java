import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {

	public static void main(String[] args) {
		System.out.println("*****CLIENTE*******");
		try {
			DatagramSocket socketUDP = new DatagramSocket();
			int puerto = 6543;
			InetAddress host = InetAddress.getByName("localhost");
			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
			String cad;
			while(true) {
				cad = sc.readLine();
				if(cad.equals("exit")) break;
				byte [] men = cad.getBytes();
				DatagramPacket peticion = new DatagramPacket(men,cad.length(),host,puerto);
				socketUDP.send(peticion);
				byte [] bufer = new byte[10000];
				DatagramPacket mensaje = new DatagramPacket(bufer,bufer.length);
				socketUDP.receive(mensaje);
				System.out.println("la respuesta del servidor es, " + new String(mensaje.getData()));
			}			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
