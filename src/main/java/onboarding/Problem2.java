package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {

        ArrayList<Integer> duplicates = findDuplicates(cryptogram);

        if (duplicates.size() == 0) {
            return cryptogram;
        }

        String tmp = removeDuplicates(cryptogram, duplicates);

        return solution(tmp);
    }

    private static ArrayList<Integer> findDuplicates(String cryptogram) {
        ArrayList<Integer> duplicates = new ArrayList<>();

        boolean currentPattern = false;

        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i-1) && !currentPattern) {
                duplicates.add(i-1);
                currentPattern = true;
            }
            else if (currentPattern && cryptogram.charAt(i) != cryptogram.charAt(i-1))
            {
                duplicates.add(i-1);
                currentPattern = false;
            }

            if (currentPattern && i == cryptogram.length() - 1) {
                duplicates.add(i);
            }
        }

        return duplicates;
    }

    private static String removeDuplicates(String cryptogram, ArrayList<Integer> duplicates) {
        String tmp = "";
        int start = 0;

        for (int i = 0; i < duplicates.size() ; i++) {
            if (start == 0 && i % 2 == 0)
            {
              tmp += cryptogram.substring(start, duplicates.get(i)) ;
            }
            else if (i % 2 == 0 && duplicates.get(i) - start != 1)
            {
                tmp += cryptogram.substring(start , duplicates.get(i));
            }
            else
            {
                start = duplicates.get(i);
            }

            if (i == duplicates.size() -1) {
                tmp += cryptogram.substring(start + 1);
            }
        }

        return tmp;
    }
}
