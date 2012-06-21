package edu.usc.cantwell.empire;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Chris
 *
 */
public class EmpireServer extends EmpireComponent {
	private ServerSocket serverSocket;
	private int port;
	private ArrayList<EmpireServerConnection> connections;
	
	public EmpireServer(){
		this.port = 4444;
		try {
			this.serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server initialized.");
		this.connections = new ArrayList<>();
	}
	
	@Override
	public void run() {
		// Listen for new connection requests
		// When one is received create a new thread to handle it 
		while(true){
			try {
				Socket socket = this.serverSocket.accept();
				System.out.println("Connection request received from " + socket.getInetAddress().toString());
				EmpireServerConnection connection = new EmpireServerConnection(socket);
				this.connections.add(connection);
				connection.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	class EmpireServerConnection extends Thread{
		Socket s;
		ObjectOutputStream oos;
		ObjectInputStream ois;
		
		public EmpireServerConnection(Socket s){
			this.s = s;
			try {
				this.oos = new ObjectOutputStream(this.s.getOutputStream());
				this.ois = new ObjectInputStream(this.s.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(!this.s.isClosed()){
				try {
					EmpireMessage em = (EmpireMessage) this.ois.readObject();
					System.out.println("Message received from client " + this.s.getInetAddress().toString());
					System.out.println(em.s);
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
					this.close();	
				} 
			}
		}
		
		public void write(EmpireMessage em){
			try {
				this.oos.writeObject(em);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void close(){
			System.out.println("Closing connection to client " + this.s.getInetAddress().toString());
			try {
				this.s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
