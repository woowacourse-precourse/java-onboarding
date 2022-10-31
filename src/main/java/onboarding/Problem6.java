package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
//        List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (List<String> form: forms) {
            HashSet<String> tempSet = new HashSet<String>();
            String nickname = form.get(1);
            for (int i=0; i < nickname.length()-2; i++) {
                tempSet.add(nickname.substring(i, i+2));
            }
            temp.addAll(tempSet);
        }
        HashSet<String> answerSet = new HashSet<String>();
        for (String val: temp) {
            int cnt = Collections.frequency(temp, val);
            if (cnt > 1) {
                for (List<String> form: forms) {
                    String nn = form.get(1);
                    if (nn.contains(val)) {
                        answerSet.add(form.get(0));
                    }
                }
            }
        }
        answer.addAll(answerSet);

        return answer;
    }
}
