package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
                insertFriend(friends.get(i).get(0));
                insertFriend(friends.get(i).get(1));
            }
        }
        void GroupingVisitorsByName() {
            for (int i = 0; i < visitors.size(); i++) {
                insertVisitor(visitors.get(i));
            }
        }

        void insertFriend (String key) {
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
        List<String> selectFriendsList () {
            recommendFriends.remove(user);
            removeUsersFriend();

            return sortRecommendFriends();
        }

        private List<String> sortRecommendFriends() {
            List<String> friends = new ArrayList<>(recommendFriends.keySet());
            friends.sort((value1, value2) ->
                    (recommendFriends.get(value2)).compareTo(recommendFriends.get(value1)));
            ArrayList<String> answer = new ArrayList<>(friends);

            answer = printFriends(answer);

            return answer;
        }

        private ArrayList<String> printFriends(ArrayList<String> answer) {
            if (answer.size() < 5) {
                return answer;
            } else {
                answer = (ArrayList<String>) answer.subList(0, 5);
                return answer;
            }
        }

        void removeUsersFriend() {
            for (int i = 0; i< friendWithUser.size(); i++) {
                recommendFriends.remove(friendWithUser.get(i));
            }
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        GroupFriends groupFriends = new GroupFriends(user, friends, visitors);

        groupFriends.findFriendsKnownUser();
        groupFriends.GroupingFriendsByName();
        groupFriends.GroupingVisitorsByName();
        answer = groupFriends.selectFriendsList();

        return answer;
    }
}
