package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 1. 닉네임(key) - 이메일(value) map 생성
        // 2. 두 글자 씩 자른 값들이 다른 닉네임에 포함되어 있는 지 확인
        // 3. 포함되어 있으면 list에 추가 (비교하는 닉네임, 비교되는 닉네임)
        // 4. list 중복 제거
        // 5. list 오른차순 정렬
        // 6. list 반환
        List<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        String[] nickNameArr = new String[forms.size()];

        for (int i = 0; i < forms.size(); i++) {
            map.put(forms.get(i).get(1), forms.get(i).get(0));
            nickNameArr[i] = forms.get(i).get(1);
        }

        for (int k = 0; k < nickNameArr.length; k++) {
            String name = nickNameArr[k];
            for (int j = k + 1; j < nickNameArr.length; j++) {
                for (int i = 0; i < name.length() - 1; i++) {
                    String partOfName = name.substring(i, i + 2);
                    if (nickNameArr[j].contains(partOfName)) {

                    }
                }
            }
        }
        List<String> answer = List.of("answer");
        return answer;
    }
}
