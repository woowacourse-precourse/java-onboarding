package onboarding;

import java.util.*;


public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        Map<String, Integer> map1 = new HashMap<>();
        
        for (int i = 0; i < forms.size(); i++) {
            // forms 의 i번째 유저 닉네임
            String name = forms.get(i).get(1);

            // 2글자씩 나누면서 해쉬맵에 저장
            for (int n = 0; n < name.length() - 1; n++) {
                String sub = name.substring(n, n + 2);

                if (!map1.containsKey(sub)) { // 해쉬맵에 없는 2글자라면 저장
                    map1.put(sub, i);
                }

                else { // 해쉬맵에 저장되어있는 2글자이면 중복 및 유사 닉네임
                    // 해당 인덱스의 이메일을 저장
                    answer.add(forms.get(i).get(0));

                    //  해쉬맵에서 해당 인덱스와 겹쳤던 닉네임을 가진 이메일을 answer 에 저장
                    if (answer.contains(forms.get(map1.get(sub)).get(0))){ // 중복 방지
                        continue;
                    }
                    else{
                        answer.add(forms.get(map1.get(sub)).get(0));
                    }
                }
            }
        }

        Collections.sort(answer); // 정렬
        return answer;
    }
}