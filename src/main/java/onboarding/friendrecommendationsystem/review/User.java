package onboarding.friendrecommendationsystem.review;

public class User {

	private static final int MIN_ID_LENGTH = 1;

	private static final int MAX_ID_LENGTH = 10_000;

	private final String id;

	public User(final String id) {
		validateId(id);
		this.id = id;
	}

	private void validateId(final String id) {
		if (isOutOfBound(id)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isOutOfBound(final String id) {
		int length = id.length();
		return MIN_ID_LENGTH > length || length > MAX_ID_LENGTH;
	}
}
