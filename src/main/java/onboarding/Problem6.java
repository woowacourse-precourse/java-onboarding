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
    private static void insertAnswer(List<String> answer, String email) {
        if (!answer.contains(email)) {
            answer.add(email);
        }
    }
    private static List<String> getForm(List<List<String>> forms, int index) {
        return forms.get(index);
    }
    private static String getEmail(List<List<String>> forms, int index) {
        List<String> form = getForm(forms, index);
        return form.get(0);
    }
    private static String getNickname(List<List<String>> forms, int index) {
        List<String> form = getForm(forms, index);
        return form.get(1);
    }
    private static int controlProcess(List<List<String>> forms, List<String> answer, int controlIndex, boolean deleteControlIndex) {
        if (deleteControlIndex) {
            String controlEmail = getEmail(forms, controlIndex);
            insertAnswer(answer, controlEmail);
            forms.remove(controlIndex);
            return 0;
        }
        return 1;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
