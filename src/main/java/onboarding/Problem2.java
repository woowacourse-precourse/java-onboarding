package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (duplicateStringFind(cryptogram).size() != 0) {
            cryptogram = processCryptogram(cryptogram);
        }
        return cryptogram;
    }

    private static String processCryptogram(String cryptogram) {
        return removeDuplication(cryptogram, duplicateStringFind(cryptogram));
    }

    private static List<Integer[]> duplicateStringFind(String cryptogram) {
        List duplicateIndexList = new ArrayList();
        String[] charList = cryptogram.split("(?<=.)");
        Integer[] duplicateIndex = new Integer[2];
        boolean duplicateCheck = false;

        for (int i = 0; i < charList.length; i++) {
            if (i == charList.length - 1) {
                if (duplicateCheck) {
                    duplicateIndex[1] = i;
                    duplicateIndexList.add(duplicateIndex);
                }
                break;
            }
            if (charList[i].equals(charList[i + 1]) && !duplicateCheck) {
                duplicateIndex[0] = i;
                duplicateCheck = true;
            } else if (!charList[i].equals(charList[i + 1]) && duplicateCheck) {
                duplicateIndex[1] = i;
                duplicateIndexList.add(duplicateIndex);
                duplicateIndex = new Integer[2];
                duplicateCheck = false;
            }
        }
        return duplicateIndexList;
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
