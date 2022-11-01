package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<Character> charList = cryptogram.chars()
                .mapToObj(e -> (char) e).collect(Collectors.toList());

        for (int i = charList.size(); i > 1; i--) {
            for (int j = charList.size() - 1; j > 0; j--) {
                if (charList.get(j) == charList.get(j - 1)) {
                    charList.remove(j - 1);
                    charList.remove(j - 1);
                }
            }
        }

        return charList.toString();
    }

}
