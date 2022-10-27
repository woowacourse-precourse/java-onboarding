package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> userFriends = new HashSet<>();
        Map<String,Integer> friendsScore = new HashMap<>();

        for(List<String> info :friends) {
            if( info.contains(user) ) {
                userFriends.add(info.get(0));
                userFriends.add(info.get(1));
            }
        }

        for(List<String> info :friends) {
            for(String userFriend :userFriends) {
                if(info.contains(userFriend)) {
                    for(String friend:info) {
                        friendsScore.put(friend,
                                friendsScore.getOrDefault(friend, 0) + 10);
                    }
                }
            }
        }

        for(String visitor :visitors) {
            friendsScore.put(visitor, friendsScore.getOrDefault(visitor, 0) + 1);
        }

        for(String userFriend:userFriends) {
            friendsScore.remove(userFriend);
        }

        List<Map.Entry<String,Integer>> scoreList = new LinkedList<>(friendsScore.entrySet());
        Collections.sort(scoreList, new Comparator<>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue()>o2.getValue()){
                    return -1;
                } else if (o1.getValue()< o2.getValue()) {
                    return 1;
                } else{
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });


        for(int i=0; i<5; i++){
            if(scoreList.size()<i+1){
                break;
            }
            answer.add(scoreList.get(i).getKey());
        }

        return answer;
    }
}
