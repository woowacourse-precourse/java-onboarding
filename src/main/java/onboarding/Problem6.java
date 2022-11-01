package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static List<String> getPartialName(List<List<String>> forms) {

        List<String> partialName = new ArrayList<>();
        String userName;

        for (List<String> form : forms) {
            userName = form.get(1);
            for (int i = 0; i < userName.length()-1; i++) {
                partialName.add(userName.substring(i, i+2));
            }
        }

        return partialName;
    }


}
