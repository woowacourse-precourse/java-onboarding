package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

  private static final int ALPHABET_SIZE = 26;
  private static final Dictionary dictionary = new FrogDictionary();

  public static String solution(String word) {
    return dictionary.translate(word);
  }

  interface Dictionary {

    String translate(String word);
  }

  static class FrogDictionary implements Dictionary {

    private final Map<Character, Character> dictionary = new HashMap<>();

    FrogDictionary() {
      reverseAlphabet();
    }

    private void reverseAlphabet() {
      for (int i = 0; i < ALPHABET_SIZE; i++) {
        dictionary.put((char) ('a' + i), (char) ('z' - i));
        dictionary.put((char) ('A' + i), (char) ('Z' - i));
      }
    }

    @Override
    public String translate(String word) {
      StringBuilder translateResult = new StringBuilder();
      for (int i = 0; i < word.length(); i++) {
        char currentChar = word.charAt(i);
        if (isAlphabet(currentChar)) {
          translateResult.append(dictionary.get(currentChar));
        } else {
          translateResult.append(currentChar);
        }
      }
      return translateResult.toString();
    }

    private boolean isAlphabet(char currentChar) {
      return 'a' <= currentChar && currentChar <= 'z' ||
          'A' <= currentChar && currentChar <= 'Z';
    }
  }
}
