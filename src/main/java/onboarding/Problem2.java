package onboarding;

import static onboarding.enums.problem2.Init.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem2 {
	private static final int START_INDEX = 0;
	private static final String REGEX = "";
	private static List<String> letterList;
	private static StringBuilder answer;

	public static String solution(String cryptogram) {
		init();
		separateLetters(cryptogram);
		decryptPassword();

		return listToString();
	}

	public static void init() {
		letterList = new ArrayList<>();
		answer = new StringBuilder();
	}

	public static String listToString() {
		for (String alphabet : letterList) {
			answer.append(alphabet);
		}
		return answer.toString();
	}

	public static void removeSameLetter(int targetIndex, int sameLetterCount) {
		for (int removeIndex = START_INDEX; removeIndex < sameLetterCount; removeIndex++) {
			letterList.remove(targetIndex);
		}
	}

	public static void decryptPassword() {
		for (int targetIndex = START_INDEX; targetIndex < letterList.size(); targetIndex++) {
			int sameLetterCount = countSameLetter(INIT_SAME_LETTER_COUNT.getInitialValueNumber(), targetIndex);

			if (isSameLetterExist(sameLetterCount)) {
				removeSameLetter(targetIndex, sameLetterCount);
				targetIndex = INIT_INDEX.getInitialValueNumber();
			}
		}
	}

	public static boolean isSameLetterExist(int sameLetterCount) {
		if (sameLetterCount > INIT_SAME_LETTER_COUNT.getInitialValueNumber()) {
			return true;
		}
		return false;
	}

	public static int countSameLetter(int sameLetterCount, int targetIndex) {
		int compareIndex = targetIndex + 1;

		while (isCorrectRange(compareIndex) && isSameLetter(targetIndex, compareIndex)) {
			sameLetterCount++;
			compareIndex++;
		}
		return sameLetterCount;
	}

	private static boolean isCorrectRange(int compareIndex) {
		return compareIndex < letterList.size();
	}

	public static boolean isSameLetter(int index, int compareIndex) {
		if (letterList.get(index).equals(letterList.get(compareIndex))) {
			return true;
		}
		return false;
	}

	public static void separateLetters(String cryptogram) {
		String[] alphabets = cryptogram.split(REGEX);

		for (String alphabet : alphabets) {
			letterList.add(alphabet);
		}
	}


}
