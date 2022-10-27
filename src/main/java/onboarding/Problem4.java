package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = reverseWord(word);
        return answer;
    }

    private static String reverseWord(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                stringBuilder.append((char)('Z' + 'A' - c));
            } else if (c >= 'a' && c <= 'z') {
                stringBuilder.append((char)('z' + 'a' - c));
            } else if (c == ' ') {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
