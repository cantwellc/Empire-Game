/**
 * 
 */
package edu.usc.cantwell.empire;

/**
 * @author Chris
 *
 */
public class EmpireMapNode implements Comparable<EmpireMapNode>{
	private int ID;
	private int OwnerID;
	private final int[] location = new int[2];
	static final int SIZE = 1;
	
	public EmpireMapNode(int id) {
		this.ID = id;
		this.OwnerID = -1;
	}

	@Override
	public int compareTo(EmpireMapNode o) {
		if(this.ID < o.ID){
			return -1;
		}
		else if(this.ID > o.ID){
			return 1;
		}
		else return 0;
	}

}
