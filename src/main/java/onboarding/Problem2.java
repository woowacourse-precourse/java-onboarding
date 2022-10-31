package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

  public static String solution(String cryptogram) {
    String answer = "answer";
    List<int[]> needRemoveIndexes = findNeedRemoveIndexes(cryptogram);

    return answer;
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
