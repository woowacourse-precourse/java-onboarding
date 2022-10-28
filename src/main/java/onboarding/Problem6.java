package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        // 1. 전체 nickname을 담은 set 생성
        HashSet<String> totalNicks = new HashSet<>();
        for(List<String> info: forms){
            String nickname = info.get(1);
            totalNicks.add(nickname);
        }



        return answer;
    }
}
