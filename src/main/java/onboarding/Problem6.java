package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

        String tmp1;
        String tmp2;
        Stack<String> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {

            // i번째 크루 닉네임을 2크기의 문자열들로 나눠서 저장 -> ex) 제이엠 => { 제이, 이엠 }
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                stack.push(forms.get(i).get(1).substring(j, j + 2));
            }

            // 중복 검사
            for (String e : stack) {
                for (int k = 0; k < forms.size(); k++) {
                    if (k == i) {
                        continue;
                    }
                    if (forms.get(k).get(1).contains(e) && !result.contains(forms.get(k).get(0))) {
                        result.add(forms.get(k).get(0));
                    }
                }
            }

            stack.clear();
        }

        Collections.sort(result);

        return result;
    }
}
