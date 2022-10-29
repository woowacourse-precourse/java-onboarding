package onboarding.nicknamevalidator;

import java.util.ArrayList;
import java.util.List;

public class NickNameValidator {
	public static List<String> getPermutationOf(final String word) {
		List<String> permutation = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			permutation.addAll(permute(word, i));
		}
		return permutation;
	}

	private static List<String> permute(final String word, int startIndex) {
		List<String> words = new ArrayList<>();
		for (int i = startIndex+1; i < word.length(); i++) {
			words.add(word.substring(startIndex, i+1));
		}
		return words;
	}
}
