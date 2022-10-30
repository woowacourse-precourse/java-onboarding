package onboarding;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
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
