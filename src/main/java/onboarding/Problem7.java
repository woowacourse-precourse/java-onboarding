package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {// 딕셔너리 이용 - 해도되는지 java.util.Map 지우고 시도해볼 수는 없다.
    private static String checkAlreadyFriends(String user, List<String> relation){
        String output;
        if (relation.get(0).equals(user)){
            output = relation.get(1);
            return output;
        }
        if (relation.get(1).equals(user)){
            output = relation.get(0);
            return output;
        }
        output = "";
        return output;
    }
    private static List<String> findAlreadyFriends(String user, List<List<String>> friends){
        List<String> output = new ArrayList<>();
        int length = friends.size();
        for(int i = 0; i < length; i++){
            if(true){
            }
        }
        return output;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> scores = new HashMap<>();
        List<String> alreadyFriends = new ArrayList<>();
        //HashMap scores = new HashMap<>();
        //Set<String> members = new Set<>();
        return answer;
    }
}
