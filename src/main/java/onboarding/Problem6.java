package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import onboarding.problem6.Crew;
import onboarding.problem6.NicknameFilter;

public class Problem6 {

	public static List<String> solution(List<List<String>> forms) {
		Set<Crew> crewSet = new HashSet<>();

		for (List<String> form : forms) {
			validateForm(form);
			String email = form.get(0);
			String nickname = form.get(1);
			Crew crew = new Crew(email, nickname);
			crewSet.add(crew);
		}
		NicknameFilter nicknameFilter = new NicknameFilter();
		return nicknameFilter.filter(crewSet);
	}

	static void validateForm(List<String> form) {
		if (form.size() != 2) {
			throw new RuntimeException("입력 폼이 옳지 않습니다.");
		}
	}
}
