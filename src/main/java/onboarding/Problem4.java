package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] wordArray = word.toCharArray();
        for(char c : wordArray) {
            if(c >= 'A' && c <= 'Z') answer += Character.toString('Z' - c + 'A');
            else if(c >= 'a' && c <= 'z') answer += Character.toString('z' - c + 'a');
            else answer += Character.toString(c);
        }
        return answer;
    }
}
