package onboarding.problem6;

public class Crew {

	private final String email;
	private final String nickname;

	public Crew(String email, String nickname) {
		this.email = validateEmail(email);
		this.nickname = validateNickname(nickname);
	}

	private String validateEmail(String email) {
		if (!email.matches(".*(@email.com)$")) {
			throw new RuntimeException("Email 형식이 올바르지 않습니다.");
		} else if (email.length() < 11 || email.length() >= 20) {
			throw new RuntimeException("Email 은 11자 이상 20자 미만의 길이만 사용 가능합니다.");
		}
		return email;
	}

	private String validateNickname(String nickname) {
		if (!nickname.matches("^([ㄱ-ㅎㅏ-ㅣ가-힣]).*")) {
			throw new RuntimeException("Nickname 형식이 올바르지 않습니다.");
		} else if (nickname.length() < 1 || nickname.length() >= 20) {
			throw new RuntimeException("Nickname 은 1자 이상 20자 미만의 길이만 사용 가능합니다.");
		}
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getNickname() {
		return nickname;
	}
}
