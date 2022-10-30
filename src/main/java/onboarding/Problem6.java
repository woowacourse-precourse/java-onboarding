package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String,Integer> check = checkDup(forms);
        List<String> answer = new ArrayList<>();
        //System.out.println(check);
        // 2. 두 글자씩 HashMap을 탐색해 value가 2 이상이면 answer 배열에 이메일 추가
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            if (nickname.length() >= 2) {
                for (int i = 0; i < nickname.length() - 1; i++) {
                    String subNickname = nickname.substring(i, i + 2);
                    if (check.get(subNickname) >= 2) {
                        answer.add(email);
                    }
                }
            }
            }
        Collections.sort(answer);
        return answer;
    }
    // 1. 닉네임별로 두 글자 씩 묶어서 HashMap에 갯수 저장
    public static HashMap<String,Integer> checkDup(List<List<String>> forms) {
        HashMap<String, Integer> check = new HashMap<>();
        for (List<String> form : forms) {
            String nickname = form.get(1);
            if (nickname.length() >= 2) {
                for (int i = 0; i < nickname.length()-1; i++) {
                    String subNickname = nickname.substring(i, i + 2);
                    if (!check.containsKey(subNickname)) {
                        check.put(subNickname, 1);
                    } else {
                        Integer originValue = check.get(subNickname);
                        check.replace(subNickname, originValue + 1);
                    }
                }
            }
        }
        return check;
    }
}
