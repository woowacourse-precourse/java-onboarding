package onboarding.nicknamevalidator;

public class Crew {

	private final String email;

	private final String nickname;

	public Crew(String email, String nickname) {
		this.email = email;
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getNickname() {
		return nickname;
	}

	public boolean isNicknameContains(final String word) {
		return nickname.contains(word);
	}
}
