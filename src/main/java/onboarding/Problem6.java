package onboarding;

import java.util.List;

import onboarding.problem6.Verifier;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		return Verifier.extractDuplicateCrews(forms);
	}
}
