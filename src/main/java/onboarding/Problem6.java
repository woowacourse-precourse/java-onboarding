package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
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
                for (int k = 0; k < nicknames.size(); k++) {
                    if (k != i) {
                        if (hasSimilarNickName(nicknames.get(k), part)) {
                            if (!isAlreadyAnswerIndexes(answerIndexes, i)) {
                                answerIndexes.add(i);
                            }
                            if (!isAlreadyAnswerIndexes(answerIndexes, k)) {
                                answerIndexes.add(k);
                            }
                        }
                    }
                }
            }
        }
        makeAnswer(forms, answer, answerIndexes);
        Collections.sort(answer);
        return answer;
    }
    public static void makeAnswer(List<List<String>> forms, List<String> answer, List<Integer> answerIndexes) {
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

    public static boolean isAlreadyAnswerIndexes(List<Integer> answerIndexes, int index) {
        if (answerIndexes.contains(index)) {
            return true;
        }
        return false;
    }

}
