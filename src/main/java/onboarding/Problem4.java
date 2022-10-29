package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            c = convertFrogAlphabet(c);
            sb.append(c);
        }
        return sb.toString();
    }

    public static char convertFrogAlphabet(char c) {
        if (!Character.isLetter(c)) {
            return c;
        }
        if (Character.isLowerCase(c)) {
            return (char)('z' - (c - 'a'));
        }
        if (Character.isUpperCase(c)) {
            return (char)('Z' - (c - 'A'));
        }
        return c;
    }
}
