package reactor.handler;

import reactor.Handle;

public interface EventHandler {

	public void handleEvent();
	public Handle getHandle();
	public void setHandle(Handle handle);
	
}
