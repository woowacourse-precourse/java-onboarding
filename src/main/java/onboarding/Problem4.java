package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

  private static Map<String, String> greenFrogDictionary;
  private static final int MAX_WORD_LENGTH = 1000;
  private static final String EXCEPTION_ANSWER = "Exception";

  public static String solution(String word) {
    makeGreenFrogDictionary();
    if (isAllowedStringLength(word.length())) {
      return translateWord(word);
    }
    return EXCEPTION_ANSWER;
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

  public static String translateWord(String word) {
    String[] splitWord = word.split("");
    for (int i = 0; i < splitWord.length; i++) {
      if (isAlphabet(splitWord[i])) {
        splitWord[i] = greenFrogDictionary.get(splitWord[i]);
      }
    }
    return String.join("", splitWord);
  }

  public static boolean isAllowedStringLength(int wordLength) throws IllegalStateException {
    if (wordLength < 1 || wordLength > MAX_WORD_LENGTH) {
      throw new IllegalStateException("허용된 문자열 길이가 아닙니다.");
    }
    return true;
  }

}
