package onboarding.problem2;

public class CipherText {

	private String value;

	public String getValue() {
		return this.value;
	}

	public void changeValue(String value){
		this.value = value;
	}

	private CipherText(String value) {
		this.value = value;
	}


	public static PasswordBuilder builder() {
		return new PasswordBuilder();
	}

	public static class PasswordBuilder {
		private String value;

		PasswordBuilder() {
		}

		public PasswordBuilder value(String value) {
			this.value = value;
			return this;
		}

		public CipherText build() {
			return new CipherText(this.value);
		}

	}
}
