package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == ' ') answer += c;
            else if(c >= 'a' && c <= 'z') answer += (char)(25 - (c - 'a') + 'a');
            else if(c >= 'A' && c <= 'Z') answer += (char)(25 - (c - 'A') + 'A');
        }
        return answer;
    }
}
