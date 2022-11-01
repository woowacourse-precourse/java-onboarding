package onboarding;

import java.util.stream.IntStream;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, word.length())
            .forEach(i -> {

                if (isLowerAlphabet(word, i)) {
                    stringBuilder.append((char) (219 - word.charAt(i)));
                    return;
                }

                if (isUpperAlphabet(word, i)) {
                    stringBuilder.append((char) (155 - word.charAt(i)));
                    return;
                }

                stringBuilder.append(word.charAt(i));
            });

        return stringBuilder.toString();
    }

    private static boolean isUpperAlphabet(String word, int i) {
        return word.charAt(i) >= 'A' && word.charAt(i) <= 'Z';
    }

    private static boolean isLowerAlphabet(String word, int i) {
        return word.charAt(i) >= 'a' && word.charAt(i) <= 'z';
    }
}
