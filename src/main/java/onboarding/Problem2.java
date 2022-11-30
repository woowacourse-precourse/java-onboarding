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
        decryption(letterList, START_INDEX);
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

    public static void removeSameLetter(List<String> letterList, int targetIndex, int sameLetterCount) {
        for (int removeIndex = START_INDEX; removeIndex < sameLetterCount; removeIndex++) {
            letterList.remove(targetIndex);
        }
    }

    public static void decryption(List<String> letterList, int targetIndex) {
        while (targetIndex < letterList.size()) {
            targetIndex = checkSameLetter(letterList, targetIndex, false);
            targetIndex++;
        }
    }

    public static int checkSameLetter(List<String> letterList, int targetIndex, boolean isSameLetterExist) {
        for (int letterIndex = START_INDEX; letterIndex < letterList.size(); letterIndex++) {
            int sameLetterCount = countSameLetter(letterList, INIT_SAME_LETTER_COUNT, targetIndex);

            if (isSameLetterExist(sameLetterCount)) {
                removeSameLetter(letterList, targetIndex, sameLetterCount);
                //계속 검사를 진행 하기 위해 변수 초기화
                letterIndex -= INIT_INDEX;
                isSameLetterExist = true;
            }
        }
        return isSameLetterExist ? INIT_INDEX : targetIndex;
    }

    public static boolean isSameLetterExist(int sameLetterCount) {
        if (sameLetterCount != INIT_SAME_LETTER_COUNT) {
            return true;
        }
        return false;
    }

    public static int countSameLetter(List<String> letterList, int sameLetterCount, int targetIndex) {
        int compareIndex = targetIndex + 1;

        while (compareIndex < letterList.size() && isSameLetter(letterList, targetIndex, compareIndex)) {
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
