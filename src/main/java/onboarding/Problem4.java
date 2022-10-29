package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

  private static Map<Character, Character> greenFrogDictionary;

  public static String solution(String word) {
    String answer = "";
    return answer;
  }

  public static void makeGreenFrogDictionary() {
    String upperCase = "ABCDEFGJIJKLMNOPQRSTUVWXYZ";
    String lowerCase = "abcdefghijklmnopqrstuvwxyz";

    greenFrogDictionary = new HashMap<>();

    for (int i = 0; i < upperCase.length(); i++) {
      greenFrogDictionary.put(upperCase.charAt(i), upperCase.charAt(upperCase.length()-1 - i));
    }

    for (int i = 0; i < lowerCase.length(); i++) {
      greenFrogDictionary.put(lowerCase.charAt(i), lowerCase.charAt(lowerCase.length()-1 - i));
    }
  }
  
}
