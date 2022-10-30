package onboarding.problem6;

import java.util.List;
import java.util.Objects;

public class Member {
	private final Nickname nickname;
	private final Email email;

	public String getEmail() {
		return email.toString();
	}

	public Member(List<String> list) {
		this(list.get(0), list.get(1));
	}

	public Member(String email, String nickname) {
		this.nickname = new Nickname(nickname);
		this.email = new Email(email);
	}

	public boolean isRepeat(List<Member> memberList) {
		return memberList.stream()
			.anyMatch(member -> member != this && member.isRepeat(nickname));
	}

	public boolean isRepeat(Nickname otherNickname) {
		return nickname.isRepeat(otherNickname);
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
