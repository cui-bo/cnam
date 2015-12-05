package reactor;

import java.util.EventObject;

public class Environment extends Thread {

	Reactor reactor;
	private final int FOIS = 5;
	
	public Environment(Reactor reactor) {
		this.reactor = reactor;
	}

	@Override
	public synchronized void run() {
		
		int compteurClickEvent = 1;
		int compteurMessageEvent = 1;
		
		for (int i = 0; i < FOIS; i++) {
			
			synchronized (reactor) {	// Traitement Click event
				Handle handleClick = new Handle();
				handleClick.setEvent(new EventObject(EnumEventType.ClickEvent + "_" + compteurClickEvent));
				handleClick.setKey(EnumEventType.ClickEvent.toString());
				reactor.receive(handleClick);
				compteurClickEvent++;
			}
			
			synchronized (reactor) {	// Traitement Message event
				Handle handleMessage = new Handle();
				handleMessage.setEvent(new EventObject(EnumEventType.MessageEvent + "_" + compteurMessageEvent));
				handleMessage.setKey(EnumEventType.MessageEvent.toString());
				reactor.receive(handleMessage);
				compteurMessageEvent++;
			}
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
