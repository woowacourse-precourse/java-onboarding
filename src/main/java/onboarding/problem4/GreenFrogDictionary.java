package onboarding.problem4;

import java.util.stream.Collectors;

public class GreenFrogDictionary {
  private String translatedWord;

  public String getTranslateResult() {
    return translatedWord;
  }

  public void translate(String word) {
    translatedWord = word.chars().mapToObj(ch -> (char) ch)
            .map(this::reverseConversion)
            .map(Object::toString)
            .collect(Collectors.joining());
  }

  private char reverseConversion(Character character) {
    if (character >= 'A' & character <= 'Z') {
      return (char) ('Z' - (character - 'A'));
    }
    if (character >= 'a' & character <= 'z') {
      return (char) ('z' - (character - 'a'));
    }
    return character;
  }
}
