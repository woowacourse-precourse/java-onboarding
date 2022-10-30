package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        List<int[]> duplicateIndexList = findIndexOfDuplicates(answer);
        while (duplicateIndexList.size() != 0) {
            String tempCryptogram = answer;
            for (int[] indexList : duplicateIndexList) {
                String duplicatesWord = returnDuplicatesWord(answer, indexList);
                tempCryptogram = removeDuplicates(tempCryptogram, duplicatesWord);
            }
            answer = tempCryptogram;
            duplicateIndexList = findIndexOfDuplicates(answer);
        }

        return answer;
    }

    private static List<int[]> findIndexOfDuplicates (String cryptogram) {
        int startIndex;
        int endIndex;
        List<int[]> indexList = new ArrayList<>();
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                startIndex = i;
                endIndex = findEndIndexOfDuplicates (cryptogram, startIndex);
                indexList.add(new int[] {startIndex, endIndex});
                i = endIndex;
            }
        }
        return indexList;
    }

    private static int findEndIndexOfDuplicates (String cryptogram, int startIndex) {
        char startIndexChar = cryptogram.charAt(startIndex);
        int endIndex = startIndex+1;
        while (cryptogram.charAt(endIndex) == startIndexChar) {
            if (++endIndex == cryptogram.length()) {
                break;
            }
        }
        endIndex -= 1;
        return endIndex;
    }

    private static String returnDuplicatesWord (String cryptogram, int[] indexList) {
        String duplicates = cryptogram.substring(indexList[0], indexList[1]+1);
        return duplicates;
    }

    private static String removeDuplicates (String cryptogram, String duplicates) {
        String resultString = cryptogram.replace(duplicates, "");
        return resultString;
    }
}
