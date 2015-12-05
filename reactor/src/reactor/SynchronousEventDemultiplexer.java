package reactor;

import java.util.List;

import reactor.handler.EventHandler;

public class SynchronousEventDemultiplexer {
	
	public EventHandler select(Handle handle, List<EventHandler> eventHandlers) {
		for (EventHandler eventHandler : eventHandlers) {
			if(eventHandler.getHandle().equals(handle)) {
				return eventHandler;
			}
		}
		 throw new RuntimeException("Not found the corresponding event handler!");
	}

}
