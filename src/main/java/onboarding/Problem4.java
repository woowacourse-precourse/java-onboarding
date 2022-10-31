package onboarding;

import onboarding.problem4.FrogDictionary;

public class Problem4 {

    public static String solution(String word) {
        FrogDictionary frogDictionary = new FrogDictionary();
        return frogDictionary.translate(word);
    }

}

