package onboarding.problem6;

import java.util.List;
import java.util.Objects;

public class Nickname {
	private final String nickName;

	public Nickname(String nickName) {
		NicknameRangeValidator nicknameRangeValidator = new NicknameRangeValidator();
		if (!nicknameRangeValidator.validateRange(nickName.length())) {
			throw new IllegalArgumentException("닉네임은 20자를 넘을수 없습니다.");
		}

		NicknameKoreanValidator nicknameKoreanValidator = new NicknameKoreanValidator();
		if (!nicknameKoreanValidator.validateAllKorean(nickName)) {
			throw new IllegalArgumentException("넥네임은 한글만 가능합니다.");
		}
		this.nickName = nickName;
	}

	public boolean isRepeat(Nickname otherNickname) {
		return otherNickname.isRepeat(nickName);
	}

	public boolean isRepeat(String otherNickname) {
		NicknameSplitter nicknameSplitter = new NicknameSplitter();
		List<String> splitName = nicknameSplitter.split(otherNickname);
		return splitName.stream()
			.anyMatch(nickName::contains);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Nickname))
			return false;
		Nickname nickname = (Nickname)o;
		return Objects.equals(nickName, nickname.nickName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nickName);
	}

	@Override
	public String toString() {
		return nickName;
	}

}
