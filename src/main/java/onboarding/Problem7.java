package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
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
        String temp;
        for(int i = 0; i < length; i++){
            temp = checkAlreadyFriends(user, friends.get(i));
            if(!temp.equals("") && !output.contains(temp)){
                output.add(temp);
            }
        }
        return output;
    }
    private static void addScores(String member, HashMap Scores){

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> scores = new HashMap<>();
        List<String> alreadyFriends = findAlreadyFriends(user, friends);
        System.out.println(alreadyFriends);


        //HashMap scores = new HashMap<>();
        //Set<String> members = new Set<>();
        return answer;
    }
}
