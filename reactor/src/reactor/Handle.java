package reactor;

import java.util.EventObject;

public class Handle {
	
	private String key;
	
	private EventObject event;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public EventObject getEvent() {
		return event;
	}

	public void setEvent(EventObject event) {
		this.event = event;
	}

	@Override
	public boolean equals(Object obj) {
		return this.getKey().equals(((Handle)obj).getKey());
	}

}
