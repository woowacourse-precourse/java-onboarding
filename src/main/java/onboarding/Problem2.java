package onboarding;

import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static int[] findIndexOfDuplicates (String cryptogram) {
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < cryptogram.length(); i++) {
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
            endIndex++;
        }
        endIndex -= 1;
        return endIndex;
    }
}
