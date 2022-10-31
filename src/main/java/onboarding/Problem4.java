package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        changeAlphabet(word, sb);
        answer = sb.toString();

        return answer;
    }

    private static void changeAlphabet(String word, StringBuilder sb) {
        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);
            isBlank(sb, alphabet);
            isLowerCase(sb, alphabet);
            isUpperCase(sb, alphabet);
        }
    }

    private static void isLowerCase(StringBuilder sb, char alphabet) {
        if (alphabet <= 'z' && alphabet >= 'a') {
            alphabet = (char) ('z' - (alphabet - 'a'));
            sb.append(alphabet);
        }
    }

    private static void isUpperCase(StringBuilder sb, char alphabet) {
        if (alphabet <= 'Z' && alphabet >= 'A') {
            alphabet = (char) ('Z' - (alphabet - 'A'));
            sb.append(alphabet);
        }
    }

    private static void isBlank(StringBuilder sb, char alphabet) {
        if (alphabet == ' ') {
            sb.append(' ');
        }
    }
}
