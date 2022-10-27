package onboarding;

import onboarding.problem4.Converter;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Converter converter = new Converter();
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            answer += converter.func(c);
        }
        return answer;
    }
}
