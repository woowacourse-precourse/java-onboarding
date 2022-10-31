package onboarding;

public class Problem4 {

  static Converter converter = new Converter();

  public static String solution(String word) {
    return converter.convert(word);
  }

  static class Converter {

    public String convert(String words) {
      StringBuilder result = new StringBuilder();
      for (char word : words.toCharArray()) {
        result.append(wordConvert(word));
      }
      return result.toString();
    }

    private char wordConvert(char word) {
      if (isUpperCase(word)) {
        return upperCaseConvert(word);
      }
      if (isLowerCase(word)) {
        return lowerCaseConvert(word);
      }
      return word;
    }

    private boolean isUpperCase(char word) {
      return Character.isUpperCase(word);
    }

    private boolean isLowerCase(char word) {
      return Character.isLowerCase(word);
    }

    private char upperCaseConvert(char word) {
      return (char) ('Z' - word + 'A');
    }

    private char lowerCaseConvert(char word) {
      return (char) ('z' - word + 'a');
    }

  }
}
