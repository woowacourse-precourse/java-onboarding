package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emailSet = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                String twoLettersOfNickname = nickname.substring(j, j + 2);

                for (int k = 0; k < forms.size(); k++) {
                    if (i != k) {
                        if (forms.get(k).get(1).contains(twoLettersOfNickname)) {
                            emailSet.add(forms.get(k).get(0));
                        }
                    }
                }
            }
        }

        List<String> emailList = new ArrayList<>(emailSet);
        Collections.sort(emailList);
        return emailList;
    }
}

