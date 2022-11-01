package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    static List<Integer> answerIndexes = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
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

        for (List<String> strings : forms) {
            form = strings;
            nicknames.add(form.get(1));
        }

        return nicknames;
    }

    public static boolean hasSimilarNickName(String nickname, String part) {
        return nickname.contains(part);
    }

    public static boolean isAlreadyAnswerIndexes(int index) {
        return answerIndexes.contains(index);
    }

}
