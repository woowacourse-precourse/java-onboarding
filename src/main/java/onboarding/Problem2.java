package onboarding;

import java.util.LinkedHashSet;
import java.util.Set;

public class Problem2 {
    public static String solution(String cryptogram) {
        return deleteContinuousDuplicated(cryptogram);
    }

    public static String deleteContinuousDuplicated(String cryptogram) {
        if (cryptogram.length() == 0) {
            return cryptogram;
        }

        char previous = cryptogram.charAt(0);
        char now;

        Set<Integer> set = new LinkedHashSet<>();

        boolean isDuplicated = false;
        for (int i = 1; i < cryptogram.length(); i++) {
            now = cryptogram.charAt(i);
            if (previous == now) {
                set.add(i);
                set.add(i - 1);
                isDuplicated = true;
            }
            previous = now;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!set.contains(i)) {
                stringBuilder.append(cryptogram.charAt(i));
            }
        }

        if(!isDuplicated) {
            return stringBuilder.toString();
        }
        return deleteContinuousDuplicated(stringBuilder.toString());
    }
}
