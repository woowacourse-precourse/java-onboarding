package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        NicknameDuplicate nickname = new NicknameDuplicate(forms);

        if(nickname.exception() == -1) {
            answer.add("***** Error *****");
        } else {
            answer = nickname.duplicate();
        }

        return answer;
    }
}
