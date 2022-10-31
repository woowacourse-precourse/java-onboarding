package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    private static List<Integer[]> duplicateIndexList;
    private static Integer[] duplicateIndex;
    private static boolean duplicateCheck;

    public static String solution(String cryptogram) {
        while (duplicateStringFind(cryptogram).size() != 0) {
            cryptogram = removeDuplication(cryptogram, duplicateStringFind(cryptogram));
        }
        return cryptogram;
    }

    private static List<Integer[]> duplicateStringFind(String cryptogram) {
        String[] charList = cryptogram.split("(?<=.)");
        duplicateIndexList = new ArrayList<>();
        duplicateIndex = new Integer[2];
        duplicateCheck = false;

        if (putDuplicateIndexList(charList)) {
            duplicateIndex[1] = charList.length - 1;
            duplicateIndexList.add(duplicateIndex);
        }
        return duplicateIndexList;
    }

    private static boolean putDuplicateIndexList(String[] charList) {
        for (int i = 0; i < charList.length - 1; i++) {
            if (charList[i].equals(charList[i + 1]) && !duplicateCheck) {
                duplicateCheck = updateDuplication(duplicateIndex, false, i);
            }
            if (!charList[i].equals(charList[i + 1]) && duplicateCheck) {
                duplicateCheck = updateDuplication(duplicateIndex, true, i);
                duplicateIndexList.add(duplicateIndex);
            }
        }
        return duplicateCheck;
    }

    private static boolean updateDuplication(Integer[] duplicateIndex, boolean duplicateCheck, int i) {
        if (duplicateCheck) {
            duplicateIndex[1] = i;
            return false;
        }
        duplicateIndex[0] = i;
        return true;
    }


    private static String removeDuplication(String cryptogram, List<Integer[]> duplicateIndexList) {
        String[] charList = cryptogram.split("(?<=.)");
        duplicateIndexList.forEach(index -> {
            removeDuplicationLoop(index, charList);
        });
        return String.join("", charList);
    }

    private static void removeDuplicationLoop(Integer[] index, String[] charList) {
        int start = index[0];
        int stop = index[1];
        while (start <= stop) {
            charList[start] = "";
            start++;
        }
    }
}
