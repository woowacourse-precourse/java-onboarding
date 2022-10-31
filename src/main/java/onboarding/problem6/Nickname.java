package onboarding.problem6;

public class Nickname {

	private final String nickname;

	public Nickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean hasOverlapOf(Nickname other) {
		for (int i = 0; i < other.nickname.length() - 1; i++) {
			String substring = other.nickname.substring(i, i + 2);
			if (nickname.contains(substring)) {
				return true;
			}
		}
		return false;
	}
}
