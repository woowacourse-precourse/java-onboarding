package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        List<Character> seperatedCryptogram = StringToChars(cryptogram);

        return answer;
    }

    protected static List<Character> StringToChars(String text) {
        List<Character> seperatedText = new ArrayList<>();
        final int TEXT_LENGTH = text.length();
        for (int i = 0; i < TEXT_LENGTH; i++) {
            seperatedText.add(text.charAt(i));
        }
        return seperatedText;
    }

    protected static String CharsToString(List<Character> chars) {
        Stream<Character> charStream = chars.stream();
        String text = charStream.map(String::valueOf).collect(Collectors.joining());
        return text;
    }
}
