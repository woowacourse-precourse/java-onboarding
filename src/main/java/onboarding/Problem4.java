package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(char c: word.toCharArray()) {
            if((int) c >= 65 && (int) c <= 90) {
                answer += Character.toString(155 - (int) c);
            }
            else if((int) c >= 97 && (int) c <= 122) {
                answer += Character.toString(219 - (int) c);
            }
            else {
                answer += c;
            }
        }
        return answer;
    }
}
