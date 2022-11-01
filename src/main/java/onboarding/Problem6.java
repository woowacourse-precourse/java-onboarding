package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = List.of("answer");
		answer = getEmailsFromOverlapNicknames(forms);
		return answer;
	}

	public static List<String> getEmailsFromOverlapNicknames(List<List<String>> forms) {
		InputValidator.isRightInput(forms);
		List<String> nicknames = getNicknames(forms);
		Set<String> overLapWords = getOverlapWords(nicknames);
		List<String> emails = getEmailsByCheckingNickname(forms, overLapWords);
		Collections.sort(emails);

		return emails;
	}

	public static List<String> getNicknames(List<List<String>> forms) {
		List<String> nicknames = new ArrayList<>();
		for (List<String> form : forms) {
			String nickname = form.get(1);
			nicknames.add(nickname);
		}
		return nicknames;
	}

	public static List<String> getEmailsByCheckingNickname(List<List<String>> forms, Set<String> words) {
		List<String> result = new ArrayList<>();
		for (String word : words) {
			for (List<String> form : forms) {
				checkNicknameContains(result, word, form);
			}
		}
		return result;
	}

	private static void checkNicknameContains(List<String> result, String word, List<String> form) {
		String email = form.get(0);
		String nickname = form.get(1);
		if (nickname.contains(word)) {
			result.add(email);
		}
	}

	public static Set<String> getOverlapWords(List<String> nicknames) {
		Set<String> words = new HashSet<>();
		Set<String> overlapWords = new HashSet<>();
		for (String nickname : nicknames) {
			Set<String> wordsInNickname = getWordCombinations(nickname);
			findSameWordInWords(wordsInNickname, words, overlapWords);
			words.addAll(wordsInNickname);
		}
		return overlapWords;
	}

	public static Set<String> getWordCombinations(String nickname) {
		Set<String> wordsInNickname = new HashSet<>();
		for (int i = 0; i < nickname.length() - 1; i++) {
			String word = nickname.substring(i, i + 2);
			wordsInNickname.add(word);
		}
		return wordsInNickname;

	}

	public static void findSameWordInWords(Set<String> wordsInNickname, Set<String> words, Set<String> overlapWords) {
		for (String word : wordsInNickname) {
			if (words.contains(word)) {
				overlapWords.add(word);
			}
		}
	}

	static class InputValidator {
		private final static String EMAIL_DOMAIN = "email.com";

		public static void isRightInput(List<List<String>> forms) {
			isRightFormsRange(forms);
			for (List<String> form : forms) {
				isRightForm(form);
			}
		}

		private static void isRightFormsRange(List<List<String>> forms) {
			int formsSize = forms.size();
			if (formsSize < 1 || formsSize > 10000) {
				throw new IllegalArgumentException();
			}
		}

		private static void isRightForm(List<String> form) {
			if (!isRightFormRange(form) || !isRightNicknameAndEmail(form)) {
				throw new IllegalArgumentException();
			}
		}

		private static boolean isRightFormRange(List<String> form) {
			if (form.size() != 2) {
				throw new IllegalArgumentException();
			}
			return true;
		}

		private static boolean isRightNicknameAndEmail(List<String> form) {
			String email = form.get(0);
			String nickname = form.get(1);

			if (!isRightNickname(nickname) || !isRightEmail(email)) {
				throw new IllegalArgumentException();
			}
			return true;
		}

		public static boolean isRightNickname(String nickname) {
			if (!isRightNicknameRange(nickname) || !hasNicknameKorean(nickname)) {
				throw new IllegalArgumentException();
			}
			return true;
		}

		private static boolean isRightNicknameRange(String nickname) {
			int nicknameLength = nickname.length();
			if (nicknameLength < 1 || nicknameLength > 20) {
				throw new IllegalArgumentException();
			}
			return true;
		}

		private static boolean hasNicknameKorean(String nickname) {
			if (nickname.matches("^[가-힣]*$")) {
				return true;
			}
			throw new IllegalArgumentException();
		}

		public static boolean isRightEmail(String email) {
			if (!isRightEmailRange(email) || !isRightEmailFormat(email)) {
				throw new IllegalArgumentException();
			}
			return true;
		}

		private static boolean isRightEmailRange(String email) {
			if (email.length() < 11 || email.length() > 20) {
				throw new IllegalArgumentException();
			}
			return true;
		}

		private static boolean isRightEmailFormat(String email) {
			if (email.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@" + EMAIL_DOMAIN)) {
				return true;
			}
			throw new IllegalArgumentException();
		}
	}
}
