package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    static String getPattern(String cryptogram){
        String pattern = "";
        Set<String> tokenSet = Set.of(cryptogram.split(""));
        String tokenString = String.join("", tokenSet);

        pattern = "[" + tokenString + "]{2}";

        return pattern;
    }
}
