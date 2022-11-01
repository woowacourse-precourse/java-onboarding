package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    static List<Integer> answerIndexes = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Integer> answerIndexes = new ArrayList<>();
        List<String> nicknames = getNickNameList(forms);
        String current;
        String part;

        for (int i = 0; i < nicknames.size(); i++) {
            current = nicknames.get(i);
            for (int j = 0; j < current.length() - 1; j++) {
                part = current.substring(j, j + 2);
                getAnswerWithPart(nicknames, part, i);
            }
        }

        makeAnswer(forms, answer);
        Collections.sort(answer);
        return answer;
    }

    private static void getAnswerWithPart(List<String> nicknames, String part, int i) {
        for (int k = 0; k < nicknames.size(); k++) {
            if (k != i) {
                if (hasSimilarNickName(nicknames.get(k), part)) {
                    if (!isAlreadyAnswerIndexes(i)) {
                        answerIndexes.add(i);
                    }
                    if (!isAlreadyAnswerIndexes(k)) {
                        answerIndexes.add(k);
                    }
                }
            }
        }
    }

    public static void makeAnswer(List<List<String>> forms, List<String> answer) {
        List<String> form;
        String email;

        for (int i : answerIndexes) {
            form = forms.get(i);
            email = form.get(0);
            answer.add(email);
        }
    }

    public static List<String> getNickNameList(List<List<String>> forms) {
        List<String> nicknames = new ArrayList<>();
        List<String> form;

        for (int i = 0; i < forms.size(); i++) {
            form = forms.get(i);
            nicknames.add(form.get(1));
        }

        return nicknames;
    }

    public static boolean hasSimilarNickName(String nickname, String part) {
        if (nickname.contains(part)) {
            return true;
        }
        return false;
    }

    public static boolean isAlreadyAnswerIndexes(int index) {
        if (answerIndexes.contains(index)) {
            return true;
        }
        return false;
    }

}
