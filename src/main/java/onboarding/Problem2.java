package onboarding;

import static onboarding.enums.problem2.Init.*;

import java.util.LinkedList;
import java.util.List;

public class Problem2 {
    public static final int START_INDEX = 0;
    public static List<String> letterList;
    public static StringBuilder answer;

    public static String solution(String cryptogram) {
        init();
        separateLetters(cryptogram);
        decryption(START_INDEX);

        return listToString();
    }

    private static void init() {
        letterList = new LinkedList<>();
        answer = new StringBuilder();
    }

    public static String listToString() {
        for (String alphabet : letterList) {
            answer.append(alphabet);
        }
        return answer.toString();
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

    public static void decryption(int targetIndex) {
        while (targetIndex < letterList.size()) {
            targetIndex = checkSameLetter(letterList, targetIndex, false);
            targetIndex++;
        }
    }

    public static int checkSameLetter(List<String> letterList, int targetIndex, boolean isSameLetterExist) {
        for (int letterIndex = START_INDEX; letterIndex < letterList.size(); letterIndex++) {
            int sameLetterCount = countSameLetter(letterList, INIT_SAME_LETTER_COUNT.getInitialValueNumber(), targetIndex);

            if (isSameLetterExist(sameLetterCount)) {
                removeSameLetter(letterList, targetIndex, sameLetterCount);
                //계속 검사를 진행 하기 위해 변수 초기화
                letterIndex -= INIT_INDEX.getInitialValueNumber();
                isSameLetterExist = true;
            }
        }
        return isSameLetterExist ? INIT_INDEX.getInitialValueNumber() : targetIndex;
    }

    public static boolean isSameLetterExist(int sameLetterCount) {
        if (sameLetterCount != INIT_SAME_LETTER_COUNT.getInitialValueNumber()) {
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

    public static void separateLetters(String cryptogram) {
        String[] alphabets = cryptogram.split("");

        for(String alphabet : alphabets){
            letterList.add(alphabet);
        }
    }
}
