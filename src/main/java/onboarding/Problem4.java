package onboarding;

import onboarding.problem4.GreenFrogDictionary;

public class Problem4 {
  public static String solution(String word) {
    GreenFrogDictionary greenFrogDictionary = new GreenFrogDictionary();
    greenFrogDictionary.translate(word);
    return greenFrogDictionary.getTranslateResult();
  }
}
