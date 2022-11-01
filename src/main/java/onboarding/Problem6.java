package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Problem6 p6 = new Problem6();
        return answer;
    }

    private HashMap<String, String> getHashMappedForm(List<List<String>> forms) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> info : forms) {
            map.put(info.get(0), info.get(1));
        }
        return map;
    }

    private List<String> stringTokens(String word) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length() - 1; i++) {
            String temp = Character.toString(word.charAt(i)) + Character.toString(word.charAt(i + 1));
            result.add(temp);
        }
        return result;
    }
}
