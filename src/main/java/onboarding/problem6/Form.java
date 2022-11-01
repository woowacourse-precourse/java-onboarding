package onboarding.problem6;

import java.util.List;

public class Form {

	private final Email email;
	private final NickName nickName;

	public Form(List<String> inputForm) {
		validateInputForm(inputForm);
		this.email = new Email(inputForm.get(0));
		this.nickName = new NickName(inputForm.get(1));
	}

	void validateInputForm(List<String> inputForm) {
		if (inputForm.size() != 2) {
			throw new IllegalArgumentException("입력 양식이 잘못 되었습니다.");
		}
	}

	public String getEmail() {
		return email.toString();
	}

	public String getNickName() {
		return nickName.getNickName();
	}
}
