package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static void checkDuplicatedNickname(List<List<String>> forms, int index, TreeSet<String> wrongNicknames) {
        List<String> member = forms.get(index);
        String nickname = member.get(1);
        for (int i = 0; i < nickname.length() - 1; i++) {
            String findName = nickname.substring(i, i + 2);
            for (int j = 0; j < forms.size(); j++) {
                if (j == index)
                    continue;
                List<String> checkMember = forms.get(j);
                String checkNickname = checkMember.get(1);
                if (checkNickname.contains(findName))
                    wrongNicknames.add(checkMember.get(0));
            }
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        TreeSet<String> wrongNicknames = new TreeSet<>();
        for (int index = 0; index < forms.size(); index++) {
            checkDuplicatedNickname(forms, index, wrongNicknames);
        }
        return new ArrayList<String>(wrongNicknames);
    }
}
