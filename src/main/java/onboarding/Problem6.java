package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 부분 닉네임 문자열과 이메일 정보를 담은 맵이다.
        Map<String, String> partNameWithEmail = new HashMap<>();

        // 결과 이메일을 담는 TreeSet이다.
        Set<String> answer = new TreeSet<>();

        for(List<String> form : forms) {
            // 크루들의 이메일과 닉네임 정보를 각각 추출한다.
            String email = form.get(0);
            String nickname = form.get(1);

            // 이메일을 한 글자씩 끊어서 배열로 만든다.
            String[] nameArr = nickname.split("");

        }
        
        return new ArrayList<>(answer);
    }


}
