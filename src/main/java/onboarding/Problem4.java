package onboarding;

public class Problem4 {

  public static String solution(String word) {
    return Converter.convert(word);
  }

  static class Converter {

    public static String convert(String words) {
      StringBuilder result = new StringBuilder();
      for (char word : words.toCharArray()) {
        result.append(wordConvert(word));
      }
      return result.toString();
    }

    private static char wordConvert(char word) {
      if (isUpperCase(word)) {
        return upperCaseConvert(word);
      } else if (isLowerCase(word)) {
        return lowerCaseConvert(word);
      }
      return word;
    }

    private static boolean isUpperCase(char word) {
      return Character.isUpperCase(word);
    }

    private static boolean isLowerCase(char word) {
      return Character.isLowerCase(word);
    }

    private static char upperCaseConvert(char word) {
      return (char) ('Z' - word + 'A');
    }

    private static char lowerCaseConvert(char word) {
      return (char) ('z' - word + 'a');
    }

  }
}
