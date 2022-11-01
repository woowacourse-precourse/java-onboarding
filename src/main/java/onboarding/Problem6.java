package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        final List<String> ERROR = Collections.emptyList();
        if (violation(forms)) return ERROR;

        Map<String, Integer> countSubNickname = new HashMap<>();
        Set<String>[] currSet = new HashSet[forms.size()];
        setCountSubNickname(forms, countSubNickname, currSet);
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            if (duplicated(i, currSet, countSubNickname)) {
                answer.add(forms.get(i).get(0));
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    // 각 닉네임 조각(연속된 두글자)이 전체에서 몇번씩 나오는지 구하기
    static void setCountSubNickname(
            List<List<String>> forms, Map<String, Integer> countSubNickname, Set<String>[] currSet
    ) {
        for (int i = 0; i < forms.size(); i++) {
            currSet[i] = subNicknameSet(forms.get(i).get(1));
            for (String currSubNickname : currSet[i]) {
                int before = countSubNickname.getOrDefault(currSubNickname, 0);
                countSubNickname.put(currSubNickname, before + 1);
            }
        }
    }

    // 중복된 닉네임 조각이 있는지 체크
    static boolean duplicated(int i, Set<String>[] currSet, Map<String, Integer> countSubNickname) {
        for (String currSubNickname : currSet[i]) {
            if (countSubNickname.get(currSubNickname) > 1) {
                return true;
            }
        }
        return false;
    }

    // 잘못된 입력인지 체크
    static boolean violation(List<List<String>> forms) {
        if (forms.size() == 0 || forms.size() > 10000) return true;
        for (List<String> form : forms) {
            if (violationForm(form)) return true;
        }
        return false;
    }

    // 잘못된 폼인지 체크
    static boolean violationForm(List<String> form) {
        if (form.size() != 2) return true;
        String email = form.get(0);
        String nickname = form.get(1);
        return violationEmail(email) || violationNickname(nickname);
    }

    // 잘못된 이메일인지 체크
    static boolean violationEmail(String email) {
        if (email.length() <= 10 || email.length() >= 20) return true;
        if (!email.endsWith("@email.com")) return true;
        String id = email.substring(0, email.length() - 10);
        String regex = "^[a-zA-Z0-9]([-_.]?[0-9a-zA-Z])*$";
        return !Pattern.matches(regex, id);
    }

    // 잘못된 닉네임인지 체크
    static boolean violationNickname(String nickname) {
        if (nickname.length() == 0 || nickname.length() >= 20) return true;
        String regex = "^[ㄱ-ㅎㅏ-ㅣ가-힣]*$";
        return !Pattern.matches(regex, nickname);
    }

    // 각 닉네임의 연속한 두글자를 포함하는 집합
    static Set<String> subNicknameSet(String nickname) {
        Set<String> subNicknameSet = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            subNicknameSet.add(nickname.substring(i, i + 2));
        }
        return subNicknameSet;
    }
}
