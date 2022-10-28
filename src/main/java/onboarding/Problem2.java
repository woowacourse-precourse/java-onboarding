package onboarding;

import onboarding.problem2.Limiter;

import java.util.HashSet;

import static onboarding.problem2.Converter.convertToArray;
import static onboarding.problem2.LowerCase.modifyLowerCase;
import static onboarding.problem2.Reducer.reduceDuplicate;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        String limitLength = Limiter.limitLength(cryptogram);
        String modifyUpperCased = modifyLowerCase(String.valueOf(limitLength));
        char[] convertedToArray = convertToArray(modifyUpperCased);
        HashSet<String> reducedDuplicate = reduceDuplicate(convertedToArray);


        answer = String.valueOf(reducedDuplicate);
        return answer;
    }


}
