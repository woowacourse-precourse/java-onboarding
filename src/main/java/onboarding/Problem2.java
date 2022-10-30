package onboarding;

import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        int[] duplicateIndexList = findIndexOfDuplicates(answer);
        while (duplicateIndexList[0] != -1) {
            answer = removeDuplicates(answer, duplicateIndexList);
            duplicateIndexList = findIndexOfDuplicates(answer);
        }

        return answer;
    }

    private static int[] findIndexOfDuplicates (String cryptogram) {
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                startIndex = i;
                endIndex = findEndIndexOfDuplicates (cryptogram, startIndex);
            }
        }
        return new int[] {startIndex, endIndex};
    }

    private static int findEndIndexOfDuplicates (String cryptogram, int startIndex) {
        char startIndexChar = cryptogram.charAt(startIndex);
        int endIndex = startIndex+1;
        while (cryptogram.charAt(endIndex) == startIndexChar) {
            if (++endIndex == cryptogram.length()) {
                break;
            }
        }
        return endIndex;
    }

    private static String removeDuplicates (String cryptogram, int[] indexList) {
        String duplicates = cryptogram.substring(indexList[0], indexList[1]);
        String resultString = cryptogram.replace(duplicates, "");
        return resultString;
    }
}
