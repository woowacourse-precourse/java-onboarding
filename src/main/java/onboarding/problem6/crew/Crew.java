package onboarding.problem6.crew;

import java.util.Set;

import onboarding.problem6.twoletterword.InNickName;

public class Crew {
	private String email;
	private String nickname;

	private Set<InNickName> twoSizeWordSet;

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

}
