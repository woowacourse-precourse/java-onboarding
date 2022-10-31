package onboarding.support.problem4;

import java.util.stream.IntStream;

public class DictionaryConverter {

    private final String convertedString;

    public DictionaryConverter(String word) {
        StringBuilder convertedStringBuilder = new StringBuilder();
        IntStream.range(0, word.length())
                .forEach(i -> convertedStringBuilder.append(getConvertedCharacter(word.charAt(i))));
        this.convertedString = convertedStringBuilder.toString();
    }

    public String getConvertedString() {
        return convertedString;
    }

    public static char getConvertedCharacter(char original) {
        if (checkEmptySpace(original)) return original;
        int base = getBaseCharacterASCII(original);
        return convertOriginalCharacter(original, base);
    }

    private static char convertOriginalCharacter(char original, int base) {
        return (char) (Constants.getLastCharacterAscii() - (original - base) + base);
    }

    private static boolean checkEmptySpace(char original) {
        return original == Constants.getEmptySpace();
    }

    public static int getBaseCharacterASCII(char alphabet) {
        int base = Constants.getLowerCaseBase();
        if (isUpper(alphabet)) base = Constants.getUpperCaseBase();
        return base;
    }

    public static boolean isUpper(char alphabet) {
        return alphabet >= 'A' && alphabet <= 'Z';
    }
}
