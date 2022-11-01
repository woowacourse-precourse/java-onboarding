package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); ++i) {
            answer.append(convertToReverseOrder(word.charAt(i)));
        }
        return answer.toString();
    }

    private static char convertToReverseOrder(char ch) {
        if (!Character.isAlphabetic(ch)) {
            return ch;
        }
        else if (Character.isLowerCase(ch)) {
            return (char)('z' - ch + 'a');
        } else {
            return (char)('Z' - ch + 'A');
        }
    }
}
