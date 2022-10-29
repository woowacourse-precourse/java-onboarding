package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static List<String> separateNickname(String nickname) {
        List<String> returnList = new ArrayList<>();
        for (int i = 2; i < nickname.length()+1; i++) {
            for (int j = 0; j < nickname.length()+1 - i; j++) {
                returnList.add(nickname.substring(j, i+j));
            }
        }
        return returnList;
    }


}
