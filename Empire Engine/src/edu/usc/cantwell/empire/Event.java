/**
 * 
 */
package edu.usc.cantwell.empire;

/**
 * @author Chris
 *
 */
public class Event {

	enum Type{
		NETWORK,
		WORLD
	}
	
	private Event.Type et;
	
	public Event(Event.Type et){
		this.et = et;
	}
}
