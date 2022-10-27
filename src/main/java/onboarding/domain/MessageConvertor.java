package onboarding.domain;

import java.util.stream.Collectors;

public class MessageConvertor {
    public static final int FIRST_UPPERCASE = 65;
    public static final int FIRST_LOWERCASE = 97;

    private final String convertResult;

    public MessageConvertor(String word) {
        this.convertResult = convertMessage(word);
    }

    private String convertMessage(String word) {
        return word.chars()
                .map(MessageConvertor::convertToTreeFrogWord)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    private static int convertToTreeFrogWord(int character) {
        if (Character.isUpperCase(character)) {
            return convertAlphaToTreeFrogWord(character, FIRST_UPPERCASE);
        }
        if (Character.isLowerCase(character)) {
            return convertAlphaToTreeFrogWord(character, FIRST_LOWERCASE);
        }
        return character;
    }

    private static int convertAlphaToTreeFrogWord(int character, int firstWord) {
        return character + 25 - 2 * (character - firstWord);
    }

    public String getConvertResult() {
        return convertResult;
    }
}
