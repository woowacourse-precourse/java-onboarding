package onboarding.problem7;

import java.util.Objects;

public class UserID {

	private final String userID;

	public UserID(String userID) {
		UserIDSizeValidator userIDSizeValidator = new UserIDSizeValidator();
		if (!userIDSizeValidator.validate(userID.length())) {
			throw new IllegalArgumentException("사용자 아이디는 길이가 1 이상 30 이하인 문자열이다.");
		}
		UserIDTypeValidator userIDTypeValidator = new UserIDTypeValidator();
		if (!userIDTypeValidator.validate(userID)) {
			throw new IllegalArgumentException("사용자 아이디는 알파벳 소문자로만 이루어져야 있다.");
		}
		this.userID = userID;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof UserID))
			return false;
		UserID userID1 = (UserID)o;
		return Objects.equals(userID, userID1.userID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userID);
	}

	@Override
	public String toString() {
		return userID;
	}
}
