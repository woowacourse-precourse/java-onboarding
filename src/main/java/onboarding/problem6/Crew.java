package onboarding.problem6;

public class Crew {
	private String email;
	private String nickname;
	private boolean isDuplicated = false;

	public Crew(String email, String nickname) {
		this.email = email;
		this.nickname = nickname;
	}

	public void setDuplicated() {
		isDuplicated = true;
	}

	public String getEmail() {
		return email;
	}

	public String getNickname() {
		return nickname;
	}

	public boolean isDuplicated() {
		return isDuplicated;
	}
}
