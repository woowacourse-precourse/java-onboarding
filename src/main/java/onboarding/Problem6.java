package onboarding;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Problem6 {
    private static List<String> selectTwoLetters(String nickname) {
        List<String> twoLettersList = new LinkedList<>();
        for (int i = 1; i < nickname.length(); i++) {
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
    private static int compareProcess(List<List<String>> forms, List<String> answer, int controlIndex, int compareIndex) {
        String controlNickname = getNickname(forms, controlIndex);
        String compareNickname = getNickname(forms, compareIndex);
        if (checkOverlap(controlNickname, compareNickname)) {
            String compareEmail = getEmail(forms, compareIndex);
            insertAnswer(answer, compareEmail);
            forms.remove(compareIndex);
            return 0;
        }
        return 1;
    }
    private static boolean checkDeleteControlIndex(boolean deleteControlIndex, int result) {
        return deleteControlIndex || result == 0;
    }
    private static boolean compareLoop(List<List<String>> forms, List<String> answer, int controlIndex, int compareIndex) {
        boolean deleteControlIndex = false;
        while (compareIndex < forms.size()) {
            int result = compareProcess(forms, answer, controlIndex, compareIndex);
            deleteControlIndex = checkDeleteControlIndex(deleteControlIndex, result);
            compareIndex += result;
        }
        return deleteControlIndex;
    }
    private static void controlLoop(List<List<String>> forms, List<String> answer) {
        int controlIndex = 0;
        while (controlIndex < forms.size()) {
            int compareIndex = controlIndex + 1;
            boolean deleteControlIndex = compareLoop(forms, answer, controlIndex, compareIndex);
            int result = controlProcess(forms, answer, controlIndex, deleteControlIndex);
            controlIndex += result;
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> forms2 = new LinkedList<>(forms);
        List<String> answer = new LinkedList<>();
        controlLoop(forms2, answer);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
