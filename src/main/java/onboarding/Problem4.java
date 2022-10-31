package onboarding;

public class Problem4 {
    public static String solution(String word) {
        int length = word.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (Character.isAlphabetic(c)) {
                c = convert(c);
            }
            sb.append(c);
        }

        return sb.toString();
    }

    private static char convert(char c) {
        int base = 'A' + 'Z';
        if (c >= 97) { // 소문자이면
            base += 64;
        }
        return (char) (base - c);
    }

}
