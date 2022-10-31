package onboarding;

import java.util.*;

public class Problem6 {
    private static int _email = 0;
    private static int _nick_name = 1;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Integer> selected = new ArrayList<>();

        for (int target = 0; target < forms.size(); ++target) {
            for (int i = 0; i < forms.size(); ++i) {
                if (target != i
                        && isOverlapNickname(forms.get(target).get(_nick_name), forms.get(i).get(_nick_name))) {
                    if (!selected.contains(target)) {
                        answer.add(forms.get(target).get(_email));
                        selected.add(target);
                    }
                    if (!selected.contains(i)) {
                        answer.add(forms.get(i).get(_email));
                        selected.add(i);
                    }
                }
            }
        }
        answer = new ArrayList<>(new HashSet<>(answer));
        Collections.sort(answer);
        return answer;
    }

    private static boolean isOverlapNickname(String s1, String s2) {
        for (int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); ++j) {
                if (s1.charAt(i) == s2.charAt(j)
                        && i + 1 < s1.length() && j + 1 < s2.length()
                        && s1.charAt(i + 1) == s2.charAt(j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
