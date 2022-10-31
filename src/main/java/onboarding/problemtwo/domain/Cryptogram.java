package onboarding.problemtwo.domain;

public class Cryptogram {

	private String text;

	public Cryptogram(String text) {
		this.text = text;
	}

	public String decode() {

		boolean isNotEnd = true;

		while (isNotEnd) {
			isNotEnd = deleteDuplicate();
		}

		return text;
	}

	private boolean deleteDuplicate() {

		String tmp = "";
		boolean flag = false;

		for (int i = 0; i < text.length(); i++) {
			if (i < text.length() - 1 && text.charAt(i) == text.charAt(i + 1)) {
				flag = true;
				i += 1;
			} else {
				tmp += text.charAt(i);
			}
		}
		text = tmp;
		return flag;
	}
}
