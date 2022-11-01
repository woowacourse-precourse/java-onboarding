package onboarding;

import java.util.*;

public class Problem7 {

    public static Set<String> userList = new HashSet<>();
    public static Map<String, List<String>> friendList = new HashMap<>();
    public static Map<String, Integer> scoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        init(user, friends, visitors);

        for(String target : userList){
            addFriendScore(user, target);
        }

        addVisitScore(visitors);


        List<String> answer = getRecommendList(user);

        return answer;
    }

    public static void init(String originUser, List<List<String>> friends, List<String> visitors){

        for (List<String> friend : friends) {
            userList.add(friend.get(0));
            userList.add(friend.get(1));
            registerFriend(friend);
        }

        for(String visitor : visitors){
            userList.add(visitor);
        }
        userList.remove(originUser);

        for(String user : userList){
            scoreMap.put(user, 0);
        }
    }

    public static void registerFriend(List<String> friend){
        String friend1 = friend.get(0);
        String friend2 = friend.get(1);

        if(!friendList.containsKey(friend1)){
            friendList.put(friend1, new ArrayList<>());
        }
        if(!friendList.containsKey(friend2)){
            friendList.put(friend2, new ArrayList<>());
        }

        List<String> tempFriendList;

        tempFriendList = friendList.get(friend1);
        tempFriendList.add(friend2);
        friendList.put(friend1, tempFriendList);

        tempFriendList = friendList.get(friend2);
        tempFriendList.add(friend1);
        friendList.put(friend2, tempFriendList);
    }

    public static void addFriendScore(String user, String target){
        List<String> userFriendList = friendList.get(user);
        List<String> targetFriendList = friendList.get(target);

        if(targetFriendList==null){
            return;
        }
        for (String userFriend : userFriendList) {
            if(targetFriendList.contains(userFriend)){
                scoreMap.put(target, scoreMap.get(target)+10);
            }
        }
    }

    public static void addVisitScore(List<String> visitors){
        for (String visitor : visitors) {
            int newScore = scoreMap.get(visitor) + 1;
            scoreMap.put(visitor, newScore);
        }
    }

    public static List<String> getRecommendList(String user){
        List<String> userFriendList = friendList.get(user);
        PriorityQueue<String> recommendList = new PriorityQueue<>((o1, o2) -> {
            if (scoreMap.get(o1) == scoreMap.get(o2)) {
                return o1.compareTo(o2);
            }
            return scoreMap.get(o2) - scoreMap.get(o1);
        });
        for(String target : userList){
            if(userFriendList.contains(target)){
                continue;
            }
            recommendList.add(target);
        }
        List<String> answer = new ArrayList<>();
        int n = Math.min(recommendList.size(), 5);
        for(int i=0;i<n;i++){
            answer.add(recommendList.poll());
        }
        return answer;
    }




}
