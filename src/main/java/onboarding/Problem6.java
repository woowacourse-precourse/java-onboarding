package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        final List<String> ERROR = Collections.emptyList();
        if (violation(forms)) return ERROR;

        Map<String, Integer> countSubNickname = new HashMap<>();
        Set<String>[] currSet = new HashSet[forms.size()];
        for (int i = 0; i < forms.size(); i++) {
            currSet[i] = subNicknameSet(forms.get(i).get(1));
            for (String currSubNickname : currSet[i]) {
                int before = countSubNickname.getOrDefault(currSubNickname, 0);
                countSubNickname.put(currSubNickname, before + 1);
            }
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            if (duplicated(i, currSet, countSubNickname)) {
                answer.add(forms.get(i).get(0));
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    static boolean duplicated(int i, Set<String>[] currSet, Map<String, Integer> countSubNickname) {
        for (String currSubNickname : currSet[i]) {
            if (countSubNickname.get(currSubNickname) > 1) {
                return true;
            }
        }
        return false;
    }

    static boolean violation(List<List<String>> forms) {
        if (forms.size() == 0 || forms.size() > 10000) return true;
        for (List<String> form : forms) {
            if (violationForm(form)) return true;
        }
        return false;
    }

    static boolean violationForm(List<String> form) {
        if (form.size() != 2) return true;
        String email = form.get(0);
        String nickname = form.get(1);
        return violationEmail(email) || violationNickname(nickname);
    }

    static boolean violationEmail(String email) {
        if (email.length() <= 10 || email.length() >= 20) return true;
        if (!email.endsWith("@email.com")) return true;
        String id = email.substring(0, email.length() - 10);
        String regex = "^[a-zA-Z0-9]([-_.]?[0-9a-zA-Z])*$";
        return !Pattern.matches(regex, id);
    }

    static boolean violationNickname(String nickname) {
        if (nickname.length() == 0 || nickname.length() >= 20) return true;
        String regex = "^[ㄱ-ㅎㅏ-ㅣ가-힣]*$";
        return !Pattern.matches(regex, nickname);
    }

    static Set<String> subNicknameSet(String nickname) {
        Set<String> subNicknameSet = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            subNicknameSet.add(nickname.substring(i, i + 2));
        }
        return subNicknameSet;
    }
}
