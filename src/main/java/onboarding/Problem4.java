package onboarding;

import onboarding.problem4.FrogTransformer;
import onboarding.problem4.NormalWord;

public class Problem4 {
    public static String solution(String word) {
        NormalWord normalWord = new NormalWord(word);
        return new FrogTransformer(normalWord).getTransformed();
    }
}
