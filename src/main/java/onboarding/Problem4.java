package onboarding;

public class Problem4 {
    private static final int UPPER_SUM = (int) 'A' + (int)'Z';
    private static final int LOWER_SUM = (int) 'a' + (int)'z';

    public static String solution(String word) {
        String answer = convertWord(word);
        return answer;
    }

    private static String convertWord(String word) {
        StringBuilder convertedWord = new StringBuilder();

        for (char c: word.toCharArray()) {
            convertedWord.append(convertWord(c));
        }
        return convertedWord.toString();
    }

    private static char convertWord(char c) {
        if (Character.isUpperCase(c)) return (char)(UPPER_SUM - (int)c);
        if (Character.isLowerCase(c)) return (char)(LOWER_SUM - (int)c);
        return c;
    }
}
