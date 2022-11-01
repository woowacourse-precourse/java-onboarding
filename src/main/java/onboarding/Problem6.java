package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import onboarding.problem6.Crew;
import onboarding.problem6.NicknameFilter;

public class Problem6 {

	public static List<String> solution(List<List<String>> forms) {
		Set<Crew> crewSet = new HashSet<>();
		Set<String> emailSet = new HashSet<>();

		for (List<String> form : forms) {
			validateForm(form);
			String email = form.get(0);
			String nickname = form.get(1);

			if (emailSet.contains(email)) {
				throw new RuntimeException("중복된 이메일은 사용할 수 없습니다.");
			} else {
				emailSet.add(email);
			}

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
