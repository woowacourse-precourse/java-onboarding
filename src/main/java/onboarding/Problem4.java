package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        char[] alphabets = word.toCharArray();

        for (char alphabet : alphabets) {
            if (isAlphabet(alphabet)) {
                sb.append(convert(alphabet));
                continue;
            }

            sb.append(alphabet);
        }

        return sb.toString();
    }

    private static char convert(char alphabet) {
        return isUpperCase(alphabet) ? (char) ('Z' - (alphabet - 'A')) : (char) ('z' - (alphabet - 'a'));
    }

    private static boolean isUpperCase(char alphabet) {
        return 'A' <= alphabet && alphabet <= 'Z';
    }

    private static boolean isAlphabet(char alphabet) {
        return ('A' <= alphabet && alphabet <= 'Z') || ('a' <= alphabet && alphabet <= 'z');
    }
}
