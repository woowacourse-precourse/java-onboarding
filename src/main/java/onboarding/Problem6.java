package onboarding;

import java.util.List;

import onboarding.problem6.Member;
import onboarding.problem6.MemberList;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		MemberList memberList = new MemberList();
		for (List<String> form : forms) {
			memberList.add(new Member(form));
		}
		return memberList.findRepeatMember();
	}
}
