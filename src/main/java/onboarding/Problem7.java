package onboarding;

import java.util.*;

public class Problem7 {

    private static final int MAX_NUMBER_OF_RECOMMENDED_FRIENDS = 5;
    private static final int POINTS_FOR_VISITORS = 1;
    private static final int POINTS_FOR_FRIEND_OF_FRIEND = 10;

    // 친구 추천 클래스
    static class UserPoint {
        String name;
        int point;

        public UserPoint(String name, int point) {
            this.name = name;
            this.point = point;
        }

        public void addPoint(int added) {
            this.point += added;
        }

        public void addPointsForVisitor() {
            this.point += POINTS_FOR_VISITORS;
        }

        public void addPointsForFriendOfFriend() {
            this.point += POINTS_FOR_FRIEND_OF_FRIEND;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, ArrayList<String>> friendsMap = new HashMap<>();    // 친구 관계 그래프
        List<UserPoint> pointMap = new ArrayList<>();                   // 친구 점수 맵

        pointMap.add(new UserPoint(user, 0));

        // 친구 관계 그래프 만들기
        for (List<String> friendRelation : friends) {
            addFriendsMap(friendsMap, friendRelation);
        }

        // 친구의 친구인 경우 점수 맵에 10점 추가하기
        for (Object friend : friendsMap.get(user)) {
            ArrayList<String> friendsList = friendsMap.get(friend); // 친구의 친구 목록 가져오기
            addPointsForFriend(pointMap, friendsList);
        }

        // 방문자인 경우 친구 점수 맵에 1점 추가하기
        for (String visitor : visitors) {
            addPointsForVisitor(pointMap, visitor);
        }

        sortPointMap(pointMap); // score 기준 내림차순 정렬 (+name 기준 오름차순 정렬)

        // 이미 친구 관계인 친구들, 그리고 자기 자신은 제외하여 scoreMap을 answer 리스트에 추가하기
        ArrayList<String> friendsOfUser = friendsMap.get(user);
        for (UserPoint friend : pointMap) {
            if(!(friendsOfUser.contains(friend.name) || friend.name.equals(user))) {
                answer.add(friend.name);
            }
        }
        if (answer.size() > MAX_NUMBER_OF_RECOMMENDED_FRIENDS) // 최대 5개
            return answer.subList(0, MAX_NUMBER_OF_RECOMMENDED_FRIENDS);
        return answer;
    }

    private static void sortPointMap(List<UserPoint> pointMap) {
        pointMap.sort((user1, user2) -> {
            if (user1.point == user2.point) {
                return user1.name.compareTo(user2.name);
            }
            return user2.point - user1.point;
        });
    }

    private static void addPointsForVisitor(List<UserPoint> scoreMap, String visitor){
        Optional<UserPoint> user = scoreMap.stream().filter(u -> u.name.equals(visitor)).findFirst();
        if(user.isEmpty()) {
            scoreMap.add(new UserPoint(visitor, 1));
        }else{
            user.get().addPointsForVisitor();
        }
    }

    private static void addToPointsMap(List<UserPoint> pointMap, String friend){
        Optional<UserPoint> user = pointMap.stream().filter(u -> u.name.equals(friend)).findFirst();
        if(user.isEmpty()) {
            pointMap.add(new UserPoint(friend, 10));
        }else{
            user.get().addPointsForFriendOfFriend();
        }
    }

    private static void addPointsForFriend(List<UserPoint> pointMap, List<String> friendsList) {
        for (String friend : friendsList) {
            addToPointsMap(pointMap, friend);
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
