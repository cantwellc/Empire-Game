package edu.usc.cantwell.empire;
/**
 * 
 */

/**
 * @author Chris
 *
 */
public class EmpireEngine {

	/**
	 * @param args
	 */
	private EmpireServer server;
	private EmpireWorld world;

	
	public EmpireEngine(){
		this.server = new EmpireServer();
		this.server.start();
		
		this.world = new EmpireWorld();
		this.world.start();
	}
	
	public static void main(String[] args) {
		new EmpireEngine();
	}

}
