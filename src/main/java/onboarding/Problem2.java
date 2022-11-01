package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (true) {
            List<Integer> duplicate_indexes = new ArrayList<Integer>();
            for (int i=0; i<cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    duplicate_indexes.add(i);
                }
            }
            if (duplicate_indexes.isEmpty()) break;
            duplicate_indexes.add(cryptogram.length());

            int prev = 0;
            String temp = "";
            for (int i=0; i<duplicate_indexes.size(); i++){
                temp += cryptogram.substring(prev, duplicate_indexes.get(i));
                prev = duplicate_indexes.get(i)+2;
            }
            cryptogram = temp;
        }

        return cryptogram;
    }

}