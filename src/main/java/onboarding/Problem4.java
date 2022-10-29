package onboarding;

import onboarding.problem4.Answer;
import onboarding.problem4.Validation;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        try {
            Validation.validate(word);
            answer = Answer.sayTheOpposite(word);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return answer;
    }
}
