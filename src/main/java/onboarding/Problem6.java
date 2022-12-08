package onboarding;

import static onboarding.enums.problem6.Index.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
	public static final String REGEX = "";
	public static Set<String> answer;

	public static List<String> solution(List<List<String>> forms) {
		return new ArrayList<>(findAnswer(forms));
	}

	public static Set<String> findAnswer(List<List<String>> forms) {
		answer = new HashSet<>();

		for (int targetIndex = START_INDEX.getIndex(); targetIndex < forms.size() - 1; targetIndex++) {
			List<String> targetForm = chooseTargetNickName(forms, targetIndex);
			compareWithTarget(forms, targetForm, targetIndex);
		}
		return answer;
	}

	public static void compareWithTarget(List<List<String>> forms, List<String> targetForm, int targetIndex) {
		for (int compareIndex = targetIndex + 1; compareIndex < forms.size(); compareIndex++) {
			List<String> compareForm = chooseCompareNickName(forms, compareIndex);
			String[] targetLetters = chooseTargetLetters(targetForm);

			if (isTwoSameLetterExist(compareForm, targetLetters)) {
				addEmailAddress(targetForm, compareForm);
			}
		}
	}

	public static String[] chooseTargetLetters(List<String> targetForm) {
		return targetForm.get(NICKNAME_INDEX.getIndex()).split(REGEX);
	}

	public static List<String> chooseCompareNickName(List<List<String>> forms, int compareIndex) {
		return forms.get(compareIndex);
	}

	public static List<String> chooseTargetNickName(List<List<String>> forms, int targetIndex) {
		return forms.get(targetIndex);
	}

	public static boolean isTwoSameLetterExist(List<String> compareForm, String[] targetLetters) {
		for (int letterIndex = START_INDEX.getIndex(); letterIndex < targetLetters.length - 1; letterIndex++) {
			String targetTwoLetter = chooseTargetTwoLetter(letterIndex, targetLetters);

			if (isSameLetter(compareForm, targetTwoLetter)) {
				return true;
			}
		}
		return false;
	}

	public static void addEmailAddress(List<String> targetForm, List<String> compareForm) {
		answer.add(targetForm.get(EMAIL_INDEX.getIndex()));
		answer.add(compareForm.get(EMAIL_INDEX.getIndex()));
	}

	public static boolean isSameLetter(List<String> compareForm, String targetTwoLetter) {
		return compareForm.get(NICKNAME_INDEX.getIndex()).contains(targetTwoLetter);
	}

	public static String chooseTargetTwoLetter(int letterIndex, String[] targetLetters) {
		return targetLetters[letterIndex] + targetLetters[letterIndex + 1];
	}
}