package problem7;

import java.util.*;

public class User {
    private String name;
    private Timeline visitors;

    public User(String name, Timeline visitors) {
        this.name = name;
        this.visitors = visitors;
    }

    public List<String> getRecommendations(RecommendationDto recommendationDto) {
        Iterator<String> users = getScore(recommendationDto).keySet().iterator();
        List<Friend> recommendation = new ArrayList<>();

        while (users.hasNext()) {
            String user = users.next();
            addRecommendation(recommendationDto, recommendation, user);
        }
        return processRecommendations(recommendation);
    }

    private HashMap<String, Integer> getScore(RecommendationDto recommendationDto) {
        return recommendationDto.getScore();
    }

    private void addRecommendation(RecommendationDto recommendationDto, List<Friend> recommendation, String user) {
        if (!recommendationDto.getIsFriend()[getUserId(user, recommendationDto.getConnection())])
            recommendation.add(new Friend(user, getScore(recommendationDto).get(user)));
    }

    private int getRecommendationsLength(List<Friend> recommendation) {
        return Math.min(recommendation.size(), 5);
    }

    private List<String> processRecommendations(List<Friend> recommendation) {
        List<String> processedRecommendations = new ArrayList<>();

        recommendation
                .sort(Comparator
                        .comparingInt(Friend::getScore).reversed()
                        .thenComparing(Friend::getName));
        for (int i = 0; i < getRecommendationsLength(recommendation); i++) {
            processedRecommendations.add(recommendation.get(i).getName());
        }
        return processedRecommendations;
    }

    public int checkTimeline(FriendDto friendDto, HashMap<String, Integer> score, int cnt) {
        for (String visitor : visitors.getVisitors()) {
            score.put(visitor, score.getOrDefault(visitor, 0) + 1);
            cnt = setConnection(friendDto, cnt, visitor);
        }
        return cnt;
    }

    public void checkHaveSameFriends(FriendDto friendDto, boolean[] isFriend, HashMap<String, Integer> score) {
        if (hasConnection(name, getConnection(friendDto))) {
            check(isFriend, score, friendDto);
        }
    }

    private void check(boolean[] isFriend, HashMap<String, Integer> score, FriendDto friendDto) {
        HashMap<String, Integer> connection = getConnection(friendDto);
        List<List<String>> friends = getFriends(friendDto);
        int userId = getUserId(name, connection);
        isFriend[userId] = true;
        List<String> userFriends = friends.get(userId);
        
        for (int i = 0; i < userFriends.size(); i++) {
            int friendId = getUserId(getFriend(userFriends, i), connection);
            isFriend[friendId] = true;
            List<String> friendFriends = friends.get(friendId);

            addScore(score, friendFriends);
        }
    }

    private void addScore(HashMap<String, Integer> score, List<String> friendFriends) {
        for (int j = 0; j < friendFriends.size(); j++) {
            String friend = getFriend(friendFriends, j);
            score.put(friend, score.getOrDefault(friend, 0) + 10);
        }
    }

    public int addFriends(List<List<String>> friends, FriendDto friendDto, int cnt) {
        for (List<String> relationship : friends) {
            String leftUser = getFriend(relationship, 0);
            String rightUser = getFriend(relationship, 1);

            cnt = setConnection(friendDto, cnt, leftUser);
            cnt = setConnection(friendDto, cnt, rightUser);

            addFriend(friendDto, leftUser, rightUser);
            addFriend(friendDto, rightUser, leftUser);
        }
        return cnt;
    }

    private String getFriend(List<String> friends, int index) {
        return friends.get(index);
    }

    private Integer getUserId(String user, HashMap<String, Integer> connection) {
        return connection.get(user);
    }

    private void addFriend(FriendDto friendDto, String leftUser, String rightUser) {
        getFriends(friendDto).get(getUserId(leftUser, getConnection(friendDto))).add(rightUser);
    }

    private int setConnection(FriendDto friendDto, int cnt, String User) {
        HashMap<String, Integer> connection = getConnection(friendDto);

        if (!hasConnection(User, connection)) {
            connection.put(User, cnt++);
            getFriends(friendDto).add(new ArrayList<>());
        }
        return cnt;
    }

    private boolean hasConnection(String User, HashMap<String, Integer> connection) {
        return connection.containsKey(User);
    }

    private HashMap<String, Integer> getConnection(FriendDto friendDto) {
        return friendDto.getConnection();
    }

    private List<List<String>> getFriends(FriendDto friendDto) {
        return friendDto.getFriends();
    }
}
