package onboarding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem6 {

    public static Map<String, LinkedList<String>> makeTokens(List<List<String>> forms){
        Map<String, LinkedList<String>> result = new HashMap<>();

        for (List<String> form : forms){
            String nickname = form.get(1);
            for(int i =0; i<nickname.length()-1;i++){
                String token = nickname.substring(i,i+2);
                if(!result.keySet().contains(token)){
                    result.put(token, new LinkedList<>());
                }
                result.get(token).add(nickname);
            }
        }
        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }
}
