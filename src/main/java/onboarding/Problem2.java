package onboarding;

public class Problem2 {

    private static final String EMPTY_STRING = "";
    private static final char OUT_OF_INDEX_PROTECT_CHAR = '-';

    public static String solution(String cryptogram) {

        return getRemovedDuplicationStr(cryptogram);

    }

    public static String getRemovedDuplicationStr(String cryptogram) {

        String beforeConvertedString = EMPTY_STRING;
        String afterConvertedString = cryptogram;

        while(!beforeConvertedString.equals(afterConvertedString)) {

            beforeConvertedString = afterConvertedString;
            afterConvertedString = convert(new StringBuilder(beforeConvertedString));
        }

        return afterConvertedString;
    }

    public static String convert(StringBuilder currentString) {

        StringBuilder convertedString = new StringBuilder();

        currentString.insert(0, OUT_OF_INDEX_PROTECT_CHAR);
        currentString.append(OUT_OF_INDEX_PROTECT_CHAR);

        for (int i = 1; i < currentString.length() - 1; i++) {

            char currentChar = currentString.charAt(i);

            if(currentChar == currentString.charAt(i - 1) || currentChar == currentString.charAt(i + 1))
                continue;

            convertedString.append(currentChar);
        }

        return convertedString.toString();
    }
}
