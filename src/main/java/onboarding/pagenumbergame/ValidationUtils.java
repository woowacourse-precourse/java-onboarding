package onboarding.pagenumbergame;

public class ValidationUtils {

	private static final int MIN_PAGE_NUMBER = 1;

	private static final int MAX_PAGE_NUMBER = 400;

	public static boolean validateNumber(final int pageNumber) {
		return MIN_PAGE_NUMBER < pageNumber
			&& pageNumber < MAX_PAGE_NUMBER;
	}
}
