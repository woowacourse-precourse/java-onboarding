package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    private static int totalCrewNumber;
    private static List<String> nicknames;
    private static List<String> emails;

    public static List<String> solution(List<List<String>> forms) {
        initVariables(forms);

        return findDuplicatedCrewEmails().stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
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
        int[][] lcs = new int[totalCrewNumber + 1][totalCrewNumber + 1];
        int duplicatedLength = Integer.MIN_VALUE;

        for (int oriIdx = 0; oriIdx <= ori.length(); oriIdx++) {
            for (int cmpIdx = 0; cmpIdx <= cmp.length(); cmpIdx++) {
                if (oriIdx == 0 || cmpIdx == 0) {
                    lcs[oriIdx][cmpIdx] = 0;
                } else if (ori.charAt(oriIdx - 1) == cmp.charAt(cmpIdx - 1)) {
                    lcs[oriIdx][cmpIdx] = lcs[oriIdx - 1][cmpIdx - 1] + 1;
                    duplicatedLength = Math.max(duplicatedLength, lcs[oriIdx][cmpIdx]);
                }
            }
        }

        return duplicatedLength >= 2;
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
