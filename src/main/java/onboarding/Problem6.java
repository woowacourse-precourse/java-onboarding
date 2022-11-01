package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class Problem6 {
    public static boolean checkEmail(List<List<String>> forms, int index) {
        List<String> member = forms.get(index);
        String email = member.get(0);
        if (email.length() < 11 || email.length() > 19)
            return false;
        String[] emailSplit = email.split("@");
        if (emailSplit.length != 2)
            return false;
        String domain = emailSplit[1];
        if (!(Objects.equals(domain, "email.com")))
            return false;
        return true;
    }
    public static void checkDuplicatedNickname(List<List<String>> forms, int index, TreeSet<String> wrongNicknames) {
        List<String> member = forms.get(index);
        String nickname = member.get(1);
        for (int i = 0; i < nickname.length() - 1; i++) {
            String findName = nickname.substring(i, i + 2);
            for (int j = 0; j < forms.size(); j++) {
                List<String> checkMember = forms.get(j);
                if (j == index || wrongNicknames.contains(checkMember.get(0)))
                    continue;
                else if (!checkEmail(forms, j))
                    continue;
                String checkNickname = checkMember.get(1);
                if (checkNickname.contains(findName))
                    wrongNicknames.add(checkMember.get(0));
            }
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        if (forms.size() < 1 || forms.size() > 10000)
            return new ArrayList<>();
        TreeSet<String> wrongNicknames = new TreeSet<>();
        for (int index = 0; index < forms.size(); index++) {
            checkDuplicatedNickname(forms, index, wrongNicknames);
        }
        return new ArrayList<String>(wrongNicknames);
    }
}
