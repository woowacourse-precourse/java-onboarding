
package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    private static String[][] emailAndNickname;
    private static boolean[] inAnswerSet;
    private static TreeSet<String> answerSet;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        emailAndNickname = new String[forms.size()][2];
        answerSet = new TreeSet<>();

        addToArray(forms);

        for (int i = 0; i < emailAndNickname.length; i++) {
            inAnswerSet = new boolean[emailAndNickname.length];
            inAnswerSet[i] = true;

            checkDuplicatedNickname(i);
        }

        for (String s : answerSet) {
            answer.add(s);
        }

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

    private static void checkDuplicatedNickname(int nowIndex) {
        String s = emailAndNickname[nowIndex][1];

        for (int i = 0; i < s.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            sb.append(s.charAt(i + 1));
            String s2 = sb.toString();

            haveThisWord(s2, nowIndex);
        }
    }

    private static void haveThisWord(String s2, int nowIndex) {
        for (int i = 0; i < emailAndNickname.length; i++) {
            addToSet(s2, i, nowIndex);
        }
    }

    private static void addToSet(String s2, int i, int nowIndex) {
        if (!inAnswerSet[i] && emailAndNickname[i][1].contains(s2)) {
            answerSet.add(emailAndNickname[nowIndex][0]);
            answerSet.add(emailAndNickname[i][0]);
            inAnswerSet[i] = true;
        }
    }
}