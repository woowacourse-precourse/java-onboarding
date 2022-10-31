package onboarding.problem6;

import java.util.List;

public class Request {

	private static final int TWO = 2;

	private final Email email;
	private final Nickname nickname;

	public Request(List<String> form) {
		validateFormLength(form);
		this.email = new Email(form.get(0));
		this.nickname = new Nickname(form.get(1));
	}

	public boolean hasOverlapWith(Request other) {
		return nickname.hasOverlapWith(other.nickname);
	}

	public String getEmail() {
		return email.getEmail();
	}

	private void validateFormLength(List<String> form) {
		if (form.size() != TWO) {
			throw new IllegalArgumentException("신청은 닉네임과 이메일을 포함해야 합니다");
		}
	}
}
