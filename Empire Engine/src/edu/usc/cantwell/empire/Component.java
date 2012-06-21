package edu.usc.cantwell.empire;


/**
 * @author Chris
 *
 */
public abstract class Component extends Thread{
	private EventHandler eventHandler;
	
	public Component(EventHandler eh) {
		this.eventHandler = eh;
	}
	
	private void callHandler(Event e){
		eventHandler.process(e);
	}
}
