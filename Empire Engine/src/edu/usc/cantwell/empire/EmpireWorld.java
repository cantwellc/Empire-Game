/**
 * 
 */
package edu.usc.cantwell.empire;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Chris
 *
 */
public class EmpireWorld extends EmpireComponent {
	private Map<EmpireMapNode, ArrayList<EmpireMapNode>> map;
	private ArrayList<EmpirePlayer> players;
	
	public EmpireWorld() {
		map = new TreeMap<>();
		players = new ArrayList<>();
	}
	
	@Override
	public void run() {
		
	}
}
