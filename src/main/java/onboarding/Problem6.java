package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        // Using "set" that doesn't allow duplication
        Set<String> set = new HashSet<>();

        // Do loop all the email & nickname list
        for(int i = 0; i < forms.size(); ++i) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            // Do loop with 2 letters set
            for (int j = 0; j < nickname.length() - 2; j++) {
                String s = nickname.substring(j, j + 2);

                // Do loop with elements that have not passed yet
                for(int k = (i+1); k < forms.size(); ++k) {
                    String nextEmail = forms.get(k).get(0);
                    String nextNickname = forms.get(k).get(1);

                    // Do add to the answer set if duplication occurs
                    if( nextNickname.contains(s) ) {
                        set.add(email);
                        set.add(nextEmail);
                    }
                }
            }
        }

        List<String> answer = new ArrayList<>(set);
        // Using Collections that doesn't allow modification
        Collections.sort(answer);

        return answer;
    }
}
