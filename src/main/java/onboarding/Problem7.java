package onboarding;

import java.util.*;

/**
 * 문제 풀이 방식 & 기능 목록서는
 * docs/PROBLEM7.md 의 하단에 기술되어 있습니다
 */
public class Problem7 {
    static HashMap<String, List<String>> friendMap;
    static HashMap<String, Integer> scoreCountMap;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        init();
        makeFriendsMap(friends);
        findAcquaintance(user);
        findVisitor(user, visitors);
        initFriendsScore(user);
        return recommendFriends();

    }

    private static void initFriendsScore(String user){
        List<String> friends = friendMap.get(user);
        if(friends == null) return;
        for(String friend : friends){
            scoreCountMap.put(friend, 0);
        }
        System.out.println();
    }

    private static List<String> recommendFriends() {
        List<String> recommendFriends = new ArrayList<>();
        PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])){
                    return o1[0].compareTo(o2[0]);
                }
                return Integer.parseInt(o2[1])-Integer.parseInt(o1[1]);
            }
        });

        for(String key : scoreCountMap.keySet()){
            pq.add(new String[]{key, String.valueOf(scoreCountMap.get(key))});
        }
        for(int i=0; i<5; i++){
            if(pq.isEmpty()) break;
            if(pq.peek()[1].equals("0")){
                break;
            }
            recommendFriends.add(pq.poll()[0]);
        }
        return recommendFriends;
    }

    private static void findVisitor(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if(scoreCountMap.containsKey(visitor)) {
                scoreCountMap.put(visitor, scoreCountMap.get(visitor) + 1);
            }else{
                scoreCountMap.put(visitor, 1);
            }
        }
    }

    private static void findAcquaintance(String user) {
        if(!friendMap.containsKey(user)) return;
        List<String> friends = friendMap.get(user);
        for (String friend : friends) {
            List<String> friendsOfFriends = friendMap.get(friend);
            for (String friendOfFriend : friendsOfFriends) {
                if (friendOfFriend.equals(user)) {
                    continue;
                }
                scoreCountMap.put(friendOfFriend, scoreCountMap.get(friendOfFriend) + 10);
            }
        }
    }

    private static void init(){
        friendMap = new HashMap<>();
        scoreCountMap = new HashMap<>();
    }
    private static void makeFriendsMap(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            addFriendRelationship(user1, user2);
        }
    }

    private static void addFriendRelationship(String user1, String user2) {
        if (friendMap.containsKey(user1)) {
            friendMap.get(user1).add(user2);
        } else {
            scoreCountMap.put(user1, 0);
            List<String> list = new ArrayList<>();
            list.add(user2);
            friendMap.put(user1, list);
        }

        if (friendMap.containsKey(user2)) {
            friendMap.get(user2).add(user1);
        } else {
            scoreCountMap.put(user2, 0);
            List<String> list = new ArrayList<>();
            list.add(user1);
            friendMap.put(user2, list);
        }
    }
}
