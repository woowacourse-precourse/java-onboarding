package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (Character.isAlphabetic(ch)) {
                if (Character.isUpperCase(ch)) {
                    String s = String.valueOf((char) (155 - ch));
                    sb.replace(i, i + 1, s);
                } else {
                    String s = String.valueOf((char) (219 - ch));
                    sb.replace(i, i + 1, s);
                }
            }
        }
        return sb.toString();
    }
}
