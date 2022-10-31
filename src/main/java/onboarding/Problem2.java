package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        List<String> duplicatedParts = new ArrayList<>();

        while (answer != cryptogram) {
            answer = cryptogram;
            duplicatedParts.clear();
            readCryptogram(cryptogram, duplicatedParts);
            cryptogram = getCompactedCryptogram(cryptogram, duplicatedParts);
        }
        return answer;
    }

    public static int getLastConsecutiveIndex(String cryptogram, char ch, int start) {
        int j = start;
        /* 어디까지 연속되는지 체크한다 */
        while (j < cryptogram.length() && cryptogram.charAt(j) == ch)
            j++;
        return j;
    }
    public static String getCompactedCryptogram(String cryptogram, List<String> duplicatedParts) {
        if (duplicatedParts.size() != 0)
            cryptogram = deleteConsecutiveRange(cryptogram, duplicatedParts);
        return cryptogram;
    }
    public static String deleteConsecutiveRange(String cryptogram, List<String> duplicatedParts) {
        for (String part: duplicatedParts) {
            cryptogram = cryptogram.replaceFirst(part, "");
        }
        return cryptogram;
    }

    public static int getNextReadIndex(String cryptogram, List<String> duplicatedParts, int start) {
        char currentCh = cryptogram.charAt(start);
        char nextCh = cryptogram.charAt(start + 1);
        /* 연속되는 문자가 있는지 체크한다 */
        if (currentCh == nextCh) {
            int j = getLastConsecutiveIndex(cryptogram, currentCh, start + 1);
            duplicatedParts.add(cryptogram.substring(start, j));
            return j;
        }
        return start + 1;
    }

    public static void readCryptogram(String cryptogram, List<String> duplicatedParts) {
        int i = 0;
        while (i < cryptogram.length() - 1)
            i = getNextReadIndex(cryptogram, duplicatedParts, i);
    }
}

/*
<<요구사항>>
1. 소문자로만 이루어진 길이 1이상 1000이하의 문자열이 주어진다
2. 연속하는 중복 문자들을 전부 제거해나가서 최종적으론 연속되는 중복문자가 없는 문자열을 리턴한다
 */

/*
<<기능 목록>>
- [V] 문자열을 왼쪽부터 읽는다
- [V] 연속되는 문자가 있는지 체크한다.
  - [V] 연속되는 문자가 있다면 어디까지 연속되는지 체크한다
  - [V] 연속되는 구간을 duplicatedParts에 모은다
  - [V] duplicatedParts의 문자들을 빈 문자열로 바꾼다
- [V] 연속되는 문자가 없다면 그 문자열을 answer에 담고 반복문을 벗어난다
 */
