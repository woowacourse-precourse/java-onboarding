package onboarding;

import org.mockito.internal.matchers.Null;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static String sliceNickname(String nickname, int idx) {
        return nickname.substring(idx, idx+2);
    }

    public static boolean isDuplicate(List<String> userForm, List<String> otherForm) {
        String userMail = userForm.get(0);
        String userNickname = userForm.get(1);
        String otherMail = otherForm.get(0);
        String otherNickname = otherForm.get(1);

        if(otherMail.equals(userMail)) {
            return false;
        }

        for(int i = 0; i < userNickname.length() - 1; i++) {
            String subNickname = sliceNickname(userNickname, i);
            if(otherNickname.contains(subNickname)) {
                return true;
            }
        }
        return false;
    }
    public static HashSet<String> getDupUserMail(List<String> userForm, List<List<String>> forms) {
        HashSet<String> dupUserMailSet = new HashSet<>();

        for(int i = 0; i < forms.size(); i++) {
            List<String> otherForm = forms.get(i);
            if(isDuplicate(userForm, otherForm)) {
                String dupUserMail = otherForm.get(0);

                dupUserMailSet.add(dupUserMail);
            }
        }
        return dupUserMailSet;
    }

    public static List<String> getDupResult(List<List<String>> forms) {
        HashSet<String> dupResult = new HashSet<>();

        for(List<String> form: forms) {
            HashSet<String> dupUserMailSet = getDupUserMail(form, forms);

            dupResult.addAll(dupUserMailSet);
        }

        List<String> dupUserList = new ArrayList<>(dupResult);
        Collections.sort(dupUserList);

        return dupUserList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        answer = getDupResult(forms);

        return answer;
    }
}
