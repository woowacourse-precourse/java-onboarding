package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {

  private static final int MAX_CRYPTOGRAM_SIZE = 4000;
  private static final int NO_DUPLICATED_INDEX = -1;

  public static String solution(String cryptogram) {
    String answer = "";
    if (isAllowedStringLength(cryptogram.length()) && isAllowedString(cryptogram)) {
      answer = deleteContinuousDuplicatedChar(cryptogram);
    }
    return answer;
  }

  public static boolean isAllowedString(String cryptogram) throws IllegalStateException {
    for (int i = 0; i < cryptogram.length(); i++) {
      int temp = cryptogram.charAt(i) - 0;
      if (temp < 97 || temp > 122) {
        throw new IllegalStateException("소문자 알파벳으로 이루어진 문자열이 아닙니다.");
      }
    }
    return true;
  }

  public static boolean isAllowedStringLength(int cryptogramSize) throws IllegalStateException {
    if (cryptogramSize < 1 || cryptogramSize > MAX_CRYPTOGRAM_SIZE) {
      throw new IllegalStateException("1 ~ 4000자 길이의 문자열이 아닙니다.");
    }
    return true;
  }

  public static String deleteContinuousDuplicatedChar(String cryptogram) {
    String[] splitCryptogram = cryptogram.split("");
    int duplicatedIndex = getContinuousDuplicatedIndex(splitCryptogram);
    if (duplicatedIndex == NO_DUPLICATED_INDEX) {
      return cryptogram;
    } else {
      return deleteContinuousDuplicatedChar(deleteDuplicatedChar(splitCryptogram, duplicatedIndex));
    }
  }

  private static int getContinuousDuplicatedIndex(String[] splitCryptogram) {
    for (int i = 0; i < splitCryptogram.length - 1; i++) {
      if (splitCryptogram[i].equals(splitCryptogram[i + 1])) {
        return i;
      }
    }
    return NO_DUPLICATED_INDEX;
  }

  private static String deleteDuplicatedChar(String[] splitCryptogram, int duplicatedIndex) {
    ArrayList<String> strings = new ArrayList<>(Arrays.asList(splitCryptogram));
    String endPoint = strings.get(duplicatedIndex);
    while (strings.size() != 0 && strings.get(duplicatedIndex).equals(endPoint)) {
      strings.remove(duplicatedIndex);
    }
    String retString = "";
    for (String s : strings) {
      retString += s;
    }
    return retString;
  }
}
