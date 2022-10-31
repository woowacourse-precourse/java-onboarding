package onboarding;

import java.util.List;
import java.util.Map;

public class Problem6 {
    public static Map<Integer, String> userMap;
    public static Map<String, Integer> subStrIndexMap;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void initUserMap(List<List<String>> forms){
        for(int index = 0; index<forms.size(); index++){
            userMap.put(index, forms.get(index).get(0));
        }
    }
}
