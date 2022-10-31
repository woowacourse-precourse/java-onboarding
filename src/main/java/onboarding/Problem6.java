package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, List<String>> nicknamePartition = new HashMap<>();
        for (List<String> form : forms) {
            nicknamePartition.put(form.get(0), devideByTwo(form.get(1)));
        }

        
        return answer;
    }

    private static List<String> devideByTwo(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            result.add(s.substring(i, i + 2));
        }
        return result;
    }

}
