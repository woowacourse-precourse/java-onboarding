
package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    private static String[][] emailAndNickname;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        emailAndNickname = new String[forms.size()][2];

        addToArray(forms);


        return answer;
    }

    private static void addToArray(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            List<String> l = forms.get(i);
            String email = l.get(0);
            String nickname = l.get(1);

            emailAndNickname[i][0] = email;
            emailAndNickname[i][1] = nickname;
        }
    }
}