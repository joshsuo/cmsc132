package exceptionsEx;

/* Checked exception */
public class NotPayingAttentionException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotPayingAttentionException(String message) {
		super(message);
	}
}
