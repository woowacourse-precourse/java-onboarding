package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    static final int EMAIL = 0;
    static final int NICKNAME = 1;
    static HashMap<String, Integer> twoLetterCountMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> separatedNickname = new ArrayList<>();
        addSeperatedNicknameToList(forms, separatedNickname);
        countTwoLetters(separatedNickname);

        return new ArrayList<>();
    }


    private static void countTwoLetters(List<List<String>> separatedNickname) {
        for (List<String> crewSeparatedNickname : separatedNickname) {
            putListToMap(crewSeparatedNickname);
        }
    }

    private static void putListToMap(List<String> crewSeparatedNickname) {
        for (String twoLetters : crewSeparatedNickname) {
            twoLetterCountMap.put(twoLetters, twoLetterCountMap.getOrDefault(twoLetters, 0) + 1);
        }
    }

    private static void addSeperatedNicknameToList(List<List<String>> forms, List<List<String>> separatedNickname) {
        for (List<String> crew : forms) {
            List<String> temp = new ArrayList<>(getSeparateTwoConsecutiveLetters(crew.get(NICKNAME)));
            separatedNickname.add(temp);
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
