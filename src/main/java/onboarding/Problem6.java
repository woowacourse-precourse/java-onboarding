package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        for (int i = 0; i < forms.size(); i++) {
            String[] nickArr = forms.get(i).get(1).split("");

            combination(nickArr, "", 0, 0);
        }

        return answer;
    }

    // 닉네임 조합 만드는 메서드
    static void combination(String[] nickArr, String str, int idx, int depth) {
        if (depth > 1) {
            System.out.println(str);
        }

        for (int i = idx; i < nickArr.length; i++) {
            combination(nickArr,  str + nickArr[i], i + 1, depth + 1);
            if(str.length() > 0) {
                return;
            }
        }
    }
}
