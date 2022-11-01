package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> set = new HashSet<String>();
        Problem6 problem = new Problem6();
        List<String> emails = forms.stream().map(x -> x.get(0)).collect(Collectors.toList());
        List<String> usernames = forms.stream().map(x -> x.get(1)).collect(Collectors.toList());
        int headCount = forms.size();


        for (int i = 0; i < headCount; i++) {
            for (int j = i + 1; j < headCount; j++) {
                boolean isExits = problem.findCommonSubStringExists(usernames.get(i), usernames.get(j));
                if(isExits) {
                    set.add(emails.get(i));
                    set.add(emails.get(j));
                }
            }
        }

        return set.stream().sorted().collect(Collectors.toList());
    }

    public boolean findCommonSubStringExists (String str1, String str2) {
        int length = str1.length();

        // 둘 다 한글자인데 같은 경우
        if (str1.length() * str2.length() == 1) {
            return str1 == str2;
        }

        // 연속된 두 글자끼리 같은지만 체크 (어차피 그 이상 같아봤자 결과값은 같음)
        for (int i = 0; i < length - 1; i++) {
            String stem = str1.substring(i, i + 2);
            if (str2.contains(stem)) {
                return true;
            }
        }
        return false;
    }
}
