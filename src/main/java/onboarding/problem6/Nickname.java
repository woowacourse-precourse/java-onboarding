package onboarding.problem6;

public class Nickname {

	private final String nickname;

	public Nickname(String nickname) {
		validateNotNull(nickname);
		validateLength(nickname);
		this.nickname = nickname;
	}

	public boolean hasOverlapWith(Nickname other) {
		for (int i = 0; i < other.nickname.length() - 1; i++) {
			String twoCharacters = other.nickname.substring(i, i + 2);
			if (nickname.contains(twoCharacters)) {
				return true;
			}
		}
		return false;
	}

	private void validateNotNull(String nickname) {
		if (nickname == null) {
			throw new IllegalArgumentException("닉네임은 null일 수 없습니다");
		}
	}

	private void validateLength(String nickname) {
		if (nickname.length() < 1) {
			throw new IllegalArgumentException("이름은 1자 이상입니다");
		}
		if (nickname.length() >= 20) {
			throw new IllegalArgumentException("이름은 20자 미만입니다");
		}
	}
}
