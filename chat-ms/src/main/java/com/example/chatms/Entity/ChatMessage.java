package com.example.chatms.Entity;

public class ChatMessage {
	 private String message;
	 private String senderName;
	 private String receiverName;
	 private Status status;
	public ChatMessage(String message, String senderName, String receiverName, Status status) {
		super();
		this.message = message;
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.status = status;
	}
	public ChatMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	 
	 
}

