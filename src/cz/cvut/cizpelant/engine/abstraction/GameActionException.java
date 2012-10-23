package cz.cvut.cizpelant.engine.abstraction;

public class GameActionException extends Exception {

	private static final long serialVersionUID = -909764891885763378L;
	
	public GameActionException() { super(); }
	public GameActionException(String message) { super(message); }
	public GameActionException(String message, Throwable cause) { super(message, cause); }
	public GameActionException(Throwable cause) { super(cause); }
}

