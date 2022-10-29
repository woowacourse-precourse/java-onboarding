package onboarding;

import java.util.*;


public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        ArrayList<String> Friends = new ArrayList<>();
        answer = new ArrayList<String>();
        Map<String, Integer> map = new TreeMap<>();
        for (int k=0; k<friends.size(); k++){
            if (friends.get(k).get(0) == user) {
                Friends.add(friends.get(k).get(1));
            }
            if (friends.get(k).get(1) == user){
                Friends.add(friends.get(k).get(0));
            }
        }
        System.out.println(Friends);


        System.out.println(map);
        List<String> keySet = new ArrayList<>(map.keySet());

        answer = keySet;
        return answer;
    }
}