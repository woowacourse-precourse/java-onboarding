package onboarding;

import java.util.ArrayList;
import java.util.List;

import onboarding.problem6.Requests;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		Requests requests = new Requests(forms);
		return new ArrayList<>(requests.getEmailsOfOverlappedCrews());
	}
}
