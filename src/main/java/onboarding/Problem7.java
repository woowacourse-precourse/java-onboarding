package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsList;
        Map<String, Integer> score;

        friendsList = getFriendsList(friends);

        // 점수 계산
        score = calMutualFriendsScore(user, friendsList);
        score = calVisitorsScore(friendsList.get(user), visitors, score);

        return getResult(score);
    }

    // 사용자들의 친구 목록 반환 함수
    static Map<String, List<String>> getFriendsList(List<List<String>> friends) {
        Map<String, List<String>> friendsList = new HashMap<>();
        List<String> list;

        for (int i = 0; i < friends.size(); i++) {
            for (int j: Arrays.asList(0, 1)) {
                if (!friendsList.containsKey(friends.get(i).get(j))) {
                    list = new ArrayList<>();
                } else {
                    list = friendsList.get(friends.get(i).get(j));
                }
                if (j == 0) {
                    list.add(friends.get(i).get(1));
                } else {
                    list.add(friends.get(i).get(0));
                }
                friendsList.put(friends.get(i).get(j), list);
            }
        }

        return friendsList;
    }

    // 함께 아는 친구 점수 계산 함수
    static Map<String, Integer> calMutualFriendsScore(String user, Map<String, List<String>> friendsList) {
        Map<String, Integer> score = new HashMap<>();
        List<String> userFriends = friendsList.get(user);
        List<String> mutualFriends;

        for (String u_friend: userFriends) {
            mutualFriends = friendsList.get(u_friend);
            for (String m_friend: mutualFriends) {
                if (m_friend.equals(user)) {
                    continue;
                }
                if (!score.containsKey(m_friend)) {
                    score.put(m_friend, 10);
                } else {
                    score.put(m_friend, score.get(m_friend) + 10);
                }
            }
        }

        return score;
    }

    // 방문자 점수 계산 함수
    static Map<String, Integer> calVisitorsScore(List<String> userFriends, List<String> visitors, Map<String, Integer> score) {
        for (String visitor: visitors) {
            if (userFriends.contains(visitor)) {
                continue;
            }
            if (!score.containsKey(visitor)) {
                score.put(visitor, 1);
            } else {
                score.put(visitor, score.get(visitor) + 1);
            }
        }

        return score;
    }

    // 점수 내림차순 정렬 함수
    static List<Map.Entry<String, Integer>> sortingScore(Map<String, Integer> score) {
        List<Map.Entry<String, Integer>> sortedScore = new ArrayList<>(score.entrySet());
        sortedScore.sort((o1, o2) -> o2.getValue() - o1.getValue());

        return sortedScore;
    }

    // 점수를 정렬한 후 사용자 아이디를 리스트로 반환하는 함수
    static List<String> getResult(Map<String, Integer> score) {
        List<Map.Entry<String, Integer>> sortedScore;
        List<String> answer = new ArrayList<>();
        int count = 0;

        sortedScore = sortingScore(score);
        for (Map.Entry<String, Integer> entry: sortedScore) {
            if (count == 5) {
                break;
            }
            answer.add(entry.getKey());
            count++;
        }

        return answer;
    }
}
