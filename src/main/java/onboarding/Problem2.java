package onboarding;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<Integer> successiveIndexArrayList = getSuccessiveIndexArrayList(cryptogram);

        String deletedSuccessiveStr = cryptogram;
        while (successiveIndexArrayList.size() != 0) {
            deletedSuccessiveStr = deleteSuccessiveStr(deletedSuccessiveStr, successiveIndexArrayList);
            successiveIndexArrayList = getSuccessiveIndexArrayList(deletedSuccessiveStr);
        }

        return deletedSuccessiveStr;
    }

    private static String deleteSuccessiveStr(String str, ArrayList<Integer> successiveIndexArrayList) {
        StringBuilder sb = new StringBuilder(str);

        for (int i = successiveIndexArrayList.size() - 1; i >= 0; i--) {
            sb.deleteCharAt(successiveIndexArrayList.get(i));
        }

        return sb.toString();
    }

    private static ArrayList<Integer> getSuccessiveIndexArrayList(String str) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                arrayList.add(i);
                arrayList.add(i + 1);
            }
        }

        return new ArrayList<>(new HashSet<>(arrayList));
    }
}
