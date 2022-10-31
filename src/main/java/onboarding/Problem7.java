package onboarding;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList();

        List<String> userFriends = new ArrayList<>();
        List<String> userAcquaintance = new ArrayList<>();

        for(List<String> friend : friends){
            int userIdx = friend.indexOf(user);
            if(userIdx != -1){
                userFriends.add(friend.get(1-userIdx));
            }
        }

        for(String userFriend : userFriends) {
            for (List<String> friend : friends) {
                int friendIdx = friend.indexOf(userFriend);
                if(friendIdx != -1){
                    if(!friend.get(1-friendIdx).equals(user)) {
                        userAcquaintance.add(friend.get(1 - friendIdx));
                    }
                }
            }
        }

        Map<String, Integer> score = new HashMap<>();


        for(String acq : userAcquaintance){
            score.put(acq, 10);
        }

        for(String visitor : visitors){
            Integer tmpScore = score.get(visitor);
            if(userFriends.contains(visitor)){

            }
            else if(tmpScore == null){
                score.put(visitor, 1);
            }
            else{
                score.put(visitor, tmpScore + 1);
            }
        }


        List<Map.Entry<String, Integer>> entries = score.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toList());

        int cnt = 0;
        for(Map.Entry<String, Integer> ent : entries){
            if(ent.getValue() == 0 || cnt == 5){
                break;
            }
            answer.add(ent.getKey());
            cnt+=1;
        }

        return answer;
    }
}
