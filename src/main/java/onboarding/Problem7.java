package onboarding;

import java.sql.Array;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(int i=0; i<friends.size(); i++) {
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();

            if(map.containsKey(friends.get(i).get(0))){
                list1 = map.get(friends.get(i).get(0));
                list1.add(friends.get(i).get(1));

            }else list1.add(friends.get(i).get(1));

            if(map.containsKey(friends.get(i).get(1))){
                list2 = map.get(friends.get(i).get(1));
                list2.add(friends.get(i).get(0));
            } else list2.add(friends.get(i).get(0));

            map.put(friends.get(i).get(0),list1);
            map.put(friends.get(i).get(1),list2);
        }
        List<String> userFriends = List.of();

        if(map.containsKey(user)) userFriends = map.get(user);
        Map<String,Integer> friendScore = new HashMap<>();

        for(String key:map.keySet()) {
            if(key == user) continue;
            int score =0;
            for(int i=0; i<userFriends.size(); i++){
                if(map.get(key).contains(userFriends.get(i))) score +=10;
            }
            if(score > 0){
                if(friendScore.containsKey(key)){
                    score += friendScore.get(key);
                }
                friendScore.put(key,score);
            }
        }

        for(int i=0; i<visitors.size(); i++){
            int score = 1;
            if(friendScore.containsKey(visitors.get(i))){
                score += friendScore.get(visitors.get(i));
            }
            friendScore.put(visitors.get(i),score);
        }

        for(int i=0; i<userFriends.size(); i++){
            if(friendScore.containsKey(userFriends.get(i)))
                friendScore.remove(userFriends.get(i));
        }

        List<String> keySet = new ArrayList<>(friendScore.keySet());

        // Value 값으로 내림차순
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(friendScore.get(o2) == friendScore.get(o1)) return o1.compareTo(o2);
                return friendScore.get(o2).compareTo(friendScore.get(o1));
            }
        });

        for(String key:keySet) {
            answer.add(key);
            if(answer.size()==5) break;
        }

        return answer;
    }
}
