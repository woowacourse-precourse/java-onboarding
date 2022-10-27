package onboarding;

import java.util.stream.Collectors;

public class Problem4 {
  static class GreenFrogDictionary {
    public static char translate(Character character) {
      if (character >= 'A' & character <= 'Z') {
        return (char) ('Z' - (character - 'A'));
      }
      if (character >= 'a' & character <= 'z') {
        return (char) ('z' - (character - 'a'));
      }
      return character;
    }
  }

  public static String solution(String word) {
    return word.chars().mapToObj(ch -> (char) ch)
            .map(GreenFrogDictionary::translate)
            .map(Object::toString)
            .collect(Collectors.joining());
  }
}
