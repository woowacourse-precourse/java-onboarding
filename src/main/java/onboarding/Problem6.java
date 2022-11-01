package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashSet<String> emails = new HashSet<>();
        final Map<String, String > hashMap = new HashMap<>();


        // email형식, 길이 검증
        // email.com 도메인 검증
        //닉네임 길이 (1,20] 검증

        //1.완탐; 이름이 2개 이상글자가 중복되는 것만 email 추출
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            if(name.length()< 2){
                break;
            }

            for (int j = 0; j < name.length() - 1; j++) {
                String nameSubKey = name.substring(j, j+2);
                if(hashMap.containsKey(nameSubKey)){
                    String email = hashMap.get(nameSubKey);
                    if(!email.equals(forms.get(i).get(0))){
                        emails.add(forms.get(i).get(0));
                        emails.add(email);
                    }
                }
                hashMap.put(nameSubKey, forms.get(i).get(0));
            }
        }

        //result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거
        List<String> res = emails.stream()
                .sorted()
                .collect(Collectors.toList());
        return answer = res;
    }
}