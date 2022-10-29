package onboarding.nicknamevalidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NickNameValidator {

	private final List<List<String>> forms;

	private final Map<String, Integer> occurrences;

	public NickNameValidator(List<List<String>> forms) {
		this.forms = forms;
		this.occurrences = new HashMap<>();
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

	public List<String> getEmailsMatches(final String word) {
		List<String> emails = new ArrayList<>();

		for (List<String> form : forms) {
			String nickname = form.get(1);
			if (nickname.contains(word)) {
				emails.add(form.get(0));
			}
		}
		return emails;
	}

	public List<String> getInvalidEmails() {
		return occurrences.keySet()
			.stream()
			.filter(word -> getOccurrenceOf(word) >= 2)
			.map(this::getEmailsMatches)
			.flatMap(Collection::stream)
			.distinct()
			.sorted()
			.collect(Collectors.toList());
	}
}
