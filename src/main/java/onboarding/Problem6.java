package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<List<String>> forms;

    public static List<String> solution(List<List<String>> forms) {
        Problem6.forms = forms;
        return sortEmail(compareNickname(saveTwoWord()));
    }

    // 두 글자씩 twoWord에 저장
    public static List<String> saveTwoWord() {
        List<String> twoWords = new ArrayList<>();
        for (List<String> form : forms) {
            for (int j = 0; j <= form.get(1).length() - 2; j++) {
                twoWords.add(form.get(1).substring(j, j + 2));
            }
        }
        return twoWords;
    }

    // twoWord와 닉네임 비교 후 중복된 닉네임의 이메일을 answer에 저장
    public static List<String> compareNickname(List<String> twoWords) {
        List<String> answer = new ArrayList<>();
        for (String twoWord : twoWords) {
            List<Integer> countOverlap = new ArrayList<>();
            for (int i = 0; i < forms.size(); i++) {
                if (forms.get(i).get(1).contains(twoWord)) {
                    countOverlap.add(forms.indexOf(forms.get(i)));
                }
            }
            if (countOverlap.size() > 1) {
                for (int i : countOverlap) {
                    answer.add(forms.get(i).get(0));
                }
            }
        }
        return answer;
    }

    // 이메일 오름차순 정렬 및 중복제거
    public static List<String> sortEmail(List<String> answer) {
        TreeSet<String> tempAnswer = new TreeSet<>(answer);
        answer = new ArrayList<>(tempAnswer);
        return answer;
    }
}