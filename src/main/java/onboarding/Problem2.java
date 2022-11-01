package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * > 요구사항 </br>
 * 1. 인접한 중복 문자열 삭제(stack을 이용해 매번 순회할 때 마다 중복여부에 따라 추가 /삭제 결정 </br>
 * 2. 알파벳은 소문자로만 이루어져 있음
 */
public class Problem2 {

    public static String solution(String cryptogram) {
        Validator.validateCryptogram(cryptogram);

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < cryptogram.length(); ++i) {
            if (st.empty() || !st.empty() && st.peek() != cryptogram.charAt(i)) {
                st.add(cryptogram.charAt(i));
                continue;
            }
            while (!st.empty() && st.peek() == cryptogram.charAt(i)) {
                st.pop();
            }
        }
        return st.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(""));
    }

    static class Validator {

        private static void validateCryptogram(String cryptogram) {
            validateCryptogramFormat(cryptogram);
            validateCryptogramSize(cryptogram);
        }

        private static void validateCryptogramSize(String cryptogram) {
            if (1 <= cryptogram.length() && cryptogram.length() <= 1000) {
                return;
            }
            throw new RuntimeException("cryptogram은 1이상 1000이하 문자열만 입력가능합니다");
        }

        private static void validateCryptogramFormat(String cryptogram) {
            boolean isAllLowerCase = IntStream.range(0, cryptogram.length())
                .allMatch(i -> {
                    char ch = cryptogram.charAt(i);
                    return Character.isLowerCase(ch);
                });
            if (isAllLowerCase) {
                return;
            }
            throw new RuntimeException("cryptogram은 소문자만 입력 가능합니다");
        }
    }

}
