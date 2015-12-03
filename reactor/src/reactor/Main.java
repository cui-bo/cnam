package reactor;

public class Main {

	public static void main(String[] args) {
		try {
			Reactor reactor = new Reactor(new SynchronousEventDemultiplexer());
			
			// Message Handler
			EventHandler messageHandle = new MessageHandler();
			messageHandle.setHandle(new Handle());
			messageHandle.getHandler().setKey(EnumEventType.MessageEvent.toString() );
			reactor.registerHandler(messageHandle);
			
			// Click handler
			EventHandler clickHandler = new ClickHandler();
			clickHandler.setHandle(new Handle());
			clickHandler.getHandler().setKey(EnumEventType.ClickEvent.toString());
			reactor.registerHandler(clickHandler);
			
			Thread threadReactor = new Thread();
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
