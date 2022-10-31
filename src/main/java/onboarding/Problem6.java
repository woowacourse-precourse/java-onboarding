package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> hashSet = new HashSet<>();              // 중복 제거를 위한 HashSet
        Map<String, String> hashMap = new HashMap<>();      // 중복 닉네임 확인을 위한 HashMap
        for (List<String> form: forms) {        // 각각의 [이메일, 닉네임]에 대해
            String email = form.get(0);         // 현재 이메일
            String nickName = form.get(1);      // 현재 닉네임

            if (2 <= nickName.length()) {       // 닉네임이 두 글자 이상인 경우(한 글자인 경우는 무시)
                for (int i = 0; i < nickName.length() - 1; i++) {   // 두 글자씩 추출하여야 하므로 length - 1 까지
                    String key = nickName.substring(i, i + 2);      // [i:i + 2] 범위 = 두 글자
                    if (hashMap.containsKey(key)) {     // 동일한 두 글자를 이미 갖고 있다면
                        hashSet.add(email);                 // 현재 이메일 추가
                        hashSet.add(hashMap.get(key));      // 기존 이메일 추가
                    }
                    hashMap.put(key, email);        // Key-Value 쌍 {두 글자: 현재 이메일} 추가
                }
            }
        }

        /* hashSet으로 중복이 제거된 이메일에 대해 오름차순 정렬하여 return */
        List<String> answer = hashSet.stream().sorted().collect(Collectors.toList());
        return answer;
    }
}
