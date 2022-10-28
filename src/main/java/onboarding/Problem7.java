package onboarding;

import java.util.*;

public class Problem7 {
    static class GroupFriends {
        String user;
        List<List<String>> friends;
        List<String> visitors;
        ArrayList<String> friendWithUser;
        HashMap<String, Integer> recommendFriends;

        public GroupFriends(String user, List<List<String>> friends, List<String> visitors) {
            this.user = user;
            this.friends = friends;
            this.visitors = visitors;
            this.recommendFriends = new HashMap<>();
        }
        void findFriendsKnownUser () {
            friendWithUser = new ArrayList<>();

            // 유저와 알고있는 친구목록 입력
            for (int i = 0; i < friends.size(); i++) {
                String friend1 = friends.get(i).get(0);
                String friend2 = friends.get(i).get(1);
                if (friend1.equals(user)) {
                    friendWithUser.add(friend2);
                }
                if (friend2.equals(user)) {
                    friendWithUser.add(friend1);
                }
            }
        }
        void GroupingFriendsByName() {
            for (int i = 0; i < friends.size(); i++) {
                findFriend(i);
            }
        }
        void GroupingVisitorsByName() {
            for (int i = 0; i < visitors.size(); i++) {

            }
        }
        void findFriend (int i) {


        }

        void insertFriend (String key, int i) {
            if (recommendFriends.containsKey(key)) {
                recommendFriends.put(key, recommendFriends.get(key) + 10);
            } else {
                recommendFriends.put(key, 10);
            }
        }
        void insertVisitor (String key) {
            if (recommendFriends.containsKey(key)) {
                recommendFriends.put(key, recommendFriends.get(key) + 1);
            } else {
                recommendFriends.put(key, 1);
            }
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        GroupFriends groupFriends = new GroupFriends(user, friends, visitors);

        groupFriends.findFriendsKnownUser();
        groupFriends.GroupingFriendsByName();
        groupFriends.GroupingVisitorsByName();
        System.out.println(groupFriends.recommendFriends);
        System.out.println(groupFriends.friendWithUser);
        return answer;
    }

    public static void main(String[] args) {
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
        List<String> result = List.of("andole", "jun", "bedi");
        solution(user, friends, visitors);
    }
}
