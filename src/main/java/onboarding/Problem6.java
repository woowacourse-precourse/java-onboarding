package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> formsMap = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            List form = forms.get(i);
            formsMap.put((String) form.get(0), (String) form.get(1));
        }

        Collection<String> nicknames = formsMap.values();

        Iterator iterator = nicknames.iterator();
        while (iterator.hasNext()) {
            String nickname = (String) iterator.next();
            System.out.println(nickname);
            checkNickName(nickname, nicknames);
        }

        List<String> answer = List.of("answer");
        return answer;
    }
}
