package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
	static final int EMAIL = 0;
	static final int NICKNAME = 1;

	public static List<String> solution(List<List<String>> forms) {
		return getEmailsWithSimilarNicknames(forms);
	}

	private static List<String> getEmailsWithSimilarNicknames(List<List<String>> forms) {
		return forms.stream()
			.filter(emailAndNickname -> checkSimilarityInNicknames(emailAndNickname.get(NICKNAME), forms))
			.map(emailAndNickname -> emailAndNickname.get(EMAIL))
			.distinct()
			.sorted()
			.collect(Collectors.toList());
	}

	private static boolean checkSimilarityInNicknames(String nickname, List<List<String>> forms) {
		return forms.stream()
			.filter(emailAndNickname -> !nickname.equals(emailAndNickname.get(NICKNAME)))
			.anyMatch(emailAndNickname -> checkSimilarity(nickname, emailAndNickname.get(NICKNAME)));
	}

	private static boolean checkSimilarity(String nickname1, String nickname2) {
		for (int index = 0; index < nickname1.length() - 1; index++) {
			if (nickname2.contains(returnTwoLettersFromIndex(nickname1, index))) {
				return true;
			}
		}
		return false;
	}

	private static String returnTwoLettersFromIndex(String nickname, int index) {
		return nickname.substring(index, index + 2);
	}
}
