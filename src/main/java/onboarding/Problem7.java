package onboarding;

import java.util.*;

class User {
    private final int TEN_POINT = 10;
    private final int ONE_POINT = 1;

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
        this.score += TEN_POINT;
    }

    public void addOnePoint() {
        this.score += ONE_POINT;
    }
}

public class Problem7 {

    private static final int ANSWER_MAX_SIZE = 5;

    private static Map<String, User> userList = new HashMap<>();
    private static List<String> answer = new ArrayList<>();

    public static List<String> solution(String mainUserId, List<List<String>> friends, List<String> visitors) {
        initUserList(friends, visitors);                // 유저 리스트 초기화
        initFriends(friends);                           // 각 유저의 친구 리스트 초기화

        scoring(mainUserId, visitors);                  // 모든 유저 점수 부여
        List<User> sortedUserList = sortScoreAndId();      // 점수 > 이름 순으로 유저 리스트 정렬
        makeAnswer(mainUserId, sortedUserList);         // 조건에 맞게 answer 리스트에 추가
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

    public static List<User> sortScoreAndId() {
        List<User> result = new ArrayList<>(userList.values());

        Collections.sort(result, (userA, userB) -> {
            if (userA.getScore() == userB.getScore())
                return userA.getId().compareTo(userB.getId());
            return -(userA.getScore() - userB.getScore());
        });

        return result;
    }

    public static void makeAnswer(String mainUserId, List<User> sortedUserList) {
        int answerSize = 0;
        User mainUser = userList.get(mainUserId);

        for (User user : sortedUserList) {
            if(answerSize > ANSWER_MAX_SIZE)
                return;

            List<User> friends = user.getFriends();
            if (!friends.contains(mainUser) && user != mainUser) {
                answer.add(user.getId());
                answerSize++;
            }
        }
    }
}
