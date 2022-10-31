package onboarding;

import java.util.*;

public class Problem7 {

    private static final int FRIEND_POINT = 10;
    private static final int VISITOR_POINT = 1;
    private static final int SUGGESTION_COUNT = 5;

    /**
     * user와 친구 관계인 유저 리스트를 찾는 기능
     *
     * @param user    찾는 유저 이름
     * @param friends 친구 관계 정보를 가지고 있는 List
     * @return user와 친구관계인 유저의 이름 List
     */
    private static List<String> getFriendList(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            if (user1.equals(user)) {
                friendList.add(user2);
            } else if (user2.equals(user)) {
                friendList.add(user1);
            }
        }
        return friendList;
    }

    /**
     * 주어진 유저들의 점수를 추가하는 함수
     *
     * @param scoreMap 유저의 점수 정보를 가지고 있는 Map
     * @param userList 점수를 추가할 대상
     * @param exceptList 점수를 추가를 제외할 유저 List
     * @param point 추가할 점수
     */
    private static void updateScore(Map<String, Integer> scoreMap, List<String> userList, List<String> exceptList, int point) {
        for (String user : userList) {
            if (exceptList.contains(user)) continue;

            int score = scoreMap.getOrDefault(user, 0);
            scoreMap.put(user, score + point);
        }
    }

    /**
     * 해당 점수의 유저 List를 반환하는 함수
     *
     * @param scoreInfo 유저의 점수 정보를 가지고 있는 Map
     * @param score     찾는 점수
     * @return 찾는 점수의 유저 이름 List
     */
    private static List<String> getScoreUserList(Map<String, Integer> scoreInfo, int score) {
        List<String> userList = new ArrayList<>();

        for (String name : scoreInfo.keySet()) {
            int userScore = scoreInfo.get(name);

            if (score != userScore) continue;

            userList.add(name);
        }
        return userList;
    }

    /**
     * 추천 점수를 내림차순으로 정렬한 List를 구하는 함수
     *
     * @param scoreInfo 유저의 점수 정보를 가지고 있는 Map
     * @return 점수 List
     */
    private static List<Integer> getSortedScoreList(Map<String, Integer> scoreInfo) {
        List<Integer> scoreList = new ArrayList<>();
        for (String name : scoreInfo.keySet()) {
            int score = scoreInfo.get(name);

            // 점수 중복을 제거
            if (scoreList.contains(score)) continue;

            scoreList.add(score);
        }
        scoreList.sort(Collections.reverseOrder());

        return scoreList;
    }

    /**
     * 추천할 친구 List를 반환하는 함수
     *
     * @param scoreInfo 유저의 점수 정보를 가지고 있는 Map
     * @return 추천할 유저 이름 List
     */
    private static List<String> extractSuggestionFriends(Map<String, Integer> scoreInfo) {
        List<Integer> scoreList = getSortedScoreList(scoreInfo);

        List<String> suggestionFriends = new ArrayList<>();
        for (int score : scoreList) {
            List<String> userList = getScoreUserList(scoreInfo, score);
            Collections.sort(userList);

            suggestionFriends.addAll(userList);

            if (suggestionFriends.size() >= SUGGESTION_COUNT) break;
        }

        if (suggestionFriends.size() >= SUGGESTION_COUNT) {
            suggestionFriends = suggestionFriends.subList(0, SUGGESTION_COUNT);
        }

        return suggestionFriends;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();

        List<String> userFriends = getFriendList(user, friends);

        List<String> exceptList = new ArrayList<>();
        exceptList.add(user);
        exceptList.addAll(userFriends);

        for (String friend : userFriends) {
            List<String> friendList = getFriendList(friend, friends);

            updateScore(scoreMap, friendList, exceptList, FRIEND_POINT);
        }

        updateScore(scoreMap, visitors, exceptList, VISITOR_POINT);

        return extractSuggestionFriends(scoreMap);
    }


}
