package onboarding.problem4.domain;

import java.util.stream.IntStream;

public class FrogWordTranslateStrategy implements WordTranslateStrategy {

    @Override
    public String translate(String word) {
        char[] charArray = word.toCharArray();
        StringBuffer result = new StringBuffer();
        IntStream.range(0, charArray.length)
                .map(i -> charArray[i])
                .map(this::translate)
                .forEach(c -> result.append((char) (c)));
        return result.toString();
    }

    private char translate(int asciiNumber) {
        if (Character.isUpperCase(asciiNumber)) {
            return (char) ('Z' - asciiNumber + 'A');
        }
        if (Character.isLowerCase(asciiNumber)) {
            return (char) ('z' - asciiNumber + 'a');
        }
        return (char) asciiNumber;
    }
}
