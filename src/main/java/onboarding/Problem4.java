package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return changeWord(word);
    }


    public static String changeWord(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            stringBuilder.append(convert(ch));
        }
        return String.valueOf(stringBuilder);
    }

    private static char convert(char ch) {
        if (ch >= 'a' && 'z' >= ch) {
            return (char) (97 + (122 - ch));
        } else if (ch >= 'A' && 'Z' >= ch) {
            return (char) (65 + (90 - ch));
        }
        return ch;
    }
}
