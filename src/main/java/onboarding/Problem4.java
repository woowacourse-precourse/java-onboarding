package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char token;
        for(int i = 0; i < word.length(); i++) {
            token = word.charAt(i);
            if(token >= 'A' && token <='Z') {
                token += (char)(2*('M'+0.5-token));
            } else if(token >= 'a' && token <='z') {
                token += (char)(2*('m'+0.5-token));
            }
            answer += token;
        }
        return answer;
    }
}
