package onboarding;

import java.util.*;

public class Problem7 {

    private static final int FRIEND_POINT = 10;
    private static final int VISITOR_POINT = 1;
    private static final int SUGGESTION_COUNT = 5;

    /** 친구 관계 리스트를 각 유저를 Key로 가지는 친구 List Map으로 변환 */
    private static Map<String, List<String>> analyzeFirendsInfo(List<List<String>> friends) {
        Map<String, List<String>> friendsMap = new HashMap<>();

        for(List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            List<String> friend1 = friendsMap.getOrDefault(user1, new ArrayList<>());
            friend1.add(user2);
            friendsMap.put(user1, friend1);

            List<String> friend2 = friendsMap.getOrDefault(user2, new ArrayList<>());
            friend2.add(user1);
            friendsMap.put(user2, friend2);
        }

        return friendsMap;
    }

    /** 친구의 친구인 경우 친구 가산점을 추가하는 함수*/
    private static void updateFriendsScore(String user, Map<String, List<String>> friendsMap, Map<String, Integer> scoreInfo) {
        List<String> userFriends = friendsMap.getOrDefault(user, new ArrayList<>());

        for(String friendName : userFriends) {
            List<String> shareFriends = friendsMap.getOrDefault(friendName, new ArrayList<>());

            for(String shareFriendName : shareFriends) {
                if(shareFriendName.equals(user)) continue;

                int score = scoreInfo.getOrDefault(shareFriendName, 0);
                scoreInfo.put(shareFriendName, score + FRIEND_POINT);
            }
        }

    }

    /** 방문자의 방문 가산점을 추가하는 함수 */
    private static void updatVisitorScore(Map<String, Integer> scoreInfo, List<String> userFriends, List<String> visitors) {
        for(String visitorName : visitors) {
            if(userFriends.contains(visitorName)) continue;

            int score = scoreInfo.getOrDefault(visitorName, 0);
            scoreInfo.put(visitorName, score + VISITOR_POINT);
        }

    }

    /** 해당 점수의 유저 List를 반환하는 함수 */
    private static List<String> getScoreUserList(Map<String, Integer> scoreInfo, int score) {
        List<String> userList = new ArrayList<>();

        for(String name : scoreInfo.keySet()) {
            int userScore = scoreInfo.get(name);

            if(score == userScore) {
                userList.add(name);
            }
        }
        return userList;
    }

    /** 추천 점수를 내림차순으로 정렬한 List를 구하는 함수 */
    private static List<Integer> getSortedScoreList(Map<String, Integer> scoreInfo) {
        List<Integer> scoreList = new ArrayList<>();
        for(String name : scoreInfo.keySet()) {
            int score = scoreInfo.get(name);

            if(scoreList.contains(score)) continue;

            scoreList.add(score);
        }
        scoreList.sort(Collections.reverseOrder());

        return scoreList;
    }

    /** 추천할 친구 List를 반환하는 함수 */
    private static List<String> extractSuggestionFriends(Map<String, Integer> scoreInfo) {
        List<Integer> scoreList = getSortedScoreList(scoreInfo);

        List<String> answer = new ArrayList<>();
        for(int score : scoreList) {
            List<String> userList = getScoreUserList(scoreInfo, score);
            Collections.sort(userList);

            answer.addAll(userList);

            if(answer.size() >= SUGGESTION_COUNT) break;
        }

        if(answer.size() >= SUGGESTION_COUNT) {
            answer = answer.subList(0, SUGGESTION_COUNT);
        }

        return answer;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsMap = analyzeFirendsInfo(friends);

        Map<String, Integer> scoreMap = new HashMap<>();
        updateFriendsScore(user, friendsMap, scoreMap);
        updatVisitorScore(scoreMap, friendsMap.getOrDefault(user, new ArrayList<>()), visitors);

        return extractSuggestionFriends(scoreMap);
    }
}
