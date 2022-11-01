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
        raisingFriendOfFriendScore();
        raisingVisitorScored();

        List<String> keySetList = new ArrayList<>(friendScoreMap.keySet());
        keySetList.sort(((o1, o2) -> (this.friendScoreMap.get(o2).compareTo(this.friendScoreMap.get(o1)))));

        List<String> recommendList = new ArrayList<>();
        for(String key : keySetList) {
            if (friendScoreMap.get(key) != 0)
                recommendList.add(key);
        }

        return recommendList;
    }

    void raisingFriendOfFriendScore(){
        List<String> myFriendList = this.friendMap.get(this.user);
        // 친구의 친구 10점
        for (String myFriend: myFriendList) {
            List<String> friendOfFriendList = this.friendMap.get(myFriend);
            for (String friendOfFriend: friendOfFriendList) {
                if (!friendOfFriend.equals(this.user)){
                    int score = friendScoreMap.get(friendOfFriend);
                    score += 10;
                    friendScoreMap.put(friendOfFriend, score);
                }
            }
        }
    }

    void raisingVisitorScored(){
        for (String visitor: this.visitors) {
            if (!this.friendMap.get(this.user).contains(visitor)){
                int score = friendScoreMap.get(visitor);
                score++;
                friendScoreMap.put(visitor, score);
            }
        }
    }

    HashMap<String, Integer> initFriendScoreMap(){
        HashMap<String, Integer> friendScoreMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        for (List<String> friend: friends) {
            hashSet.addAll(friend);
        }

        for (String friend : hashSet) {
            friendScoreMap.put(friend, 0);
        }

        for (String visitor : this.visitors) {
            friendScoreMap.put(visitor, 0);
        }

        this.friendSet = hashSet;
        return friendScoreMap;
    }

    HashMap<String, List<String>> initFriendMap(){
        HashMap<String, List<String>> friendMap = new HashMap<>();

        for (String user : friendSet) {
            List<String> friendList = new ArrayList<>();
            friendMap.put(user, friendList);
        }

        for (List<String> friendship: friends) {
            String userA = friendship.get(0);
            String userB = friendship.get(1);
            List<String> friendListA = friendMap.get(userA);
            List<String> friendListB = friendMap.get(userB);
            friendListA.add(userB);
            friendListB.add(userA);
            friendMap.put(userA, friendListA);
            friendMap.put(userB, friendListB);
        }

        return friendMap;
    }




}
