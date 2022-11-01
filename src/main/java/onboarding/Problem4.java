package onboarding;

import onboarding.problem4.Convertor;
import onboarding.problem4.Validator;

public class Problem4 {
    public static String solution(String word) {
        if(!Validator.validate(word)){return "Error";}
        return Convertor.convertString(word);
    }
}
