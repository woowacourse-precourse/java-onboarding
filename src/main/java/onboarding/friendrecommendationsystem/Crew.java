package onboarding.friendrecommendationsystem;

import java.util.Set;

public class Crew {

	private static final int REPEATED_LENGTH = 2;

	private final Nickname nickname;

	private final Email email;

	public Crew(final String nickname,
		final String email) {

		this.nickname = new Nickname(nickname);
		this.email = new Email(email);
	}

	public String getNickname() {
		return nickname.getNickname();
	}

	public String getEmail() {
		return email.getEmail();
	}

	public Set<String> getPartsOfName() {
		return nickname.getPartsOfName(REPEATED_LENGTH);
	}
}
