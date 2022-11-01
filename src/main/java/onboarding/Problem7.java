package onboarding;

import java.util.*;

public class Problem7 {

    private static final int MAX_NUMBER_OF_RECOMMENDED_FRIENDS = 5;

    static class UserScore {
        String name;
        int score;

        public UserScore(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public void addScore(int added) {
            this.score += added;
        }

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, ArrayList<String>> friendsMap = new HashMap<>();    // 친구 관계 그래프
        List<UserScore> scoreMap = new ArrayList<>();                   // 친구 점수 맵

        scoreMap.add(new UserScore(user, 0));

        // 친구 관계 그래프 만들기
        for (List<String> friendRelation : friends) {
            addFriendsMap(friendsMap, friendRelation);
        }

        // 친구의 친구인 경우 점수 맵에 10점 추가하기
        for (Object friend : friendsMap.get(user)) {
            ArrayList<String> friendsList = friendsMap.get(friend); // 친구의 친구 목록 가져오기
            addScoresForFriend(scoreMap, friendsList);
        }

        // 방문자인 경우 친구 점수 맵에 1점 추가하기
        for (String visitor : visitors) {
            addScoresForVisitor(scoreMap, visitor);
        }

        sortScoreMap(scoreMap); // score 기준 내림차순 정렬 (+name 기준 오름ㅊ차순 정렬)

        // 이미 친구 관계인 친구들, 그리고 자기 자신은 점수 맵에서 제외하기
        ArrayList<String> friendsOfUser = friendsMap.get(user);
        for (UserScore friend : scoreMap) {
            if (!(friendsOfUser.contains(friend.name) || friend.name.equals(user))) {
                answer.add(friend.name);
            }
        }

        if (answer.size() > MAX_NUMBER_OF_RECOMMENDED_FRIENDS) // 최대 5개
            return answer.subList(0, MAX_NUMBER_OF_RECOMMENDED_FRIENDS);
        return answer;
    }

    private static void sortScoreMap(List<UserScore> scoreMap) {
        scoreMap.sort((user1, user2) -> {
            if (user1.score == user2.score) {
                return user1.name.compareTo(user2.name);
            } else {
                return user2.score - user1.score;
            }
        });
    }

    private static void addScoresForVisitor(List<UserScore> scoreMap, String visitor){
        Optional<UserScore> user = scoreMap.stream().filter(u -> u.name.equals(visitor)).findFirst();
        if(user.isEmpty()) {
            scoreMap.add(new UserScore(visitor, 1));
        }else{
            user.get().addScore(1);
        }
    }

    private static void addToScoreMap(List<UserScore> scoreMap, String friend){
        Optional<UserScore> user = scoreMap.stream().filter(u -> u.name.equals(friend)).findFirst();
        if(user.isEmpty()) {
            scoreMap.add(new UserScore(friend, 10));
        }else{
            System.out.println(user.get().name + "를 찾습니다");
            user.get().addScore(10);
        }
    }

    private static void addScoresForFriend(List<UserScore> scoreMap, List<String> friendsList) {
        for (String friend : friendsList) {
            addToScoreMap(scoreMap, friend);
        }
    }

    private static void addFriendsList(Map<String, ArrayList<String>> friendsMap, String key, String value) {
        ArrayList<String> friendsList = new ArrayList<>();
        if (friendsMap.containsKey(key)) {
            friendsList = friendsMap.get(key);
            friendsList.add(value);
        } else friendsList.add(value);
        friendsMap.put(key, friendsList);
    }

    private static void addFriendsMap(Map<String, ArrayList<String>> friendsMap, List<String> friends){
        addFriendsList(friendsMap, friends.get(0), friends.get(1));
        addFriendsList(friendsMap, friends.get(1), friends.get(0));
    }
}
