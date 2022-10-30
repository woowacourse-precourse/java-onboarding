package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    static final int EMAIL = 0;
    static final int NICKNAME = 1;
    static HashMap<String, Integer> twoLetterCountMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> separatedNickname = new ArrayList<>();
        for (List<String> crew : forms) {
            separatedNickname.addAll(getSeparateTwoConsecutiveLetters(crew.get(NICKNAME)));
        }
        countTwoLetters(separatedNickname);

        return new ArrayList<>();
    }

    private static void countTwoLetters(List<String> separatedNickname) {
        for (String twoLetters : separatedNickname) {
            twoLetterCountMap.put(twoLetters, twoLetterCountMap.getOrDefault(twoLetters, 0) + 1);
        }
    }

    private static List<String> getSeparateTwoConsecutiveLetters(String nickname) {
        List<String> separatedNickname = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetters = nickname.substring(i, i + 2);
            separatedNickname.add(twoLetters);
        }
        return separatedNickname;
    }
}
