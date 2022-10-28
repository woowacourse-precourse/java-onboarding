package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    private static int totalCrewNumber;
    private static List<String> nicknames;
    private static List<String> emails;

    public static List<String> solution(List<List<String>> forms) {
        initVariables(forms);

        return null;
    }

    private static Set<String> findDuplicatedCrewEmails() {
        Set<String> ret = new HashSet<>();
        for (int oriCrewNum = 0; oriCrewNum < totalCrewNumber; oriCrewNum++) {
            String ori = nicknames.get(oriCrewNum);

            for (int cmpCrewNum = oriCrewNum + 1; cmpCrewNum < totalCrewNumber; cmpCrewNum++) {
                if (isDuplicated(ori, nicknames.get(cmpCrewNum))) {
                    ret.add(emails.get(oriCrewNum));
                    ret.add(emails.get(cmpCrewNum));
                }
            }
        }

        return ret;
    }

    private static boolean isDuplicated(String ori, String cmp) {
        return true;
    }

    private static void initVariables(List<List<String>> forms) {
        totalCrewNumber = forms.size();
        nicknames = new ArrayList<>();
        emails = new ArrayList<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            emails.add(email);
            nicknames.add(nickname);
        }
    }
}
