package cz.cvut.cizpelant.engine.abstraction;

public class GameCommandResult {
	private boolean successful;
	private String message;
	
	
	private GameCommandResult(boolean successful, String message) {
		this.successful = successful;
		this.message = message;
	}
	
	public boolean wasSuccessful()
	{
		return successful;
	}

	public String getMessage() {
		return message;
	}
	
	
	public static GameCommandResult SuccessfulResult() {
		return new GameCommandResult(true, "");
	}
	
	public static GameCommandResult UnsuccessfulResult(String message) {
		return new GameCommandResult(false, message);
	}
	
	
}
