package onboarding;

import java.util.stream.IntStream;

public class Problem2 {

    public static String solution(String cryptogram) {
        validate(cryptogram);
        return "";
    }

    private static void validate(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new IllegalArgumentException("길이가 1 이상 1000 이하인 문자열이어야 합니다.");
        }
        for (char character : cryptogram.toCharArray()) {
            if (!(Character.isLowerCase(character) && Character.isAlphabetic(character))) {
                throw new IllegalArgumentException("알파벳 소문자로만 이루어져 있어야 합니다.");
            }
        }
    }
}
