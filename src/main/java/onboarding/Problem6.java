package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> twoWords = getTwoWords(forms);

        return answer;
    }

    public static List<String> getTwoWords(List<List<String>> forms) {
        List<String> list = new ArrayList<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);

            if (nickname.length() == 1) continue;

            for (int j = 0; j < nickname.length() - 1; j++) {
                list.add(nickname.substring(j, j + 2));
            }
        }

        return list;
    }
}
