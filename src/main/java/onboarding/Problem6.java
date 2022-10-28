package onboarding;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    private final static int EMAIL = 0;
    private final static int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> map = new LinkedHashMap<>();

        for (List<String> form : forms) {
            String nickname = form.get(NICKNAME);
            List<String> list = new ArrayList<>();
            for (int i = 0; i < nickname.length() - 1; i++) {
                list.add(nickname.substring(i, i + 2));
            }
            map.put(form.get(EMAIL), list);
        }

        int loopStartIdx = 1;

        for (String email : map.keySet()) {
            List<String> list = map.get(email);
            for (int i = loopStartIdx; i < forms.size(); i++) {
                for (String splitNickname : list) {
                    if (forms.get(i).get(NICKNAME).contains(splitNickname)) {
                        answer.add(forms.get(i).get(EMAIL));
                        answer.add(email);
                    }
                }
            }
            loopStartIdx++;
        }

        return answer;

    }

}
