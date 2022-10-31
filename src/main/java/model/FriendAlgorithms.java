package model;

import java.util.*;

public class FriendAlgorithms {
    private String user;
    private List<List<String>> friends;
    private HashMap<String, Integer> friendScoreMap;
    private HashMap<String, List<String>> friendMap;
    private HashSet<String> friendSet;
    private List<String> visitors;

    public FriendAlgorithms(String user, List<List<String>> friends, List<String> visitors){
        this.user = user;
        this.friends = friends;
        this.visitors = visitors;
        this.friendScoreMap = initFriendScoreMap();
        this.friendMap = initFriendMap();
    }

    public List<String> friendRecommend(){
        List<String> list = this.friendMap.get(user);
        // 친구의 친구 10점
        for (String user: list) {
            List<String> list2 = this.friendMap.get(user);
            for (String user2: list2) {
                if (!user2.equals(this.user)){
                    int score = friendScoreMap.get(user2);
                    score += 10;
                    friendScoreMap.put(user2, score);
                }

            }
        }
        // 방문자 1점
        for (String user: this.visitors) {
            if (!this.friendMap.get(this.user).contains(user)){
                int score = friendScoreMap.get(user);
                score++;
                friendScoreMap.put(user, score);
            }
        }

        List<String> keySetList = new ArrayList<>(friendScoreMap.keySet());
        keySetList.sort(((o1, o2) -> (this.friendScoreMap.get(o2).compareTo(this.friendScoreMap.get(o1)))));

        List<String> recommendList = new ArrayList<>();
        for(String key : keySetList) {
            if (friendScoreMap.get(key) != 0)
                recommendList.add(key);
        }

        return recommendList;
    }

    HashMap<String, Integer> initFriendScoreMap(){
        HashMap<String, Integer> friendScoreMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        for (List<String> friend: friends) {
            for (String user: friend) {
                    hashSet.add(user);
            }
        }

        for (String user : hashSet) {
            friendScoreMap.put(user, 0);
        }

        for (String user : this.visitors) {
            friendScoreMap.put(user, 0);
        }

        this.friendSet = hashSet;
        return friendScoreMap;
    }

    HashMap<String, List<String>> initFriendMap(){
        HashMap<String, List<String>> friendMap = new HashMap<>();

        for (String user : friendSet) {
            List<String> list = new ArrayList<>();
            friendMap.put(user, list);
        }

        for (List<String> friend: friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            List<String> friendListA = friendMap.get(friendA);
            List<String> friendListB = friendMap.get(friendB);
            friendListA.add(friendB);
            friendListB.add(friendA);
            friendMap.put(friendA, friendListA);
            friendMap.put(friendB, friendListB);

        }

        return friendMap;
    }




}
