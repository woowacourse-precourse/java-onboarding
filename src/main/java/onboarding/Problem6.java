package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if (forms.size() == 1) {
            return onlyOnePeopleCheckRepeated(forms);
        }

        Set<String> set = new TreeSet<>();
        for (int i = 0; i < forms.size() - 1; i++) {
            String nickName = forms.get(i).get(1);
        }
        return new ArrayList<>(set);
    }

    private static List<String> onlyOnePeopleCheckRepeated(List<List<String>> forms) {
        String email = forms.get(0).get(0);
        String nickName = forms.get(0).get(1);
        if (checkRepeated(nickName)) {
            return List.of(email);
        }
        return Collections.emptyList();
    }

    private static boolean checkRepeated(String nickName) {
        if (nickName.length() <= 3) {
            return false;
        }
        for (int i = 0; i < nickName.length() - 2; i += 2) {
            if (nickName.substring(i, i + 2).equals(
                nickName.substring(i + 2, i + 4)
            )) {
                return true;
            }
        }
        return false;
    }
}
