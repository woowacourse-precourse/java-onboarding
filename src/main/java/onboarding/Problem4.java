package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        List<Character> characterList = word.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        List<Integer> convertAscii = characterList.stream().map(x -> {
            int rawCharAscii = (int) x;
            if (rawCharAscii >= 65 && rawCharAscii <= 90) {
                return 155 - rawCharAscii;
            } else if (rawCharAscii < 97 || rawCharAscii > 122) {
                return rawCharAscii;
            } else {
                return 219 - rawCharAscii;
            }
        }).collect(Collectors.toList());

        return "abc";
    }
}
