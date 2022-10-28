package onboarding;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2 {
    public static final String ALPHABET_DELIMITER = "abcdefghijklmnopqrstuvwxyz";
    public static final int START_INDEX = 0;
    public static final int INIT_SAME_LETTER_COUNT = 1;
    public static final int INIT_INDEX = -1;
    public static final String INIT_STRING ="";

    public static String solution(String cryptogram) {
        List<String> letterList = new LinkedList<>();

        separateLetters(letterList, cryptogram);
        decryption(letterList);
        String answer = listToString(letterList);

        return answer;
    }

    public static String listToString(List<String> list) {
        String answer = INIT_STRING;
        for (String alphabet : list) {
            answer += alphabet;
        }
        return answer;
    }

    public static boolean isSameLetter(List<String> letterList, int index, int compareIndex) {
        if (letterList.get(index).equals(letterList.get(compareIndex))) {
            return true;
        }
        return false;
    }

    public static void removeSameLetter(List<String> letterList, int index, int sameLetterCount) {
        for (int removeIndex = START_INDEX; removeIndex < sameLetterCount; removeIndex++) {
            letterList.remove(index);
        }
    }

    public static void decryption(List<String> letterList) {
        for (int index = START_INDEX; index < letterList.size() - 1; index++) {
            int sameLetterCount = countSameLetter(letterList, INIT_SAME_LETTER_COUNT, index);

            if (sameLetterCount != INIT_SAME_LETTER_COUNT) {
                removeSameLetter(letterList, index, sameLetterCount);
                index = INIT_INDEX;
            }
        }
    }

    public static int countSameLetter(List<String> letterList, int sameLetterCount, int index) {
        int compareIndex = index + 1;

        while (compareIndex < letterList.size() && isSameLetter(letterList, index, compareIndex)) {
            sameLetterCount++;
            compareIndex++;
        }
        return sameLetterCount;
    }

    public static void separateLetters(List<String> letterList, String cryptogram) {
        StringTokenizer st = new StringTokenizer(cryptogram, ALPHABET_DELIMITER, true);
        addLettersInList(letterList, st);
    }

    public static void addLettersInList(List<String> letterList, StringTokenizer st) {
        while (st.hasMoreTokens()) {
            letterList.add(st.nextToken());
        }
    }
}
