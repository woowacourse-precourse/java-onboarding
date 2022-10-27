package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return getPlainWord(word);
    }

    static String getPlainWord(String word) {
        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {

            if (Character.isUpperCase(c)) {
                sb.append((char) (155 - c));
            } else if (Character.isLowerCase(c)) {
                sb.append((char) (219 - c));
            } else sb.append(c);
        }
        return sb.toString();
    }
}
