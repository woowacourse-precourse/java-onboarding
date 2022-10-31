package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashSet<String> friendSet = new HashSet<>();
        Map<String, Integer> score = new HashMap<>();

        friendSet.add(user);
        for( List<String> friend : friends){
            if(friend.contains(user)){
                friendSet.add(friend.get(0));
                friendSet.add(friend.get(1));
            }
        }
        friendSet.remove(user);
        for(String friendName: friendSet){
            for(List<String> friend : friends){
                String f1= friend.get(0);
                String f2 = friend.get(1);
                String key = "";
                if(f1.equals(friendName)){
                    key = f2;
                }else if(f2.equals(friendName)){
                    key = f1;
                }

                if(key.equals(user) || key.equals("") || friendSet.contains(key)){
                    continue;
                }

                if(score.containsKey(key)){
                    score.replace(key,score.get(key) + 10);
                }else{
                    score.put(key,10);
                }
            }
        }
        for(String visitor: visitors){
            if(!friendSet.contains(visitor)){
                if(score.containsKey(visitor)){
                    score.replace(visitor,score.get(visitor)+1);
                }else{
                    score.put(visitor,1);
                }
            }
        }
        answer = new ArrayList<>(score.keySet());
        Collections.sort(answer);
        Collections.sort(answer,(a, b) -> (score.get(b).compareTo(score.get(a))));

        return answer;
    }
}
