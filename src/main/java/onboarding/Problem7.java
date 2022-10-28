package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, ArrayList<String>> friendHashMap = new HashMap<>();
        HashMap<String, Integer> scoreHashmap = new HashMap<>();

        for(int i=0; i<friends.size(); i++){
            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);

            ArrayList<String> friendList;

            if(friendHashMap.containsKey(name1))
                friendList = friendHashMap.get(name1);
            else
                friendList = new ArrayList<>();
            friendList.add(name2);
            friendHashMap.put(name1, friendList);
            scoreHashmap.put(name1, 0);

            if(friendHashMap.containsKey(name2))
                friendList = friendHashMap.get(name2);
            else
                friendList = new ArrayList<>();
            friendList.add(name1);
            friendHashMap.put(name2, friendList);
            scoreHashmap.put(name2, 0);
        }

        for(String visitor: visitors){
            int score = 1;
            if(scoreHashmap.containsKey(visitor))
                score += scoreHashmap.get(visitor);
            scoreHashmap.put(visitor, score);
        }


        for(String userFriend: friendHashMap.keySet()){
            if(userFriend.equals(user))
                continue;
            Set<String> userFriendSet = new HashSet<>(friendHashMap.get(user));
            Set<String> friFriendSet = new HashSet<>(friendHashMap.get(userFriend));
            userFriendSet.retainAll(friFriendSet);
            int score = scoreHashmap.get(userFriend) + userFriendSet.size()*10;
            scoreHashmap.put(userFriend, score);
        }

        scoreHashmap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<String> answer = new ArrayList<>();

        for(String name: scoreHashmap.keySet()){
            if(scoreHashmap.get(name)==0)
                continue;
            if(friendHashMap.get(user).contains(name))
                continue;
            answer.add(name);
            if(answer.size()==5)
                break;
        }
        return answer;
    }
    public static void main(String args[]){
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        System.out.println(solution(user, friends, visitors));
    }
}
