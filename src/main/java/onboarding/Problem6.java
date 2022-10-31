package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if (!validation(forms)) {
            return Collections.emptyList();
        }
        boolean[] duplicate = new boolean[forms.size()];
        Set<String> totalSubNickNameSet = new HashSet<>();
        Set<String> subNickNameSetFrom2 = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            int currTotalSize = totalSubNickNameSet.size();
            int currSize = forms.get(i).get(1).length() -1;
            totalSubNickNameSet.addAll(subNicknameSet(forms.get(i).get(1)));
            duplicate[i] = (totalSubNickNameSet.size() - currTotalSize) < currSize;
            subNickNameSetFrom2.addAll(subNicknameSet(forms.get(i).get(1)));
        }
        duplicate[0] = (totalSubNickNameSet.size() - subNickNameSetFrom2.size()) < (forms.get(0).get(1).length() - 1);
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            if (duplicate[i]) {
                answer.add(forms.get(i).get(0));
            }
        }
        answer.sort((Comparator.naturalOrder()));
        return answer;
    }

    static boolean validation(List<List<String>> forms) {
        if (forms.size() == 0 || forms.size() > 10000) {
            return false;
        }
        for (List<String> form : forms) {
            if (!validationForm(form)) {
                return false;
            }
        }
        return true;
    }

    static boolean validationForm(List<String> form) {
        if (form.size() != 2) return false;
        String email = form.get(0);
        String nickname = form.get(1);
        return validationEmail(email) && validationNickname(nickname);
    }

    static boolean validationEmail(String email) {
        if (email.length() <= 10 || email.length() >= 20) return false;
        if (!email.endsWith("@email.com")) return false;
        String id = email.substring(0, email.length() - 10);
        String regex = "^[a-zA-Z0-9]([-_.]?[0-9a-zA-Z])*$";
        return Pattern.matches(regex, id);
    }

    static boolean validationNickname(String nickname) {
        if (nickname.length() == 0 || nickname.length() >= 20) return false;
        String regex = "^[ㄱ-ㅎ가-힣]*$";
        return Pattern.matches(regex, nickname);
    }

    static Set<String> subNicknameSet(String nickname) {
        Set<String> subNicknameSet = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            subNicknameSet.add(nickname.substring(i, i + 2));
        }
        return subNicknameSet;
    }
}