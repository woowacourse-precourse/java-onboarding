package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> users = findAllUsers(friends, visitors); //모든 user
        List<String> friendsOfUser = findFriends(friends, user); //"mrko"와 친구 관계인 사람들을 추출.

        users.remove(user); //user 자신은 추천친구에 뜰 필요가 없음.
        users.removeAll(friendsOfUser); //이미 user와 친구인 사람들도 추천친구에 뜰 필요가 없음.

        List<RecommendFriend> recommendFriends = new ArrayList<>();
        for (String friend : users) {
            recommendFriends.add(new RecommendFriend(friend, 0));
        }

        addRecommendScoreByUsingFriends(user, recommendFriends, friends);
        addRecommendScoreByUsingVisitors(recommendFriends, visitors);
        Collections.sort(recommendFriends);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(recommendFriends.size(), 5); i++) {
            result.add(recommendFriends.get(i).getName());
        }

        return result;
    }

    private static List<String> findAllUsers(List<List<String>> friends, List<String> visitors) {
        List<String> users = new ArrayList<>();
        for (List<String> relationship : friends) {
            users.add(relationship.get(0));
            users.add(relationship.get(1));
        }
        users.addAll(visitors);

        //distinct() 메소드를 이용해 중복 제거 후, 스트림으로 리턴된 객체를 다시 List로 변환.
        List<String> noDuplicatedUsers = users.stream().distinct().collect(Collectors.toList());

        return noDuplicatedUsers;
    }
    
    private static List<String> findFriends(List<List<String>> friends, String user) {
        List<String> result = new ArrayList<>();
        for (List<String> relationship : friends) {
            int index = relationship.indexOf(user);
            if (index == 0) {
                result.add(relationship.get(1));
            } else if (index == 1) {
                result.add(relationship.get(0));
            }
        }

        return result;
    }
    
    private static void addRecommendScoreByUsingFriends(String user, List<RecommendFriend> recommendFriends, List<List<String>> friends) {
        List<String> friendsOfUser = findFriends(friends, user);
        for (RecommendFriend rf : recommendFriends) {
            for (String friend : friendsOfUser) { //friendsOfUser => [donut, shakevan]
                List<String> friendsOfFriend = findFriends(friends, friend);
                if (friendsOfFriend.contains(rf.getName())) {
                    rf.addRecommendScore(10);
                }
            }
        }
    }

    private static void addRecommendScoreByUsingVisitors(List<RecommendFriend> recommendFriends, List<String> visitors) {
        for (String visitor : visitors) {
            int index = recommendFriends.indexOf(new RecommendFriend(visitor, 0));
            if (index >= 0) {
                recommendFriends.get(index).addRecommendScore(1);
            }
        }
    }

    static class RecommendFriend implements Comparable<RecommendFriend> {
        private String name;
        private int recommendScore;

        /*
        public RecommendFriend(String name) {
            this(name, 0);
        }
        */

        public RecommendFriend(String name, int recommendScore) {
            this.name = name;
            this.recommendScore = recommendScore;
        }

        /*
        public void setRecommendScore(int score) {
            this.recommendScore = score;
        }
        */

        public void addRecommendScore(int score) {
            this.recommendScore += score;
        }

        public String getName() {
            return this.name;
        }

        /*
        public int getRecommendScore() {
            return this.recommendScore;
        }
        */

        @Override
        public int compareTo(RecommendFriend o) {
            if (this.recommendScore < o.recommendScore) {
                return 1;
            } else if (this.recommendScore > o.recommendScore) {
                return -1;
            } else {
                return this.getName().compareTo(o.getName());
            }
        }

    }
}
