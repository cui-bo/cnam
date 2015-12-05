package reactor.handler.impl;

import reactor.Handle;
import reactor.handler.EventHandler;

public class MessageHandler implements EventHandler {
	
	private Handle handle;

	@Override
	public void handleEvent() {
		System.out.println("Class = reactor.MessageHandler, Methode = handleEvent :: traitement evenement" + getHandle().getEvent().toString());
	}

	@Override
	public Handle getHandle() {
		return handle;
	}

	@Override
	public void setHandle(Handle handle) {
		this.handle = handle;
	}

}
