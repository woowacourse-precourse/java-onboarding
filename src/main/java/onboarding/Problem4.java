package onboarding;

import static java.lang.Character.*;

public class Problem4 {
  private static final char START_UPPER_ALPHABET = 'A';
  private static final char START_LOWER_ALPHABET = 'a';
  private static final int ALPHABET_NUMBER = 25;
  private static final int MIN_RANGE_NUMBER = 1;
  private static final int MAX_RANGE_NUMBER = 10000;

  public static String solution(String word) {
    validate(word);
    String answer = "";
    StringBuilder stringBuilder = new StringBuilder();
    for (Character currentAlphabet : word.toCharArray()) {
      if (!isAlphabetic(currentAlphabet)) {
        stringBuilder.append(currentAlphabet);
        continue;
      }
      stringBuilder.append(convertByFrog(currentAlphabet));
    }
    answer = stringBuilder.toString();
    return answer;
  }

  private static void validate(String word) {
    int wordLength = word.length();
    if (isInRange(wordLength)) {
      throw new IllegalArgumentException("범위 초과");
    }
  }

  private static boolean isInRange(int wordLength) {
    return (wordLength < MIN_RANGE_NUMBER) || (wordLength > MAX_RANGE_NUMBER);
  }

  private static String convertByFrog(char alphabet) {
    char reversedString;
    if (Character.isLowerCase(alphabet)) {
      reversedString = getReverseStringWhenStarter(alphabet, START_LOWER_ALPHABET);
      return String.valueOf(reversedString);
    }
    reversedString = getReverseStringWhenStarter(alphabet, START_UPPER_ALPHABET);
    return String.valueOf(reversedString);
  }

  private static char getReverseStringWhenStarter(char alphabet, char starterAlphabet) {
    return (char) (ALPHABET_NUMBER - (alphabet - starterAlphabet) + starterAlphabet);
  }
}
