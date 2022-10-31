package onboarding.problem6;

public class Request {

	private final Email email;
	private final Nickname nickname;

	public Request(String email, String nickname) {
		this.email = new Email(email);
		this.nickname = new Nickname(nickname);
	}

	public boolean hasOverlapOf(Request other) {
		return nickname.hasOverlapOf(other.nickname);
	}

	public String getEmail() {
		return email.getEmail();
	}
}
