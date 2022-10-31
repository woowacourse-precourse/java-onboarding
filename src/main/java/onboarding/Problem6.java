package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if (forms.size() == 1) {
            return onlyOnePeopleCheckRepeated(forms.get(0));
        }

        Set<String> set = new TreeSet<>();
        for (int i = 0; i < forms.size() - 1; i++) {
            if (!validEmail(forms.get(i).get(0))) {
                continue;
            }
            String nickName = forms.get(i).get(1);
            findRepeatedNickname(forms, set, i, nickName);
        }
        return new ArrayList<>(set);
    }

    private static void findRepeatedNickname(List<List<String>> forms, Set<String> set, int i, String nickName) {
        for (int j = 1; j < forms.size(); j++) {
            if (!validEmail(forms.get(j).get(0))) {
                continue;
            }
            if (i == j) {
                continue;
            }
            for (int k = 0; k < nickName.length() - 2; k++) {
                String substring = nickName.substring(k, k + 2);
                if (forms.get(j).get(1).length() > 3) {
                    String substring1 = forms.get(j).get(1).substring(k, k + 2);
                    String substring2 = forms.get(j).get(1).substring(k + 2, k + 4);
                    if (substring1.equals(substring2)) {
                        set.add(forms.get(j).get(0));
                    }
                }
                if (forms.get(j).get(1).contains(substring)) {
                    set.add(forms.get(i).get(0));
                    set.add(forms.get(j).get(0));
                    break;
                }
            }
        }
    }

    private static List<String> onlyOnePeopleCheckRepeated(List<String> forms) {
        String email = forms.get(0);
        String nickName = forms.get(1);
        if (validEmail(email) && checkRepeated(nickName)) {
            return List.of(email);
        }
        return Collections.emptyList();
    }

    private static boolean validEmail(String email) {
        return email.endsWith("@email.com");
    }

    private static boolean checkRepeated(String nickName) {
        if (nickName.length() <= 3) {
            return false;
        }
        for (int i = 0; i < nickName.length() - 2; i++) {
            if (nickName.substring(i, i + 1).equals(
                nickName.substring(i + 1, i + 2)
            )) {
                return true;
            }
        }
        return false;
    }
}
