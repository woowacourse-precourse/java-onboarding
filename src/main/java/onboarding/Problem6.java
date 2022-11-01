package onboarding;

import java.util.List;
import java.util.HashMap;

// {이메일, 닉네임} 리스트 형식으로 구성된 리스트가 forms 파라미터로 주어짐
// >> { {'asd', 'fgh'}, {'zxc', 'qwe'}, {'cvb', 'qwe'}, ... }
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // return 값인 answer 초기화
        List<String> answer = List.of("answer");

        // map 사용해서 서로 연결
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < forms.size(); i ++) {
            map.put(forms.get(i).get(0), forms.get(i).get(1));
        }

        System.out.println(map.get("jm@email.com"));
        return answer;
    }
    }
