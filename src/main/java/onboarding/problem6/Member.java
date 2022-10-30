package onboarding.problem6;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Member {
	private final Nickname nickname;
	private final Email email;

	public Member(List<String> list) {
		this(list.get(0), list.get(1));
	}

	public Member(String email, String nickname) {
		this.nickname = new Nickname(nickname);
		this.email = new Email(email);
	}

	public boolean isRepeat(Set<String> repetitionList) {
		return repetitionList.stream()
			.anyMatch(nickname::isRepeat);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Member))
			return false;
		Member member = (Member)o;
		return Objects.equals(nickname, member.nickname) && Objects.equals(email, member.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nickname, email);
	}

}
