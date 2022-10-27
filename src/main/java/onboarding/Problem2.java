package onboarding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem2 {

    public static final String SPECIFIC_VALUE = "-";

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        return answer;
    }
    private static boolean isDuplication(String[] array) {
        Set<String> set = new HashSet<>(Arrays.asList(array));
        return set.size() != array.length;
    }

    private static void convertSpecificValue(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            String firstString = array[i];
            String nextString = array[i + 1];

            if(firstString.equals(nextString)) {
                array[i] = SPECIFIC_VALUE;
                array[i + 1] = SPECIFIC_VALUE;
            }
        }
    }

}
