package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 중복된 크루들의 이메일이 담길 set 생성
        HashSet<String> set = new HashSet<>();

        // 1. forms 리스트에 담긴 크루들의 닉네임을 for문 돌면서 뽑아낸다
        // 2. 뽑아낸 닉네임을 두글자씩 짝지어서 tmp에 담아준다.
        // 3. 현재 뽑힌 닉네임의 크루외의 다른 크루에게 tmp값과 같은 닉네임이 있는지 확인해준다
        // 3-1. 만약 tmp와 겹치는 닉네임이 있다면 set에 값을 추가해준다.
        // 4. 1번 ~ 3번 과정을 반복해 비슷한 닉네임을 가진 크루들을 뽑아낸다.
        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);

            for (int j = 0; j < nickname.length() - 1; j++) {
                String tmp = nickname.substring(j, j + 2);

                for (int k = i + 1; k < forms.size(); k++) {
                    String check = forms.get(k).get(1);
                    
                    if (check.contains(tmp)){
                        set.add(forms.get(i).get(0));
                        set.add(forms.get(k).get(0));
                    }
                }
            }
        }

        // set을 List로 변경하고, 출력 조건에 맞게 정렬해준다.
        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);

        return answer;
    }
}
