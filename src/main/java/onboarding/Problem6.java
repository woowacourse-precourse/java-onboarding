package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static String sliceNickname(String nickname, int idx) {
        return nickname.substring(idx, idx+2);
    }

    public static HashSet<String> chckDuplicates(List<String> userForm, List<List<String>> forms) {
        HashSet<String> dupMailSet = new HashSet<>();

        String userMail = userForm.get(0);
        String userNickname = userForm.get(1);

        for(int i = 0; i < userNickname.length() - 1; i++) {
            String subNickname = sliceNickname(userNickname, i);

            for(int j = 0; j < forms.size(); j++) {
                List<String> otherForm = forms.get(j);
                String otherMail = otherForm.get(0);
                String otherNickname = otherForm.get(1);

                if (otherNickname.contains(subNickname) && !otherMail.equals(userMail)) {
                    dupMailSet.add(otherMail);
                }
            }
        }
        return dupMailSet;
    }

    public static List<String> getDupUsers(List<List<String>> forms) {
        HashSet<String> dupUserSet = new HashSet<>();

        for(List<String> form: forms) {
            HashSet<String> dupMailSet = chckDuplicates(form, forms);
            System.out.println(dupMailSet.toString());
            dupUserSet.addAll(dupMailSet);
        }

        List<String> dupUserList = new ArrayList<>(dupUserSet);
        Collections.sort(dupUserList);

        return dupUserList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        answer = getDupUsers(forms);

        return answer;
    }
}
