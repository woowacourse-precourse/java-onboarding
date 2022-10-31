package onboarding;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7 {
    static class FriendSort {

        private String name;
        private Integer point;

        public FriendSort(String name, Integer point) {
            this.name = name;
            this.point = point;
        }

        public String getName() {
            return name;
        }

        public Integer getPoint() {
            return point;
        }
    }

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
                else if (friend2.equals(user)) {
                    friendWithUser.add(friend1);
                }
            }
        }

        void groupingFriendsByName() {
            for (int i = 0; i < friends.size(); i++) {
                insertFriend(friends.get(i).get(0));
                insertFriend(friends.get(i).get(1));
            }
        }

        void groupingVisitorsByName() {
            for (int i = 0; i < visitors.size(); i++) {
                insertVisitor(visitors.get(i));
            }
        }

        boolean verifiedFriendList(int i, String key) {
            return friends.get(i).contains(key) && (friendWithUser.contains(friends.get(i).get(0))
                    || friendWithUser.contains(friends.get(i).get(1)));
        }

        void insertFriend (String key) {
            for (int i = 0; i < friends.size(); i++) {
                if (verifiedFriendList(i, key)) {
                    if (recommendFriends.containsKey(key)) {
                        recommendFriends.put(key, recommendFriends.get(key) + 10);
                    } else {
                        recommendFriends.put(key, 10);
                    }
                }
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
            List<FriendSort> friends = new ArrayList<>();

            for (Map.Entry<String, Integer> pair : recommendFriends.entrySet()) {
                friends.add(new FriendSort(pair.getKey(), pair.getValue()));
            }

            friends.sort(Comparator.comparing(FriendSort::getPoint).reversed()
                    .thenComparing(FriendSort::getName));

            ArrayList<String> answer = new ArrayList<>();

            for (FriendSort friendCompare : friends) {
                answer.add(friendCompare.getName());
            }

            answer = (ArrayList<String>) printFriends(answer);

            return answer;
        }

        private List<String> printFriends(ArrayList<String> answer) {
            if (answer.size() < 5) {
                return answer;
            } else {
                return new ArrayList<>(answer.subList(0, 5));
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
        groupFriends.groupingFriendsByName();
        groupFriends.groupingVisitorsByName();
        answer = groupFriends.selectFriendsList();

        return answer;
    }
}
