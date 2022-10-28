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

        // 2. 나의 닉네임을 제외한 nickname set 생성
        for (List<String> info: forms) {
            String email = info.get(0);
            String nickname = info.get(1);

            HashSet<String> compareNicks = new HashSet<String>();
            compareNicks.addAll(totalNicks);
            compareNicks.remove(nickname);

        }



        return answer;
    }
}
