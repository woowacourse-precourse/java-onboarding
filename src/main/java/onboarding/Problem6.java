package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emailSet = new HashSet<>();
        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                String tmp = String.valueOf(nickname.charAt(j)) + nickname.charAt(j + 1);
                if (isDuplicate(forms, emailSet, i, tmp)) break;
            }
        }
        List<String> answer = new ArrayList<>(emailSet);
        Collections.sort(answer);
        return answer;
    }

    private static boolean isDuplicate(List<List<String>> forms, Set<String> emailSet, int index, String tmp) {
        for (int i = index + 1; i < forms.size(); i++) {
            if (forms.get(i).get(1).contains(tmp)) {
                emailSet.add(forms.get(index).get(0));
                emailSet.add(forms.get(i).get(0));
                return true;
            }
        }
        return false;
    }

}
