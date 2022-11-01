package onboarding;

import onboarding.p4.Dictionary;
import onboarding.p4.GreenFrogDictionary;

public class Problem4 {
    public static String solution(String word) {
        Dictionary dictionary = new GreenFrogDictionary();
        return dictionary.convertString(word);
    }
}
