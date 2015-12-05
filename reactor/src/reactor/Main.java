package reactor;

import reactor.handler.EventHandler;
import reactor.handler.impl.ClickHandler;
import reactor.handler.impl.MessageHandler;

public class Main {

	public static void main(String[] args) {
		try {
			Reactor reactor = new Reactor(new SynchronousEventDemultiplexer());
			
			// Message Handler
			EventHandler messageHandler= new MessageHandler();
			messageHandler.setHandle(new Handle());
			messageHandler.getHandle().setKey(EnumEventType.MessageEvent.toString());
			
			reactor.registerHandler(messageHandler);
			
			// Click handler
			EventHandler clickHandler = new ClickHandler();
			clickHandler.setHandle(new Handle());
			clickHandler.getHandle().setKey(EnumEventType.ClickEvent.toString());
			
			reactor.registerHandler(clickHandler);
			
			Thread threadReactor = new Thread(reactor);
			Environment environment = new Environment(reactor);
			
			threadReactor.start();
			environment.start();
			
			threadReactor.join();
			environment.join();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
