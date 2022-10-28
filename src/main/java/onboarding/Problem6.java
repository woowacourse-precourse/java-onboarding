package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    public static Map<String, String> listToMap(List<List<String>> forms){
        Map<String, String> result = new HashMap<>();
        forms.stream().forEach(form -> result.put(form.get(0), form.get(1)));

        return result;
    }

    static List<String> getTokens(String name){
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < name.length() - 1; i++){
            String token = name.substring(i, i+2);
            result.add(token);
        }

        return result;
    }
}
