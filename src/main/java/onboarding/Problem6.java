package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		return sortResult(returnResult(forms));
	}

	private static List<String> sortResult(List<String> result) {
		result.sort(Comparator.naturalOrder());
		return result;
	}

	private static List<String> returnResult(List<List<String>> forms) {
		HashSet<String> result = new HashSet<>();
		forms.stream()
			.filter(emailAndNickname -> checkSimilarityInCrewList(emailAndNickname.get(1), forms))
			.forEach(emailAndNickname -> result.add(emailAndNickname.get(0)));

		return new ArrayList<>(result);
	}

	private static boolean checkSimilarityInCrewList(String nickname, List<List<String>> forms) {
		return forms.stream()
			.filter(emailAndNickname -> !nickname.equals(emailAndNickname.get(1)))
			.anyMatch(emailAndNickname -> checkSimilarity(nickname, emailAndNickname.get(1)));
	}

	private static boolean checkSimilarity(String nickname, String target) {
		for (int i = 0; i < nickname.length() - 1; i++) {
			if (target.contains(returnTwoLettersFromIndex(nickname, i))) {
				return true;
			}
		}
		return false;
	}

	private static String returnTwoLettersFromIndex(String nickname, int index) {
		return nickname.substring(index, index + 2);
	}
}
