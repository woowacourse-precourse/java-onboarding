package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for(List<String> user : forms) {
            List<String> word_combi = createWordCombi(user.get(1));
        }

        return answer;
    }

    public static List<String> createWordCombi(String nickname) {
        List<String> word_combi = new ArrayList<>();

        for(int i = 0; i < nickname.length() - 1; i++) {
            word_combi.add(nickname.substring(i,i+2));
        }

        return word_combi;
    }
}
