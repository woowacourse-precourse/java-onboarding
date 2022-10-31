package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result += (char)('Z' - c + 'A');
            }
            else if (c >= 'a' && c <= 'z') {
                result += (char)('z' - c + 'a');
            }
        }
        return result;
    }
}
