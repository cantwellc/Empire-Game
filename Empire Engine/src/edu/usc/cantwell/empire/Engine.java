package edu.usc.cantwell.empire;


/**
 * 
 */

/**
 * @author Chris
 *
 */
public class Engine implements EventHandler{

	/**
	 * @param args
	 */
	private Server server;
	private World world;

	
	public Engine(){
		this.server = new Server(this);
		this.server.start();
		
		this.world = new World(this);
		this.world.start();
	}
	
	public static void main(String[] args) {
		new Engine();
	}

	@Override
	public void process(Event e) {
		// TODO Auto-generated method stub
		
	}

}
