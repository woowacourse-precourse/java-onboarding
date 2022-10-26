package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!validateCryptogram(cryptogram)) {
            return cryptogram;
        }

        return removeDuplicateString(cryptogram);
    }

    /**
     * 올바른 암호문이 입력되었는지 검증합니다.
     * @param cryptogram 암호문
     * @return 올바른 암호문이라면 TRUE 반환
     */
    private static boolean validateCryptogram(String cryptogram) {
        int lengthCryptogram = cryptogram.length();

        // 문자열 길이가 1 이상 ~ 1000 이하인지 확인
        if (lengthCryptogram < 1 || lengthCryptogram > 1000) {
            return false;
        }

        // 문자열이 알파벳 소문자인지 확인
        if (!Pattern.matches("^[a-z]*$", cryptogram)) {
            return false;
        }

        return true;
    }

    /**
     * 중복 문자를 제거합니다.
     * @param cryptogram 암호문
     * @return 제거된 문자열
     */
    private static String removeDuplicateString(String cryptogram) {
        ArrayList<String> splitCryptogram = splitCryptogram(cryptogram);
        int sizeSplitCryptogram = splitCryptogram.size();

        // 문자열 순차 읽기
        for (int i = 0; i < sizeSplitCryptogram; i++) {
            // 지난 문자와 현재 문자가 같은지 확인하기.
            if (i > 0 && Objects.equals(splitCryptogram.get(i - 1), splitCryptogram.get(i))) {
                //중복 문자 제거
                for (int j = 0; j < 2; j++) {
                    splitCryptogram.remove(i);
                    sizeSplitCryptogram --;
                    i --;
                }
            }
        }

        return String.join("",splitCryptogram);
    }

    /**
     * 암호문을 분할합니다.
     * @param cryptogram 암호문
     * @return 분할된 암호문
     */
    private static ArrayList<String> splitCryptogram(String cryptogram) {
        ArrayList<String> arrayListSplitCryptogram = new ArrayList<>();
        Collections.addAll(arrayListSplitCryptogram, cryptogram.split(""));

        return arrayListSplitCryptogram;
    }
}
