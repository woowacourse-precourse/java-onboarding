package onboarding;

public class Problem2 {

  public static String solution(String cryptogram) {
    String temporaryCryptogram = "";
    while (!temporaryCryptogram.equals(cryptogram)) {
      temporaryCryptogram = cryptogram;
      cryptogram = removeDuplicate(cryptogram);
    }
    return cryptogram;
  }

  private static String removeDuplicate(String cryptogram) {
    int startRemoveIndex = 0;
    int endRemoveIndex = 0;
    while ((startRemoveIndex < cryptogram.length()) && (endRemoveIndex == startRemoveIndex)) {
      endRemoveIndex = findDuplicate(cryptogram, startRemoveIndex);
      startRemoveIndex++;
    }
    if (endRemoveIndex != startRemoveIndex) {
      cryptogram =
          cryptogram.substring(0, startRemoveIndex - 1) + cryptogram.substring(endRemoveIndex);
    }
    return cryptogram;
  }

  private static int findDuplicate(String cryptogram, int startRemoveIndex) {
    int endRemoveIndex = startRemoveIndex + 1;
    while ((endRemoveIndex < cryptogram.length()) && (cryptogram.charAt(startRemoveIndex)
        == cryptogram.charAt(
        endRemoveIndex))) {
      endRemoveIndex++;
    }
    return endRemoveIndex;
  }
}
