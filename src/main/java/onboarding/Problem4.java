package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return getOppositeWord(word);
    }

    private static String getOppositeWord(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {

            if (Character.isUpperCase(word.charAt(i)))
                sb.append((char) ('Z' - word.charAt(i) + 'A'));

            if (Character.isLowerCase(word.charAt(i)))
                sb.append((char)('z' - word.charAt(i) + 'a'));

            if (word.charAt(i) == ' ')
                sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}
