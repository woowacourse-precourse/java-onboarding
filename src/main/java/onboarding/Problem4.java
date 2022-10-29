package onboarding;

import java.util.stream.Collectors;

public class Problem4 {
  static class GreenFrogDictionary {
    private String translatedWord;
    public void translate(String word) {
      translatedWord = word.chars().mapToObj(ch -> (char) ch)
              .map(this::reverseConversion)
              .map(Object::toString)
              .collect(Collectors.joining());
    }

    public char reverseConversion(Character character) {
      if (character >= 'A' & character <= 'Z') {
        return (char) ('Z' - (character - 'A'));
      }
      if (character >= 'a' & character <= 'z') {
        return (char) ('z' - (character - 'a'));
      }
      return character;
    }
    public String getTranslatedWord() {
      return translatedWord;
    }
  }

  public static String solution(String word) {
    GreenFrogDictionary greenFrogDictionary = new GreenFrogDictionary();
    greenFrogDictionary.translate(word);
    return greenFrogDictionary.getTranslatedWord();
  }
}
