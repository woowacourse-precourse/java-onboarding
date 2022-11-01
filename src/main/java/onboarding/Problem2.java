package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decode(cryptogram);
        return answer;
    }

    public static String decode (String cryptogram) {
        char[] chars = cryptogram.toCharArray();

        String decoded = "";
        char prev = ' ';

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != prev) {
                decoded += chars[i];
                prev = chars[i];
            } else {
                decoded = decoded.substring(0, decoded.length() - 1);
                prev = (decoded.length() > 0) ? decoded.charAt(decoded.length() - 1) : ' ';
            }
        }
        return decoded;
    }

}
