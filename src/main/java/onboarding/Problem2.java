package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static List<Integer> duplicatedIndexList;
    public static StringBuilder sb;

    public static String solution(String cryptogram) {
        sb = new StringBuilder();
        initDuplicatedIndexList(cryptogram);
        return getCryptogram(cryptogram);
    }

    public static String getCryptogram(String cryptogram) {
        while (duplicatedIndexList.size() > 0) {
            cryptogram = createNewCryptogram(cryptogram);
            addDuplicatedIndex(cryptogram);
        }
        return cryptogram;
    }

    public static void initDuplicatedIndexList(String cryptogram) {
        duplicatedIndexList = new ArrayList<>();
        addDuplicatedIndex(cryptogram);
    }

    public static void addDuplicatedIndex(String cryptogram) {
        clearDuplicatedIndexList();
        char first, second;
        for (int index = 0; index < cryptogram.length() - 1; index++) {
            first = cryptogram.charAt(index);
            second = cryptogram.charAt(index + 1);
            if (first == second) {
                duplicatedIndexList.add(index);
                duplicatedIndexList.add(index + 1);
            }
        }
    }

    public static String createNewCryptogram(String cryptogram) {
        clearStringBuilder();

        for (int index = 0; index < cryptogram.length(); index++) {
            if (duplicatedIndexList.contains(index)) {
                continue;
            }
            sb.append(cryptogram.charAt(index));
        }
        return sb.toString();
    }

    public static void clearStringBuilder() {
        sb.setLength(0);
    }

    public static void clearDuplicatedIndexList() {
        duplicatedIndexList.clear();
    }
}
