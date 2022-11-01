package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem6 {
    private static List<String> selectTwoLetters(String nickname) {
        List<String> twoLettersList = new LinkedList<>();
        for (int i = 0; i < nickname.length(); i++) {
            String twoLetters = nickname.substring(i-1, i+1);
            twoLettersList.add(twoLetters);
        }
        return twoLettersList;
    }
    private static boolean includeTwoLetters(String nickname, String twoLetters) {
        return nickname.contains(twoLetters);
    }
    private static boolean checkOverlap(String nicknameA, String nicknameB) {
        List<String> twoLettersList = selectTwoLetters(nicknameB);
        int twoLettersListSize = twoLettersList.size();
        int index = 0;
        boolean overlap = false;
        while (!overlap && index < twoLettersListSize) {
            String twoLetters = twoLettersList.get(index);
            overlap = includeTwoLetters(nicknameA, twoLetters);
            index++;
        }
        return overlap;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
