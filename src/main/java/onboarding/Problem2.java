package onboarding;

import java.util.HashSet;
import java.util.Set;

public class Problem2 {
    public static String solution(String cryptogram) {

        Set<Integer> set = new HashSet<>();

        findingContinuousString(cryptogram, set);

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
}
