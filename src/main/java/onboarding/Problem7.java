package onboarding;

import java.util.*;

public class Problem7 {

    private static final int MAX_NUMBER_OF_RECOMMENDED_FRIENDS = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        Map<String, ArrayList<String>> friendsMap = new HashMap<>();    // 친구 관계 그래프
        Map<String, Integer> scoreMap = new HashMap<>();        // 친구 점수 맵

        // 친구 관계 그래프 만들기
        for (List<String> friendRelation : friends){
            addFriendsMap(friendsMap,friendRelation);
        }

        // 친구의 친구인 경우 점수 맵에 10점 추가하기
        for(Object friend : friendsMap.get(user)) {
            ArrayList<String> friendsList = friendsMap.get(friend); // 친구의 친구 목록 가져오기
            addScoresForFriend(scoreMap, friendsList);
        }

        // 방문자인 경우 친구 점수 맵에 1점 추가하기
        for(String visitor:visitors){
            addScoresForVisitor(scoreMap, visitor);
        }

        // 이미 친구 관계인 친구들, 그리고 자기 자신은 점수 맵에서 제외하기
        ArrayList<String> friendsOfUser = friendsMap.get(user);
        for(String friend :friendsOfUser) {
            excludeIfFriend(scoreMap, friend);
        }
        excludeMySelf(scoreMap, user);

        sortScoreMap(scoreMap); // 점수 내림차순, 이름 오름차순 정렬

        answer = new ArrayList<>(scoreMap.keySet()); // scoreMap에서 key(이름) 추출
        if (answer.size()>MAX_NUMBER_OF_RECOMMENDED_FRIENDS) // 최대 5개
            return answer.subList(0,MAX_NUMBER_OF_RECOMMENDED_FRIENDS);
        return answer;
    }

    private static void sortScoreMap(Map<String, Integer> scoreMap) {
        LinkedHashMap<String, Integer> sortedScoreList;
        scoreMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))  // sort by score(value) in reverse order
                .sorted(Map.Entry.comparingByKey());                            // sort by name(key)
    }

    private static void excludeMySelf(Map<String, Integer> scoreMap, String userName){
        scoreMap.remove(userName);
    }
    private static void excludeIfFriend(Map<String, Integer> scoreMap, String friendName){
        if(scoreMap.containsKey((friendName))){
            scoreMap.remove(friendName);
        }
    }

    private static void addScoresForVisitor(Map<String, Integer> scoreMap, String visitor){
        if (scoreMap.containsKey(visitor))
            scoreMap.put(visitor, scoreMap.get(visitor) + 1);
        else scoreMap.put(visitor, 1);
    }

    private static void addToScoreMap(Map<String, Integer> scoreMap, String friend){
        if(scoreMap.containsKey(friend)){
            scoreMap.put(friend, scoreMap.get(friend)+10);
        }else scoreMap.put(friend,10);
    }

    private static void addScoresForFriend(Map<String, Integer> scoreMap, List<String> friendsList) {
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
