package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;

    }
    public static List<String> similarNameFinder(List<List<String>> value) {
        Set<String> dupNames = new HashSet<String>();
        int inputLength = value.size();

        for (int i = 0; i < inputLength-1; i++) {
            String nickname = value.get(i).get(1);
            for (int j = i+1; j < inputLength; j++) {
                String compNickname = value.get(j).get(1);
                if (GCL(nickname, compNickname) >= 2) {
                    dupNames.add(value.get(i).get(0));
                    dupNames.add(value.get(j).get(0));
                }
            }

        }
        List<String> dupNameList = new ArrayList<>(dupNames);
        return dupNameList;
    }
}
