package onboarding.problem4;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Translator {
    private final Map<Character, Character> dict = new HashMap<>();

    public Translator(String from, String to) {
        IntStream.rangeClosed(0, from.length() - 1)
                .forEach(idx -> dict.put(from.charAt(idx), to.charAt(idx)));
    }

    public String translate(String word) {
        return word.codePoints()
                .mapToObj(ch -> (char) ch)
                .map(ch -> dict.getOrDefault(ch, ch))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
