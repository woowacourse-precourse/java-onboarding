package onboarding;


public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (char ch : word.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                answer += (char)('Z' - ch + 'A');
            } else if (ch >= 'a' && ch <= 'z') {
                answer += (char)('z' - ch + 'a');
            } else if (ch == ' ') {
                answer += " ";
            } else {
                answer += String.valueOf(ch);
            }
        }

        return answer;
    }
}
