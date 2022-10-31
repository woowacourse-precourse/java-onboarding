package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

  public static String solution(String cryptogram) {
    String answer = "answer";
    answer = decode(cryptogram);
    return answer;
  }

  public static String decode(String cryptogram) {
    if (cryptogram.length() == 0) {
      return "";
    }
    List<int[]> needRemoveIndexes = findNeedRemoveIndexes(cryptogram);
    if (!needRemoveIndexes.isEmpty()) {
      String removedString = removeDuplicate(needRemoveIndexes, cryptogram);
      return decode(removedString);
    } else {
      return cryptogram;
    }
  }

  public static String removeDuplicate(List<int[]> needRemoveIndexes, String str) {
    /*
     *  문자열을 제거하면, index가 감소하므로 그만큼 offset으로 제거.
     */
    int offset = 0;
    while (!needRemoveIndexes.isEmpty()) {
      int[] indexs = needRemoveIndexes.remove(0);
      int start = indexs[0];
      int end = indexs[1];
      str = str.substring(0, start - offset) + str.substring(end + 1 - offset);
      offset += end - start + 1;
    }
    return str;
  }

  public static List<int[]> findNeedRemoveIndexes(String str) {
    List<int[]> needRemoveIndex = new ArrayList<>();

    char[] chars = str.toCharArray();
    int startIndex = 0;
    char compareChar = chars[0];
    for (int i = 1; i < chars.length; i++) {
      if (compareChar == chars[i]) {
        if (i == chars.length - 1) {
          needRemoveIndex.add(new int[]{startIndex, i});
        }
        continue;
      }

      if (startIndex != i - 1) {
        needRemoveIndex.add(new int[]{startIndex, i - 1});
      }
      startIndex = i;
      compareChar = chars[i];
    }
    return needRemoveIndex;
  }
}
