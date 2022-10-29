package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

  private static Map<String, String> greenFrogDictionary;

  public static String solution(String word) {
    String answer = "";
    return answer;
  }

  public static void makeGreenFrogDictionary() {
    String upperCase = "ABCDEFGJIJKLMNOPQRSTUVWXYZ";
    String lowerCase = "abcdefghijklmnopqrstuvwxyz";

    greenFrogDictionary = new HashMap<>();

    for (int i = 0; i < upperCase.length(); i++) {
      greenFrogDictionary.put(String.valueOf(upperCase.charAt(i)),
          String.valueOf(upperCase.charAt(upperCase.length() - 1 - i)));
    }

    for (int i = 0; i < lowerCase.length(); i++) {
      greenFrogDictionary.put(String.valueOf(lowerCase.charAt(i)),
          String.valueOf(lowerCase.charAt(lowerCase.length() - 1 - i)));

    }
  }

  public static boolean isAlphabet(String character) {
    int ASCII = character.charAt(0) - 0;
    if (ASCII < 65 || (ASCII > 90 && ASCII < 97) || ASCII > 122) {
      return false;
    }
    return true;
  }
}
