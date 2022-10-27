package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [o] "browoanoommnaon"
 * [ ] "browoannaon"
 * [ ] "browoaaon"
 * [ ] "browoon"
 * [ ] "brown"
 * [ ] 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
 */
public class Problem2 {
    public static String solution(String cryptogram) {

        return removeDuplicates(cryptogram);
    }

    public static String removeDuplicates(String s) {
        ArrayList<Integer[]> removeList = new ArrayList<Integer[]>();

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                continue;
            }

            int duplicateStartIdx = i;
            int duplicateEndIdx = i + 1;

            for (int j = i + 1; j < s.length() - 1; j++) {
                if (s.charAt(j) != s.charAt(j + 1)) {
                    duplicateEndIdx = j;
                    break;
                }
            }

            removeList.add(new Integer[]{duplicateStartIdx, duplicateEndIdx});
            i = duplicateEndIdx;
        }

        for (int i = 0; i < removeList.size(); i++) {
            Integer[] indexes = removeList.get(i);
            System.out.println(Arrays.toString(indexes));

            s = s.substring(0, indexes[0]) + s.substring(indexes[1] + 1);

            if (i != removeList.size() - 1) {
                Integer[] nextIndexes = removeList.get(i + 1);
                nextIndexes[0] -= (indexes[1] - indexes[0] + 1);
                nextIndexes[1] -= (indexes[1] - indexes[0] + 1);
            }

        }

        return s;
    }
}