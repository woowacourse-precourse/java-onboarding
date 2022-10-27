package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        List<Integer> duplicateIndex = new ArrayList<>();

        String DeleteDuplicate;

        for(int i = 0; i < cryptogram.length() - 1; i++){
            String nowString = cryptogram.substring(i, i + 1);
            String nextString = cryptogram.substring(i + 1, i + 2);

            if (nowString.equals(nextString)) {
                duplicateIndex.add(i);
                duplicateIndex.add(i + 1);
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(cryptogram);

        int forCount = 0;

        for (Integer duplicateIndexNum : duplicateIndex) {
            sb.deleteCharAt(duplicateIndexNum - forCount);
            forCount++;
        }

        System.out.println("sb = " + sb);

        return "";
    }

    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon";

        String solution = solution(cryptogram);
    }
}


