package co.edu.uco.ucobet.controller.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;

public abstract class Response{
	
	private List<String> getMessages() {
		return messages;
	}

	public void setMessages(final List<String> messages) {
		this.messages = messages;
	}

	private List<String> messages = new ArrayList<>();
	
	public final void setMessage(final List<String> messages) {
		this.messages = ObjectHelper.getDefault(messages, this.messages);
	}

}
