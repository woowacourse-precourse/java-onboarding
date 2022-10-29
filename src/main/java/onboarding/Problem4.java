package onboarding;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        HashMap<Integer, Integer> alphabetMap = new HashMap<>();
        for (int i = 0; i < 'Z' - 'A'; i++) {
            alphabetMap.put('a' + i, 'z' - i);
            alphabetMap.put('A' + i, 'Z' - i);
        }

        return word.chars()
                .map(c -> alphabetMap.getOrDefault(c, c))
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }
}
