package onboarding.problem6;

import java.util.List;
import java.util.Objects;

public class Member {
	private final Nickname nickname;
	private final Email email;

	public Member(List<String> list) {
		this(list.get(0), list.get(1));
	}

	public Member(String nickname, String email) {
		this.nickname = new Nickname(nickname);
		this.email = new Email(email);
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
