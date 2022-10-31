package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashSet<String> dup = new HashSet<>();
        for (int i = 0; i < forms.size(); ++i) {
            String nickname = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            // skip if already in the set
            if (dup.contains(email))
                continue;
            // for each word of length 2, ex '제이'
            for (int j = 0; j < nickname.length() - 1; ++j) {
                String match = nickname.substring(j, j + 2);
                // loop through remaining names
                for (int k = i + 1; k < forms.size(); ++k) {
                    String cmp_nickname = forms.get(k).get(1);
                    String cmp_email = forms.get(k).get(0);
                    // skip if already in the set
                    if (dup.contains(cmp_email))
                        continue;
                    // compare with word of length 2 of other user's nickname
                    for (int l = 0; l < cmp_nickname.length() - 1; ++l) {
                        if (match.equals(cmp_nickname.substring(l, l + 2))) {
                            dup.add(email);
                            dup.add(cmp_email);
                            break;
                        }
                    }
                }
            }
        }
        List<String> answer = new ArrayList<>(dup);
        answer.sort(String::compareTo);

        return answer;
    }
}
