package onboarding;

import java.util.*;

public class Problem7 {


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        
        User myUser = new User(user);
        FriendMap friendMap = new FriendMap(friends);
        Visitors visitorList = new Visitors(visitors);
        RecommendScore recommendScore = new RecommendScore(myUser);
        recommendScore.addFriendScore(friendMap);
        recommendScore.addVisitScore(visitorList);
        recommendScore.removeFriends(friendMap);
        return recommendScore.top5();

    }
}

class RecommendScore {
    private final Map<User, Score7> recommendScore;
    private final User myUser;

    public RecommendScore(User myUser) {
        this.recommendScore = new HashMap<>();
        this.myUser = myUser;
    }

    public void addFriendScore (FriendMap friendMap) {
        Friends myFriends = friendMap.findFriends(myUser);
        for (User friend : myFriends.getFriends()) {
            // 친구의 친구들
            Friends friendFriends = friendMap.findFriends(friend);
            for (User friendFriend : friendFriends.getFriends()) {
                addScore(friendFriend, 10);
            }
        }
    }

    public void addVisitScore(Visitors visitors) {
        List<User> visitorList = visitors.getVisitors();
        for (User visitor : visitorList) {
            addScore(visitor, 1);
        }
    }

    private void addScore(User user, int point) {
        if (user.equals(myUser)){
            return;
        }
        if (!this.recommendScore.containsKey(user)) {
            Score7 score = new Score7();
            recommendScore.put(user, score);
        }
        recommendScore.get(user)
                .addScore(point);
    }

    public void removeFriends(FriendMap friendMap) {
        Friends friends = friendMap.findFriends(myUser);
        for (User friend : friends.getFriends()) {
            recommendScore.remove(friend);
        }
    }

    public List<String> top5() {
        List<String> result = new ArrayList<>();
        List<User> sortKey = getSortKey();
        int idx = 0;
        while ((idx < sortKey.size()) && (idx < 5)) {
            String userName = sortKey.get(idx).getUser();
            result.add(userName);
            idx++;
        }
        return result;
    }

    private List<User> getSortKey() {
        List<User> userList = new ArrayList<>(recommendScore.keySet());
        userList.sort(
                (user1, user2)
                        -> user1.getUser()
                        .compareTo(user2.getUser()));
        userList.sort(
                (user1, user2)
                        -> recommendScore.get(user2).getScore()
                        - recommendScore.get(user1).getScore());
        return userList;
    }
}

class Score7 {
    private int score;

    public Score7() {
        this.score = 0;
    }

    public void addScore(int score){
        this.score += score;
    }

    public int getScore() {
        return this.score;
    }
}


class Visitors {

    private final List<User> visitors = new ArrayList<>();

    public Visitors(List<String> visitors) {
        validateSize(visitors);
        for (String visitor : visitors) {
            User user = new User(visitor);
            this.visitors
                    .add(user);
        }
    }

    private void validateSize(List<String> visitors) {
        if (visitors.size() > 10000) {
            throw  new IllegalArgumentException("방문자는 만명 이상일 수 없습니다.");
        }
    }

    public List<User> getVisitors() {
        return this.visitors;
    }
}

class FriendMap {
    private final Map<User, Friends> friendMap;

    public FriendMap(List<List<String>> list) {
        validationSize(list);
        this.friendMap = new HashMap<>();
        setFriendMap(list);
    }

    private void validationSize(List<List<String>> list) {
        if(list.isEmpty()) {
            throw new IllegalArgumentException("친구 관계는 비어있을 수 없습니다.");
        }
        if(list.size() > 10000) {
            throw new IllegalArgumentException("친구 관계는 10000개 이하로 입력해주세요.");
        }
    }

    public Friends findFriends(User user) {
        return this.friendMap
                .get(user);
    }

    private void setFriendMap(List<List<String>> friends) {
        for (List<String> friend : friends) {
            User userA = new User(friend.get(0));
            User userB = new User(friend.get(1));
            mappingFriend(userA, userB);
            mappingFriend(userB, userA);
        }
    }

    private void mappingFriend(User userA, User userB) {
        if (!this.friendMap.containsKey(userA)) {
            Friends friends = new Friends();
            friendMap.put(userA, friends);
        }
        friendMap.get(userA)
                .addFriend(userB);
    }
}

class Friends {
    private final List<User> friends;

    public Friends() {
        friends = new ArrayList<>();
    }

    public void addFriend(User user) {
        this.friends
                .add(user);
    }

    public List<User> getFriends(){
        return this.friends;
    }
}


class User {

    private final String user;

    public User(String user) {
        validateLength(user);
        validateLowerCase(user);
        this.user = user;
    }

    private void validateLowerCase(String user) {
        for (int i = 0; i < user.length(); i++) {
            if (!Character.isLowerCase(user.charAt(i))){
                throw new IllegalArgumentException("유저 이름은 소문자만 입력할 수 있습니다.");
            }
        }
    }

    private void validateLength(String user) {
        if(user.length() < 1) {
            throw new IllegalArgumentException("유저 이름은 빈문자열일 수 없습니다.");
        }
        if (user.length() > 30) {
            throw new IllegalArgumentException("유저 이름은 30글자 이하여야 합니다.");
        }
    }

    public String getUser() {
        return this.user;
    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return user.hashCode() == ((User)obj).getUser().hashCode();
    }
}


