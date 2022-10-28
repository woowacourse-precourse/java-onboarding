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

        return answer;

    }

}
