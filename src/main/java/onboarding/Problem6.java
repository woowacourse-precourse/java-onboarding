package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 기능 목록
1. 모든 닉네임을 앞에서부터 2글자씩 끊어서 HashMap 에 저장
2. HashMap 순회하며 둘 이상 담겨있는 이메일들 answer set 에 담기
3. 이메일 오름차순 정렬, 중복 제거
*/

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        // 1. 모든 닉네임을 앞에서부터 2글자씩 끊어서 HashMap 에 저장
        HashMap<String, Set<String>> map = new HashMap<>();
        for(List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);
            for(int i=0; i<nickName.length() - 1; i++) {
                String key = nickName.substring(i, i+2);
                if(map.containsKey(key))
                    map.get(key).add(email);
                else {
                    Set<String> emails = new HashSet<>();
                    emails.add(email);
                    map.put(key, emails);
                }
            }
        }

        return answer;
    }
}
