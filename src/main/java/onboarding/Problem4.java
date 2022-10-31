package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result += (char)('Z' - c + 'A');
            }
            else if (c >= 'a' && c <= 'z') {
                result += (char)('z' - c + 'a');
            }
            else {
                result += c;
            }
        }
        return result;
    }
}
