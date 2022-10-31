package onboarding;

import java.util.*;

public class Problem6 {

    // 중복인 닉네임을 가진 유저의 이메일 집합 set
    public static Set<String> set = new HashSet<>();

    // 2글자씩 쪼갠 문자열이 다른 닉네임에 속해 있는지 중복 체크
    public static boolean isContain(List<List<String>> forms, int idx, String subString) {
        for(int i =0; i< forms.size(); i++) {
            if(i == idx) continue;

            // 중복시 true 리턴
            if(forms.get(i).get(1).contains(subString)) return true;
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
