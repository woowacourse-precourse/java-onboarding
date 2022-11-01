package onboarding;

public class Problem4 {
    private static final int UPPER_LAST_ALPHABET = 90;
    private static final int LOWER_LAST_ALPHABET = 90;

    public static String solution(String word) {
        char[] alphabetArray = word.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < alphabetArray.length; i++) {
            Character result;
            if (Character.isAlphabetic(alphabetArray[i]) && Character.isUpperCase(alphabetArray[i])) {
                result = (char) (UPPER_LAST_ALPHABET - alphabetArray[i] + 'A');
            } else if (Character.isAlphabetic(alphabetArray[i]) && Character.isLowerCase(alphabetArray[i])) {
                result = (char) (LOWER_LAST_ALPHABET - alphabetArray[i] + 'a');
            } else {
                result = alphabetArray[i];
            }
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }
}
