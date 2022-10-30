package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}

class OppositeAlphabet {
    private final List<Character> UpperLowerOfA = List.of("A".charAt(0), "a".charAt(0));

    private Map<String, String> createOppositeAlphabetMap() {
        Map<String, String> map = new HashMap<>();

        for (Character a :
                UpperLowerOfA) {
            int asciiOfStart = (int) a;
            int countOfAlphabet = 26;

            for (int i = 0; i < countOfAlphabet; i++) {
                String key = String.valueOf((char) (asciiOfStart + i));
                String value = String.valueOf((char) (asciiOfStart + (countOfAlphabet - i) - 1));
                map.put(key, value);
            }
        }

        return map;
    }
}