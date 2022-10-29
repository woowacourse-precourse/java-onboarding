package onboarding.nicknamevalidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NickNameValidator {

	private final Map<String, Integer> occurrences;

	public NickNameValidator(List<List<String>> forms) {
		occurrences = new HashMap<>();
		for (List<String> form : forms) {
			initMapWith(form);
		}
	}

	private void initMapWith(final List<String> form) {
		for (String word : getPermutationOf(form.get(1))) {
			occurrences.merge(word, 1,
				(occurrences, ignored) -> occurrences+1);
		}
	}

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

	public int getOccurrenceOf(final String word) {
		return occurrences.getOrDefault(word, 0);
	}
}
