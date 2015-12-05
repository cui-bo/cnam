package reactor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import reactor.handler.EventHandler;

public class Reactor implements Runnable {
	
	private Queue<Handle> receivedHandle;
	private SynchronousEventDemultiplexer synchronousEventDemultiplexer;
	private List<EventHandler> eventHandlers;

	public Reactor(SynchronousEventDemultiplexer synchronousEventDemultiplexer) {
		this.synchronousEventDemultiplexer = synchronousEventDemultiplexer;
	}
	
	public void registerHandler(EventHandler eventHandler) {
		getEventHandlers().add(eventHandler);
	}
	
	public void removeHandler(EventHandler eventHandler) {
		getEventHandlers().remove(eventHandler);
	}
	
	public void receive(Handle handle) {
		System.out.println("Class = Reactor, Methode = receive :: recepton d'un événement !!!" + handle.getEvent().toString());
		getReceivedHandle().add(handle);
	}
	
	public void startHandleEvent() {
		System.out.println("Class = Reactor, Methode = startHandleEvents :: Atente événements...");

		for (Handle handle : getReceivedHandle()) {
			EventHandler eventHandler = synchronousEventDemultiplexer.select(handle, eventHandlers);
			eventHandler.setHandle(handle);
			eventHandler.handleEvent();
		}
	}
	
    @Override
	public void run() {
		startHandleEvent();
	}

	public List<EventHandler> getEventHandlers() {
		if (eventHandlers == null) {
			eventHandlers = new ArrayList<>();
		}
		return eventHandlers;
	}

	public Queue<Handle> getReceivedHandle() {
		if (receivedHandle == null) {
			receivedHandle = new ArrayDeque<>();
		}
		
		return receivedHandle;
	}
	
}
