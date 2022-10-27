package onboarding;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    return "";
  }
}
