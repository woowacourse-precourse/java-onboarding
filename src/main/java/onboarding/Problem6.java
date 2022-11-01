package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
1. form의 크기 만큼 아이디가 겹치는지 아닌지에 대한 플래그를 담을 list을 생성한다.
2. 플래그 배열을 돌면서 플래그가 세워져 있으면 return할 배열에 담는다.
 */

public class Problem6 {
    private static boolean flag_same[];

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        haveSameId(forms);
        getAnswerList(forms, answer);

        return answer;
    }


    private static void haveSameId(List<List<String>> forms) {
        int size = forms.size();

        flag_same = new boolean[size];
        for (int i = 0; i < size; i++) {
            flag_same[i] = false;
        }

        for (int i = 0; i < size - 1; i++) {
            if (flag_same[i] == false) {
                for (int j = i + 1; j < size; j++) {
                    if (isSameIdChar((forms.get(i)).get(1), (forms.get(j)).get(1))) {
                        flag_same[i] = true;
                        flag_same[j] = true;
                    }
                }
            }
        }
    }

    private static boolean isSameIdChar(String s, String s1) {
        int s_len = s.length();
        int s1_len = s1.length();

        for (int i = 0; i < s_len - 1; i++) {
            for (int j = 0; j < s1_len - 1; j++) {
                if (s.charAt(i) != s1.charAt(j))
                    continue;
                else {
                    if (s.charAt(i + 1) == s1.charAt(j + 1))
                        return true;
                    else
                        continue;
                }
            }
        }
        return false;
    }
}

