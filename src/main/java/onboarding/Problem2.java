package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        return deleteDuplicatedLetter(cryptogram);
    }

    private static String deleteDuplicatedLetter(String cryptogram) {
        if (cryptogram.length() == 0) {
            return cryptogram;
        }

        char pre = cryptogram.charAt(0);

        List<Integer> duplicated = new ArrayList<>();

        boolean isDuplicated = false;
        for (int i = 1; i < cryptogram.length(); i++) {
            char now = cryptogram.charAt(i);
            if (pre == now) {
                duplicated.add(i - 1);
                duplicated.add(i);
                isDuplicated = true;
            }
            pre = now;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i <cryptogram.length(); i++) {
            if (!duplicated.contains(i)) {
                sb.append(cryptogram.charAt(i));
            }
        }

        if (!isDuplicated) {
            return sb.toString();
        }

        return deleteDuplicatedLetter(sb.toString());
    }
}
