package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        // 하나의 form씩 까보기
        for (List<String> form : forms) {
            String nickname = form.get(1);
            int count = 0;
            for (int i = 0; i < nickname.length() - 1; i++) {
                String nick = nickname.substring(i, i + 2);
                for (int j = 0; j < forms.size(); j++) {
                    if (forms.get(j).get(1).contains(nick)) {
                        count += 1;
                    }
                }
                if (count-2 > 1) {
                    answer.add(form.get(0));
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
