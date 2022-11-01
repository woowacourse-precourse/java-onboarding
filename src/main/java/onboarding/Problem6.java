package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) { // hashmap 돌면서 닉네임이 두글자 이상 중복인지 검사
        HashSet<String> emails = new HashSet<>();
        Map<String, String> hashMap = new HashMap<>(); // key : value 로 순환한다는 생각 전후 상관 없이 돌도록

        for (List<String> form : forms) // 리스트 전체 순환 foreach
        {
            String nickName = form.get(1); // 중복검사는 닉네임만
            for (int j = 0; j < nickName.length() - 1; j++)
            {
                String key = nickName.substring(j, j + 2); // 조건 - 최소 두글자가 중복될 시
                if (hashMap.containsKey(key))
                {
                    String email = hashMap.get(key);
                    if (!email.equals(form.get(0)))
                    {
                        emails.add(email);
                        emails.add(form.get(0));
                    }
                }
                hashMap.put(key, form.get(0)); // 위의 if문으로 판별 후 중복 조건에 걸릴 시 HashSet으로 생성된 emails에 저장
            }
        }
    }
}
