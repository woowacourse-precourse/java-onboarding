package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> check = checkDup(forms);
        List<String> answer = new ArrayList<>();
        System.out.println(check);
        return answer;
    }
    // 1. 닉네임별로 두 글자 씩 묶어서 HashMap에 저장
    public static List<String> checkDup(List<List<String>> forms) {
        List<String> check = new ArrayList<>();
        for (List<String> form : forms) {
            String nickname = form.get(1);
            if (nickname.length() >= 2) {
                for (int i = 0; i < nickname.length()-1; i++) {
                    check.add(nickname.substring(i, i + 2));
                }
            }
        }
        return check;
    }
}
