package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (true) {
            List<Integer> redundant_indexes = new ArrayList<Integer>();
            for (int i=0; i<cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    redundant_indexes.add(i);
                }
            }
            if (redundant_indexes.isEmpty()) break;
            redundant_indexes.add(cryptogram.length());

            int prev = 0;
            String temp = "";
            for (int i=0; i<redundant_indexes.size(); i++){
                temp += cryptogram.substring(prev, redundant_indexes.get(i));
                prev = redundant_indexes.get(i)+2;
            }
            cryptogram = temp;
        }

        return cryptogram;
    }

}
