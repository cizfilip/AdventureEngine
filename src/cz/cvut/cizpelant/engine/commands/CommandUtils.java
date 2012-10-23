package cz.cvut.cizpelant.engine.commands;

public class CommandUtils {
	private CommandUtils() {}
	
	public static boolean isNullOrEmptyString(String str) {
		if(str == null || str.isEmpty())
			return true;
		return false;
	}
}
