package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> validForms = new ArrayList<>();
        for (List<String> form : forms) {
            if (isValidForm(form)) validForms.add(form);
        }

        Set<String> answer = checkDuplicated(validForms);
        return new ArrayList<>(answer);
    }

    public static boolean isValidForm(List<String> form) {
        if (!isValidEmailForm(form.get(0))) return false;
        if (!isValidNicknameForm(form.get(1))) return false;
        return true;
    }

    public static boolean isValidEmailForm(String email) {
        String regex = "^[a-z_0-9]{1,9}(@email.com)$";
        return email.matches(regex);
    }

    public static boolean isValidNicknameForm(String nickname) {
        String regex = "^[ㄱ-ㅎㅏ-ㅣ가-힣]{1,19}$";
        return nickname.matches(regex);
    }

    public static Set<String> checkDuplicated(List<List<String>> validForms) {
        HashMap<String, String> map = new HashMap<>();
        TreeSet<String> set = new TreeSet<>();

        for (List<String> form : validForms) {
            for (int i=1; i<form.get(1).length(); i++) {
                if (map.containsKey(form.get(1).substring(i-1, i+1))) {
                    set.add(form.get(0));
                    set.add(map.get(form.get(1).substring(i-1, i+1)));
                }
                else map.put(form.get(1).substring(i-1, i+1), form.get(0));
            }
        }

        return set;
    }
}
