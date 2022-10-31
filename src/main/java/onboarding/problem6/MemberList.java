package onboarding.problem6;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

public class MemberList {
	private final List<Member> memberList = new ArrayList<>();
	public static final int MAX_SIZE = 100_000;

	public boolean isFull(int length) {
		return length == MAX_SIZE;
	}

	public void add(Member member) {
		memberList.add(member);
	}

	public boolean containsMember(Member member) {
		return memberList.contains(member);
	}

	public List<String> findRepeatMember() {
		return memberList.stream()
			.filter(member -> member.isRepeat(memberList))
			.map(Member::getEmail)
			.sorted(String::compareTo)
			.collect(toList());
	}
}
