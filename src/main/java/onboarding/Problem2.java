package onboarding;

import java.util.HashSet;
import java.util.Set;

public class Problem2 {
    public static String solution(String cryptogram) {

        Set<Integer> set = new HashSet<>();
        boolean check = false;

        while (!check) {
            findingContinuousString(cryptogram, set);
            cryptogram = AfterRemovingContinuousString(cryptogram, set);

            check = checkSubString(set, check);
            set = new HashSet<>();
        }
        String answer = cryptogram;
        return answer;
    }

    /**
     * Function for checking whether there is subString
     * */
    private static boolean checkSubString(Set<Integer> set, boolean check) {
        if (set.isEmpty()) {
            check = true;
        }
        return check;
    }

    /**
     * Function for finding ContinuousString in String
     * */
    private static void findingContinuousString(String cryptogram, Set<Integer> set) {
        for (int idx = 0; idx < cryptogram.length(); idx++) {
            int l_idx = Math.max(0, idx-1);
            checkIndex(cryptogram, set, idx, l_idx);
        }
    }

    /**
     * Function for check Index
     * if index == 0 then left index = 0, therefore left index must not be index
     * */
    private static void checkIndex(String cryptogram, Set<Integer> set, int idx, int l_idx) {
        if ((l_idx != idx) && (cryptogram.charAt(idx) == cryptogram.charAt(l_idx))) {
            set.add(idx);
            set.add(l_idx);
        }
    }

    /**
     * Function for new_cryptogram Removed ContinuousString
     * */
    private static String AfterRemovingContinuousString(String cryptogram, Set<Integer> set) {
        String new_cryptogram = "";
        for (int idx = 0; idx < cryptogram.length(); idx++) {
            if (!set.contains(idx)) {
                new_cryptogram += cryptogram.charAt(idx);
            }
        }
        cryptogram = new_cryptogram;
        return cryptogram;
    }
}
