package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

  public static String solution(String word) {
    Map<Character, Character> dictionary = getDictionary();
    return getTranslatedWord(word, dictionary);
  }

  private static String getTranslatedWord(String word, Map<Character, Character> dictionary) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      char translatedChar = word.charAt(i);
      if (Character.isAlphabetic(word.charAt(i))) {
        translatedChar = dictionary.get(translatedChar);
      }
      result.append(translatedChar);
    }
    return result.toString();
  }

  private static Map<Character, Character> getDictionary() {
    final int numberOfAlphabets = 26;
    Map<Character, Character> result = new HashMap<>(numberOfAlphabets * 2);
    for (int i = 0; i < numberOfAlphabets; i++) {
      result.put((char) ('a' + i), (char) ('z' - i));
      result.put((char) ('A' + i), (char) ('Z' - i));
    }
    return result;
  }
}