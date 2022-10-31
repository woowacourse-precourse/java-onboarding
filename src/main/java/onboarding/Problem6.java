package onboarding;

import java.util.List;

import onboarding.problem6.NicknameFilter;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		NicknameFilter nicknameFilter = new NicknameFilter();
		return nicknameFilter.filter(forms);
	}
}
