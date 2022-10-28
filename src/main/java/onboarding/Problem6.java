package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(forms.size());

        //입력받은 이메일과 닉네임 중, 닉네임만 추출
        for (int i = 0; i < forms.size(); i++) {
            answer.add(forms.get(i).get(1));
        }

        return answer;
    }
}
