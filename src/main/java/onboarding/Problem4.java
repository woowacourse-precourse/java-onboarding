package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0 ; index < word.length() ; index++) {
            String convertedString = getConvertedString(word, index);
            stringBuilder.append(convertedString);
        }

        return stringBuilder.toString();
    }

    private static String getConvertedString(String word, int index) {
        char originalLetter = word.charAt(index);

        if (Character.isUpperCase(originalLetter)) {
            return convertUpperCase(originalLetter);
        } else if (Character.isLowerCase(word.charAt(index))) {
            return convertLowerCase(originalLetter);
        }

        return " ";
    }

    private static String convertUpperCase(char originalLetter) {
        return null;
    }

    private static String convertLowerCase(char originalLetter) {
        return null;
    }
}
