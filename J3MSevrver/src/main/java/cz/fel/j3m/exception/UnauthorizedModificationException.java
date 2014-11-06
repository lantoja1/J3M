package cz.fel.j3m.exception;

public class UnauthorizedModificationException extends Exception {

	private static final long serialVersionUID = -8687207877876001818L;

	public UnauthorizedModificationException() {
		super("Unauthorized modification occured.");
	}

}
