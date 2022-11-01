package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                if (word.charAt(i) <= 'M') answer += (char)(word.charAt(i) + 25 - ((word.charAt(i) - 'A') * 2));
                else answer += (char)(word.charAt(i) - 25 + (('Z' - (word.charAt(i))) * 2));
            }
            else if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                if (word.charAt(i) <= 'm') answer += (char)(word.charAt(i) + 25 - ((word.charAt(i) - 'a') * 2));
                else answer += (char)(word.charAt(i) - 25 + (('z' - word.charAt(i)) * 2));
            }
            else answer += " ";
        }
        return answer;
    }
}
