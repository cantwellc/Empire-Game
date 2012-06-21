/**
 * 
 */
package edu.usc.cantwell.empire;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Chris
 *
 */
public class World extends Component {
	private Map<Integer, MapNode> map;
	
	public World(EventHandler h) {
		super(h);
		map = new TreeMap<>();
	}
	
	@Override
	public void run() {
		
	}
}
