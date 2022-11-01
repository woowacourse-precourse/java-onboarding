package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        String nicknames[] = new String[10001];
        boolean[] isProblem = new boolean[10001];
        int count = forms.size();

        for (int i = 0; i < count; i++) {
            nicknames[i] = forms.get(i).get(1);
            isProblem[i] = true;
        }

        for (int i = 0; i < count; i++) {
            String nickname = nicknames[i];

            for (int j = 0; j < nickname.length() - 1; j++) {

                String substring = nickname.substring(j, j + 2);
                for (int k = 0; k < count; k++) {
                    String s = nicknames[k];
                    if (s.indexOf(substring) != -1 && i != k && isProblem[k]) {
                        isProblem[k] = false;
                        isProblem[i] = false;
                    }
                }
            }
        }

        for (int i = 0; i < count; i++) {
            if(isProblem[i] == false) {
                answer.add(forms.get(i).get(0));
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
