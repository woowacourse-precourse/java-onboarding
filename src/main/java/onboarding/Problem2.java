package onboarding;

import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        boolean repeat = true;
        while (repeat && !Objects.equals(cryptogram, "")) {
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                repeat = false;
                if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);
                    repeat = true;
                    break;
                }
            }
        }
        answer = cryptogram;
        return answer;
    }
}
