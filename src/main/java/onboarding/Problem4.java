package onboarding;

import static java.lang.Character.*;

public class Problem4 {
  private static final char START_UPPER_ALPHABET = 'A';
  private static final char START_LOWER_ALPHABET = 'a';
  private static final int ALPHABET_NUMBER = 25;

  public static String solution(String word) {
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
