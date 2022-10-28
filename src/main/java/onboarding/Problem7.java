package onboarding;

import java.util.*;

class User {
    private String id;
    private int score;
    private List<User> friends;

    public User(String id) {
        this.id = id;
        this.score = 0;
        this.friends = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void addFriend(User user) {
        this.friends.add(user);
    }

    public void addTenPoints() {
        this.score += 10;
    }

    public void addOnePoint() {
        this.score += 1;
    }
}

public class Problem7 {

    private static Map<String, User> userList = new HashMap<>();
    private static List<String> answer = new ArrayList<>();

    public static List<String> solution(String mainUserId, List<List<String>> friends, List<String> visitors) {
        return answer;
    }

    public static void initUserList(List<List<String>> friends, List<String> visitors) {
        for (List<String> data : friends) {
            for (String id : data) {
                if(!userList.containsKey(id)) {
                    userList.put(id, new User(id));
                }
            }
        }

        for (String id : visitors) {
            if (!userList.containsKey(id)) {
                userList.put(id, new User(id));
            }
        }
    }

    public static void initFriends(List<List<String>> friends) {
        for (List<String> data : friends) {
            String idA = data.get(0);
            String idB = data.get(1);
            User userA = userList.get(idA);
            User userB = userList.get(idB);

            userA.addFriend(userB);
            userB.addFriend(userA);
        }
    }

    public static void scoring(String mainUserId, List<String> visitors) {
        User mainUser = userList.get(mainUserId);

        // 사용자와 함께 아는 친구
        for (User currentUser : userList.values()) {
            if (currentUser.getId() != mainUserId) { // 사용 유저가 아니면
                for (User targetUser : currentUser.getFriends()) { // 현재 유저의 친구 리스트돌면서
                    List<User> targetFriends = targetUser.getFriends();
                    if (targetFriends.contains(mainUser)) { // 친구의 친구에 mainUser가 있다면
                        currentUser.addTenPoints();
                    }
                }
            }
        }

        // 타임라인에 방문한 점수
        for (String id : visitors) {
            User user = userList.get(id);
            user.addOnePoint();
        }
    }

    public static List<User> sortScoreId() {
        List<User> result = (List<User>) userList.values();

        Collections.sort(result, (userA, userB) -> {
            if (userA.getScore() == userB.getScore()) {
                return userA.getId().compareTo(userB.getId());
            }
            return userA.getScore() - userB.getScore();
        });

        return result;
    }

    public static void makeAnswer(String mainUserId, List<User> sortedUserList) {
        int answerSize = 0;
        User mainUser = userList.get(mainUserId);

        for (User user : sortedUserList) {
            if(answerSize > 5)
                return;

            List<User> friends = user.getFriends();
            if (!friends.contains(mainUser)) {
                answer.add(user.getId());
                answerSize++;
            }
        }
    }
}
