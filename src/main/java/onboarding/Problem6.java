package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class Problem6 {

	public static final int DUPLICATE_STANDARD = 2;
	public static final int MIN_CREW_SIZE = 1;
	public static final int MAX_CREW_SIZE = 10_000;
	public static final int MIN_EMAIL_SIZE = 11;
	public static final int MAX_EMAIL_SIZE = 20;
	public static final int MIN_NICKNAME_SIZE = 1;
	public static final int MAX_NICKNAME_SIZE = 20;
	public static final String KOREAN = "^[가-힣]*$";
	public static final String TOO_MANY_CREW = "크루의 수가 너무 많습니다.";
	public static final String TOO_LONG_OR_SHORT_EMAIL = "이메일이 너무 길거나 짧습니다.";
	public static final String TOO_LONG_OR_SHORT_NICKNAME = "닉네임이 너무 길거나 짧습니다.";
	public static final String NICKNAME_CAN_ONLY_KOREAN = "닉네임에는 한글만 들어갈 수 있습니다.";

	public static List<String> solution(List<List<String>> forms) {
		validateForms(forms);

		Map<String, Integer> dictionary = makeDictionary(forms);
		List<String> emailOfDuplicateNickname = findEmailOfDuplicateNickname(forms, dictionary);

		return sortAndDistinctEmail(emailOfDuplicateNickname);
	}

	private static void validateForms(List<List<String>> forms) {
		validateParameter(forms);
	}

	private static void validateParameter(List<List<String>> forms) {
		if (isRightSizeOfCrew(forms)) {
			throw new IllegalArgumentException(TOO_MANY_CREW);
		}

		for (List<String> form : forms) {
			validateForm(form);
		}
	}

	private static void validateForm(List<String> form) {
		String email = form.get(0);
		if (isRightLengthOfEmail(email)) {
			throw new IllegalArgumentException(TOO_LONG_OR_SHORT_EMAIL);
		}

		String nickname = form.get(1);
		if (isRightLengthOfNickname(nickname)) {
			throw new IllegalArgumentException(TOO_LONG_OR_SHORT_NICKNAME);
		}

		if (isKorean(nickname)) {
			throw new IllegalArgumentException(NICKNAME_CAN_ONLY_KOREAN);
		}
	}

	private static boolean isRightSizeOfCrew(List<List<String>> forms) {
		return forms.size() < MIN_CREW_SIZE || forms.size() > MAX_CREW_SIZE;
	}

	private static boolean isRightLengthOfEmail(String email) {
		return email.length() < MIN_EMAIL_SIZE || email.length() >= MAX_EMAIL_SIZE;
	}

	private static boolean isRightLengthOfNickname(String nickname) {
		return nickname.length() < MIN_NICKNAME_SIZE || nickname.length() > MAX_NICKNAME_SIZE;
	}

	private static boolean isKorean(String nickname) {
		return !Pattern.matches(KOREAN, nickname);
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
