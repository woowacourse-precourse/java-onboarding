package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static Map<Integer, String> userMap;
    public static Map<String, Integer> subStrIndexMap;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        for(int index = 0; index<forms.size(); index++){
            String userNickName = forms.get(index).get(1);
        }
        return answer;
    }

    public static void initUserMap(List<List<String>> forms){
        for(int index = 0; index<forms.size(); index++){
            userMap.put(index, forms.get(index).get(0));
        }
    }

    public static void initSubStrIndexMap(){
        subStrIndexMap = new HashMap<>();
    }


}
