package onboarding;

import java.util.List;

import onboarding.problemsix.domain.Woowacourse;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {

		Woowacourse woowacourse= new Woowacourse();
		woowacourse.saveForms(forms);

		List<String> answer = woowacourse.getEmailList();
		return answer;
	}
}
