package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * !중복 문자는 세글자만 비교해도 된다. 세글자든, 두글자든 모두 똑같이 중복
 * 1. 순회하며 2글자씩 읽어 일치하는 항목이 있을 시 해당 원소를 answer에 넣는다.
 */
public class Problem6 {
    private static List<String> dupEmails = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {

        for (int i = 0; i < forms.size(); i++) {
            boolean flag = false;
            String name = forms.get(i).get(1);

            for (int j = 1; j < name.length(); j++) {
                String target = name.substring(j - 1, j + 1);

                flag = duplicateFilter(forms, i, flag, target);
            }

            if (flag && !dupEmails.contains(forms.get(i).get(0))) {
                dupEmails.add(forms.get(i).get(0));
            }
        }

        Collections.sort(dupEmails);

        return dupEmails;
    }

    private static boolean duplicateFilter(List<List<String>> forms, int cur, boolean flag, String target) {
        for (int k = cur + 1; k < forms.size(); k++) {
            boolean isDuplicateName = forms.get(k).get(1).contains(target);

            if (isDuplicateName) {
                flag = true;
                String email = forms.get(k).get(0);
                boolean isNotRegistered = !dupEmails.contains(email);

                if (isNotRegistered) dupEmails.add(email);
            }
        }

        return flag;
    }
}
