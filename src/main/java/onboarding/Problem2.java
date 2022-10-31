package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        checkCorrectCryptogram(cryptogram);

        return removeDuplicateString(cryptogram);
    }

    /**
     * 암호가 올바른지 검증
     * @param cryptogram 암호
     * @throws RuntimeException 오류 메세지를 반환
     */
    private static void checkCorrectCryptogram(String cryptogram) {
        int lengthCryptogram = cryptogram.length();

        if (lengthCryptogram == 0 || lengthCryptogram > 1000) {
            throw new RuntimeException("암호문은 1 ~ 1000 글자여야 합니다.");
        }

        if (!Pattern.matches("^[a-z]*$", cryptogram)) {
            throw new RuntimeException("암호문은 알파벳 소문자로만 구성되어야 합니다.");
        }
    }

    /**
     * 중복 문자를 제거합니다.
     * @param cryptogram 암호문
     * @return 제거된 문자열
     */
    private static String removeDuplicateString(String cryptogram) {
        List<String> splitCryptogram = getOneLetterCryptograms(cryptogram);
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
     * 암호를 한글자씩 분할하기
     * @param cryptogram 암호
     * @return 한글자씩 분할된 암호
     */
    private static List<String> getOneLetterCryptograms(String cryptogram) {
        List<String> oneLetterCryptogram = new LinkedList<>();
        Collections.addAll(oneLetterCryptogram, cryptogram.split(""));

        return oneLetterCryptogram;
    }

}
