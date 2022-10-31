package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Problem6 {

	public static final int DUPLICATE_STANDARD = 2;

	public static List<String> solution(List<List<String>> forms) {
		Map<String, Integer> dictionary = makeDictionary(forms);
		List<String> emailOfDuplicateNickname = findEmailOfDuplicateNickname(forms, dictionary);

		return sortAndDistinctEmail(emailOfDuplicateNickname);
	}

	private static List<String> sortAndDistinctEmail(List<String> emailOfDuplicateNickname) {
		return emailOfDuplicateNickname.stream()
				.distinct()
				.sorted()
				.collect(toList());
	}

	private static Map<String, Integer> makeDictionary(List<List<String>> forms) {
		Map<String, Integer> dictionary = new HashMap<>();

		for (List<String> form : forms) {
			String nickname = form.get(1);
			addDictionary(dictionary, nickname);
		}

		return dictionary;
	}

	private static void addDictionary(Map<String, Integer> dictionary, String nickname) {
		for (int i = 0; i < nickname.length() - 1; i++) {
			String neighborWord = findNeighborWord(nickname, i);
			dictionary.merge(neighborWord, 1, Integer::sum);
		}
	}

	private static String findNeighborWord(String nickname, int i) {
		return nickname.substring(i, i + DUPLICATE_STANDARD);
	}

	private static List<String> findEmailOfDuplicateNickname(List<List<String>> forms, Map<String, Integer> dictionary) {
		List<String> emailOfDuplicateNickname = new ArrayList<>();
		for (List<String> form : forms) {
			String email = form.get(0);
			String nickname = form.get(1);

			deleteWord(dictionary, nickname);
			findDuplicateNickname(dictionary, emailOfDuplicateNickname, email, nickname);
			addWord(dictionary, nickname);
		}

		return emailOfDuplicateNickname;
	}

	private static void deleteWord(Map<String, Integer> dictionary, String nickname) {
		for (int i = 0; i < nickname.length() - 1; i++) {
			String neighborWord = findNeighborWord(nickname, i);
			int decreaseCount = dictionary.get(neighborWord) - 1;
			dictionary.put(neighborWord, decreaseCount);
		}
	}

	private static void findDuplicateNickname(Map<String, Integer> dictionary, List<String> emailOfDuplicateNickname, String email, String nickname) {
		for (int i = 0; i < nickname.length() - 1; i++) {
			String neighborWord = findNeighborWord(nickname, i);
			addEmailOfDuplicateNickname(dictionary, emailOfDuplicateNickname, email, neighborWord);
		}
	}

	private static void addEmailOfDuplicateNickname(Map<String, Integer> dictionary, List<String> emailOfDuplicateNickname, String email, String word) {
		if (isInDictionary(dictionary, word)) {
			emailOfDuplicateNickname.add(email);
		}
	}

	private static boolean isInDictionary(Map<String, Integer> dictionary, String word) {
		return dictionary.containsKey(word) && dictionary.get(word) != 0;
	}

	private static void addWord(Map<String, Integer> dictionary, String nickname) {
		for (int i = 0; i < nickname.length() - 1; i++) {
			String neighborWord = findNeighborWord(nickname, i);
			int increaseCount = dictionary.get(neighborWord) + 1;
			dictionary.put(neighborWord, increaseCount);
		}
	}
}
