package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.HashMap;

public class Problem7 {
    static HashMap<String,Integer> map = new HashMap<>();
    public static void connect(List<List<String>> friends){

    }
    public static void visit(List<String> visitors){
        for(int i = 0; i < visitors.size(); i++){
            String key = visitors.get(i);
            map.put(key, map.getOrDefault(key, 1) + 1);
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        connect(friends);
        visit(visitors);
        return answer;
    }
}
