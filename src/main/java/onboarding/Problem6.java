package onboarding;

import java.util.*;

public class Problem6 {
    // 1. solution에서 List<List<String>>을 map으로 만들기
    // 2. 두글자씩 잘라서 중복확인용 메소드
    // 3. 중복된 값 찾고 정렬해서 return 하는 메소드

    public static List<String> solution(List<List<String>> forms) {
        Map<String,String> mapFroms = new LinkedHashMap<>();

        for (int i =0; i<forms.size(); i++){
            mapFroms.put(forms.get(i).get(0), forms.get(i).get(1));
        }

    }

}
