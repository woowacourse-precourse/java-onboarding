package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Integer> seletedFormsIndex = new ArrayList<>();

        for (int i = 0; i < forms.size(); ++i) {
            for (int j = 0; j < forms.size(); ++j) {
                if (i != j && isOverlapNickname(forms.get(i).get(1), forms.get(j).get(1))) {
                    if (!seletedFormsIndex.contains(i)) {
                        answer.add(forms.get(i).get(0));
                        seletedFormsIndex.add(i);
                    }
                    if (!seletedFormsIndex.contains(i)) {
                        answer.add(forms.get(j).get(0));
                        seletedFormsIndex.add(j);
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    private static boolean isOverlapNickname(String s1, String s2) {
        int i = 0;
        int j;

        while (i < s1.length()) {
            j = 0;
            while (j < s2.length()) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i + 1 < s1.length() && j + 1 < s2.length()) {
                        if (s1.charAt(i + 1) == s2.charAt(j + 1)) {
                            return true;
                        }
                    }
                }
                ++j;
            }
            ++i;
        }
        return false;
    }
}
