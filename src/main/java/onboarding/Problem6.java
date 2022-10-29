package onboarding;

import java.util.List;

import onboarding.problemsix.domain.Woowacourse;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {

		Woowacourse woowacourse= new Woowacourse();

		List<String> answer = woowacourse.getEmailList(forms);
		return answer;
	}
}
