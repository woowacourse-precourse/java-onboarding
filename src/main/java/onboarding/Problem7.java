package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }



    // friends of firends의 점수를 반환하는 메소드
    private static Map<String, Integer> getFriendsScore(String user, List<List<String>> friends) {
        List<String> friendsOfFriends = friendsOfFriends(friends);
        List<String> uniqueFriendsOfFriends = uniqueFriendsOfFriends(user, friends);

        Map<String,Integer> friendsScore = new HashMap<>();

        int count;
        int score;

        for (String uniqueFriendOfFriends : uniqueFriendsOfFriends) {
            count = 0;
            for (String friendOfFriends : friendsOfFriends) {
                if (uniqueFriendOfFriends.equals(friendOfFriends)) {
                    count++;
                }
            }
            score = count * 10;
            friendsScore.put(uniqueFriendOfFriends, score);
        }

        return friendsScore;
    }


    // 추천 친구 리스트를 반환하는 메소드
    private static List<String> recommendedFriendsOf(String user, List<List<String>> friends, List<String> visitors) {
        List<String> uniqueFriendsOfFriends= uniqueFriendsOfFriends(user, friends);
        List<String> uniqueVisitors = uniqueVisitorsOf(visitors);
        List<String> userFriends = userFriends(friends);

        Set<String> recommendedFriends = new HashSet<>(uniqueFriendsOfFriends);
        recommendedFriends.addAll(uniqueVisitors);

        recommendedFriends.removeIf(userFriends::contains);

        return new ArrayList<>(recommendedFriends);
    }

    // user와 friend인 리스트를 반환하는 메소드
    private static List<String> userFriends(List<List<String>> friends) {
        Set<String> friendsOfUser = new HashSet<>();

        for (List<String> friend : friends) {
            friendsOfUser.add(friend.get(0));
        }

        return new ArrayList<>(friendsOfUser);
    }


    // unique friends of friends 리스트를 반환하는 메소드
    private static List<String> uniqueFriendsOfFriends(String user, List<List<String>> friends) {
        List<String> friendsOfFriends = friendsOfFriends(friends);

        Set<String> set = new HashSet<>(friendsOfFriends);
        set.remove(user);

        return new ArrayList<>(set);
    }

    // fiends of friends 리스트를 반환하는 메소드
    private static List<String> friendsOfFriends(List<List<String>> friends) {
        List<String> friendsOfFriends = new ArrayList<>();

        for (List<String> friend: friends) {
            friendsOfFriends.add(friend.get(1));
        }
        return friendsOfFriends;
    }


    // visitor의 방문 횟수를 반환하는 메소드
    private static Map<String, Integer> getVisitorsScore(List<String> visitors) {
        List<String> uniqueVisitors = uniqueVisitorsOf(visitors);
        Map<String, Integer> visitCount = new HashMap<>();

        for (String uniqueVisitor : uniqueVisitors) {
            int count = 0;
            for (String visitor : visitors) {
                if (uniqueVisitor.equals(visitor)) {
                    count++;
                }
            }
            visitCount.put(uniqueVisitor, count);
        }

        return visitCount;
    }


    // unique visitor 리스트를 반환하는 메소드
    private static List<String> uniqueVisitorsOf(List<String> visitors) {
        Set<String> set = new HashSet<>(visitors);
        return new ArrayList<>(set);
    }
}