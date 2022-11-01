package onboarding.problem04.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import onboarding.problem04.infra.exception.StringLengthOutOfRange;
import onboarding.problem04.infra.util.ConsoleOut;

public class ReverseString {

  private char[] smallLetter = "abcdefghijklmnopqrstuvwxyz".toCharArray();
  private char[] capitalLetter = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
  private List<Character> letterSet;
  private StringBuilder result = new StringBuilder();

  private ReverseString(String givenString) {
    if (givenString.length() < 1 && givenString.length() > 1000) {
      throw new StringLengthOutOfRange();
    }
    letterSet = givenString.chars().mapToObj(index -> (char) index)
        .collect(Collectors.toList());
  }

  public static ReverseString from(String str) {
    return new ReverseString(str);
  }

  public String processing() {

    for (Character character : letterSet) {

      int temp = 0;
      if (isSpace(character)) {
        result.append(character);
      }

      if (isSmallLetter((int) character)) {
        for (int i = 0; i < smallLetter.length; i++) {
          if (character == smallLetter[i]) {
            temp = i;
            break;
          }
        }
        result.append(smallLetter[smallLetter.length - temp - 1]);
      }

      if (isCapitalLetter((int) character)) {
        for (int i = 0; i < capitalLetter.length; i++) {
          if (character == capitalLetter[i]) {
            temp = i;
            break;
          }
        }
        result.append(capitalLetter[capitalLetter.length - temp - 1]);
      }

    }

    return result.toString();
  }

  private boolean isCapitalLetter(int character) {
    return character >= ConsoleOut.CAPITAL_LETTER_MIN && character <= ConsoleOut.CAPITAL_LETTER_MAX;
  }

  private boolean isSmallLetter(int character) {
    return character >= ConsoleOut.SMALL_LETTER_MIN && character <= ConsoleOut.SMALL_LETTER_MAX;
  }

  private boolean isSpace(Character character) {
    return character == ' ';
  }
}
