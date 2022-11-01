package onboarding;

import java.util.*;

public class Problem7 {

    /**
     * 사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때,
     * 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라.
     * 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.
     *
     * @param user 추천친구 목록을 받을 유저
     * @param friends 유저의 친구들
     * @param visitors 유저의 프로필을 방문한 사람들
     * @return 최대 5명의 추천 친구 목록
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendsRelation friendsRelation = new FriendsRelation();
        return friendsRelation.getRecommend(user, friends, visitors);
    }
}

class FriendsRelation {

    private Map<String, Set<String>> totalFriendsMap;
    private Map<String, Integer> totalRecommendedMap;

    public List<String> getRecommend(String user, List<List<String>> friends, List<String> visitors) {
        totalFriendsMap = new HashMap<>();
        totalRecommendedMap = new HashMap<>();
        connectRelation(friends);
        Set<String> userFriends = getUserFriends(user);
        List<String> friendsOfFriends = getFriendsOfFriends(userFriends);
        return getRank(user, userFriends, friendsOfFriends, visitors);
    }

    private void connectRelation(List<List<String>> friends) {

        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            connect(friendA, friendB);
            connect(friendB, friendA);
        }
    }

    private void connect(String user, String friend) {
        Set<String> friendsSet = totalFriendsMap.getOrDefault(user, new HashSet<>());
        friendsSet.add(friend);
        totalFriendsMap.put(user, friendsSet);
    }


    private Set<String> getUserFriends(String user) {
        return totalFriendsMap.getOrDefault(user, new HashSet<>());
    }

    private List<String> getFriendsOfFriends(Set<String> userFriends) {
        List<String> friendOfFriend = new ArrayList<>();

        for (String userFriend : userFriends) {
            Set<String> friends = this.getUserFriends(userFriend);
            friendOfFriend.addAll(friends);
        }

        return friendOfFriend;
    }

    private List<String> getRank(String user, Set<String> userFriends, List<String> friendOfFriend, List<String> visitors) {
        raiseScore(friendOfFriend, 10);
        raiseScore(visitors, 1);

        for (String userFriend : userFriends) {
            notRecommended(userFriend);
        }

        notRecommended(user);

        return getTop5();
    }

    private void raiseScore(List<String> users, int point) {
        for (String user : users) {
            int nowScore = getScore(user);
            totalRecommendedMap.put(user, nowScore + point);
        }
    }

    private int getScore(String user) {
        return totalRecommendedMap.getOrDefault(user, 0);
    }

    private void notRecommended(String user) {
        totalRecommendedMap.remove(user);
    }

    private List<String> getTop5() {
        Set<String> recommendSet = totalRecommendedMap.keySet();
        List<String> recommendList = new ArrayList<>(recommendSet);
        recommendList.sort(scoreComparator);
        return recommendList.subList(0, Math.min(recommendList.size(), 5));
    }

    private final Comparator<String> scoreComparator = (user1, user2) -> {
        int user1Score = getScore(user1);
        int user2Score = getScore(user2);

        if (user1Score < user2Score) {
            return 1;
        }

        if (user1Score == user2Score) {
            return user1.compareTo(user2);
        }

        return -1;
    };
}
