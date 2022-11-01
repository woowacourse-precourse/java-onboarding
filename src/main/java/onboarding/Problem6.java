package onboarding;

import java.util.*;

public class Problem6 {
    public static boolean hasDuplicatePart(String nickname, String comparedNickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String partOfNickname = nickname.substring(i, i + 2);
            for (int j = 0; j < comparedNickname.length() - 1; j++) {
                String partOfComparedNickname = comparedNickname.substring(j, j + 2);
                if (partOfNickname.equals(partOfComparedNickname)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void removeDuplicateEmail(List<String> answer, String email, String comparedEmail) {
        if (!answer.contains(email)) {
            answer.add(email);
        }
        if (!answer.contains(comparedEmail)) {
            answer.add(comparedEmail);
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            for (int j = i + 1; j < forms.size(); j++) {
                String comparedEmail = forms.get(j).get(0);
                String comparedNickname = forms.get(j).get(1);

                if (hasDuplicatePart(nickname, comparedNickname)) {
                    removeDuplicateEmail(answer, email, comparedEmail);
                }
            }
        }
        return answer;
    }
}