package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emails = new HashSet<>();
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            String nickName = forms.get(i).get(1);
            if (nickName.length() < 2) {
                break;
            }

            for (int j = 0; j < nickName.length() - 1; j++) {
                String key = nickName.substring(j, j + 2);      // 2글자씩
                if (hashMap.containsKey(key)) {                 // key가 이미 존재한다면
                    String email = hashMap.get(key);
                    if (!email.equals(forms.get(i).get(0))) {    // key와 연결된 email이 현재 email과 다르다면
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                hashMap.put(key, forms.get(i).get(0));          // 갱신
            }
        }

//        List<String> answer = List.of("answer");
        List<String> answer = emails.stream().sorted().collect(Collectors.toList());
        return answer;
    }
}
