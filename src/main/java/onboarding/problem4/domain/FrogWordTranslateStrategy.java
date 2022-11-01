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
                .forEach(c -> result.append(asciiNumberToChar(c)));
        return result.toString();
    }

    private char translate(int asciiNumber) {
        if (Character.isUpperCase(asciiNumber)) {
            return upperCaseStrategy(asciiNumber);
        }
        if (Character.isLowerCase(asciiNumber)) {
            return lowerCaseStrategy(asciiNumber);
        }
        return defaultStrategy(asciiNumber);
    }

    private static char upperCaseStrategy(int asciiNumber) {
        return asciiNumberToChar(('Z' - asciiNumber + 'A'));
    }

    private static char lowerCaseStrategy(int asciiNumber) {
        return asciiNumberToChar(('z' - asciiNumber + 'a'));
    }

    private static char defaultStrategy(int asciiNumber) {
        return asciiNumberToChar(asciiNumber);
    }

    private static char asciiNumberToChar(int asciiNumber) {
        return (char) asciiNumber;
    }
}
