package onboarding;

import java.util.Set;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean isDuplicate = false;
        while (!isDuplicate && cryptogram.length() > 0){
            String orgCryptogram = cryptogram;
            Set<Character> charSet = cryptogram.chars()
                    .mapToObj(c -> (char)c).collect(Collectors.toSet());
            for (char x : charSet) {
                String pattern = x + "{2,}";
                cryptogram = cryptogram.replaceAll(pattern, "");
            }
            isDuplicate = orgCryptogram.equals(cryptogram);
        }

        return cryptogram;
    }
}
