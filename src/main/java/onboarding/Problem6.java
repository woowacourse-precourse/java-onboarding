package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> words = new HashMap<>();

        for (List<String> form:forms) {
            if(form.get(0).matches("^[A-Za-z0-9+_.-]{1,10}@email.com$") && form.get(1).matches("^[가-힣]{1,20}$")) {
                String nickname = form.get(1);
                for (int i = 0; i < nickname.length() - 1; i++) {
                    String currWord = nickname.substring(i, i+2);
                    if (words.containsKey(currWord)) {
                        if (!answer.contains(form.get(0))) answer.add(form.get(0));
                        if (!answer.contains(words.get(currWord).get(0))) answer.add(words.get(currWord).get(0));
                    } else {
                        words.put(currWord, form);
                    }
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }
}