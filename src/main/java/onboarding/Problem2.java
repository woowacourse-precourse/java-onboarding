package onboarding;

import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static void initList(String cryptogram, List<Character> characterList) {
        for (char ch : cryptogram.toCharArray()) {
            characterList.add(ch);
        }
    }

    private static boolean isAnyRemovable(List<Character> characterList) {
        return false;
    }

    private static void deduplicate(List<Character> characterList, boolean flag) {

    }

    private String charListToString(List<Character> characterList) {
        return null;
    }
}
