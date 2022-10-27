package onboarding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        return answer;
    }
    private static boolean isDuplication(String[] array) {
        Set<String> set = new HashSet<>(Arrays.asList(array));
        return set.size() != array.length;
    }


}
