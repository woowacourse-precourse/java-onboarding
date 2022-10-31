package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    public static List<String> token(String nickName) {
        List<String> tokens = new ArrayList<>();
        for(int i = 0; i < nickName.length()-1; i++) {
            tokens.add(nickName.substring(i, i+2));
        }
        return tokens;
    }
}
