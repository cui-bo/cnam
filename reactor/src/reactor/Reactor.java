package reactor;

public class Reactor {
	
	private Handle receivedHandle;
	private SynchronousEventDemultiplexer synchronousEventDemultiplexer;

	public Reactor(SynchronousEventDemultiplexer synchronousEventDemultiplexer) {
		this.synchronousEventDemultiplexer = synchronousEventDemultiplexer;
	}
	
	public void registerHandler(EventHandler eventHandler) {
		
	}
	
	public void removeHandler(EventHandler eventHandler) {
		
	}
	
	public void startHandleEvent() {
		System.out.println("Class = Reactor, Methode = startHandleEvents :: Atente événements...");
	}
	
	public void receive(Handle handle) {
		System.out.println("Class = Reactor, Methode = receive :: recepton d'un événement !!!" + receivedHandle.getKey());
	}

	public void run() {
		
	}
}
