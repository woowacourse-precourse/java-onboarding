package onboarding.friendrecommendationsystem;

public class Nickname {

	private static final int MIN_LENGTH = 1;

	private static final int MAX_LENGTH = 19;

	private static final String REGEX_MATCH_KOREAN = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*";

	private final String nickname;

	public Nickname(final String nickname) {
		validateNickname(nickname);
		this.nickname = nickname;
	}

	public void validateNickname(final String nickname) {
		if (isOutOfBound(nickname) || !isAllKoreanLetters(nickname)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isAllKoreanLetters(final String nickname) {
	return nickname.matches(REGEX_MATCH_KOREAN);
	}

	private boolean isOutOfBound(final String nickname) {
		int length = nickname.length();
		return MIN_LENGTH > length || length > MAX_LENGTH;
	}
}
