package onboarding;

import java.util.HashSet;
import java.util.Set;

public class Problem2 {
    public static String solution(String cryptogram) {

        Set<Integer> set = new HashSet<>();

        findingContinuousString(cryptogram, set);

        cryptogram = AfterRemovingContinuousString(cryptogram, set);

        String answer = "answer";
        return answer;
    }

    /**
     * Function for finding ContinuousString in String
     * */
    private static void findingContinuousString(String cryptogram, Set<Integer> set) {
        for (int idx = 0; idx < cryptogram.length(); idx++) {
            int l_idx = Math.max(0, idx-1);
            int r_idx = Math.min(cryptogram.length()-1,idx+1);

            if ((l_idx != idx) && (cryptogram.charAt(idx) == cryptogram.charAt(l_idx))) {
                set.add(idx);
                set.add(l_idx);
            }

            if ((r_idx != idx) && (cryptogram.charAt(idx) == cryptogram.charAt(r_idx))) {
                set.add(idx);
                set.add(r_idx);
            }
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
