package onboarding.friendrecommendationsystem;

public class Nickname {

	private static final int MIN_LENGTH = 1;
	private static final int MAX_LENGTH = 19;

	private final String nickname;

	public Nickname(final String nickname) {
		validateNickname(nickname);
		this.nickname = nickname;
	}

	public void validateNickname(final String nickname) {
		if (isOutOfBound(nickname)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isOutOfBound(final String nickname) {
		int length = nickname.length();
		return MIN_LENGTH > length || length > MAX_LENGTH;
	}
}
