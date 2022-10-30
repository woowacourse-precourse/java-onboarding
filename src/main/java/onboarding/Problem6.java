package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashSet<String> nickname = new HashSet<>();
        HashMap<String, String> email_nick = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            String check_email = forms.get(i).get(0);
            System.out.println(check_email);
            // 닉네임 길이가 2보다 짧으면
            if (name.length() < 2) {
                return Collections.singletonList("");
            }
            // 1명미만, 10,000명 초과
            if (forms.size() < 1 || forms.size() > 10000 ) {
                return Collections.singletonList("");
            }
            // 이메일 전체 길이 11자 미만 20자 이상
            if (check_email.length() < 11 || check_email.length() > 20){
                return Collections.singletonList("");
            }
            // 2단어씩 나누기
            for (int j = 0; j < name.length() - 1; j++) {
                String key = name.substring(j, j + 2);
                // 키를 가지고 있으면
                if (email_nick.containsKey(key)) {
                    String email = email_nick.get(key);
                    System.out.println(email);
                    // nickname에 추가
                    if (!email.equals(forms.get(i).get(0))) {
                        nickname.add(email);
                        nickname.add(forms.get(i).get(0));
                    }
                }
                email_nick.put(key, forms.get(i).get(0));
            }
        }
        List<String> collect = nickname.stream()
                .sorted()
                .collect(Collectors.toList());

        answer = List.of(collect.toArray(new String[0]));
        return answer;
    }

}