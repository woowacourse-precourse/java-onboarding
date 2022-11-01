package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i < word.length(); i++) {
            int ch = word.charAt(i);
            if (ch >= 'A' && ch <='Z') ch = 'A' + 'Z' - ch;
            if(ch >= 'a' && ch <='z') ch = 'a' + 'z' - ch;
            answer += (char)ch;
        }
        return answer;
    }
}