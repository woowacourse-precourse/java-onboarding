package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> totalUserSet = new HashSet<>();
        Map<String, List<String>> eachUserFriendMap = new HashMap<>();
        Map<String, Integer> userScore = new HashMap<>();

        initializeTotalUserSet(friends, totalUserSet);
        initializeEachUserFriendMap(friends, totalUserSet, eachUserFriendMap);

        calculateRelationshipScore(user, eachUserFriendMap, userScore);
        calculateVisitorScore(user, visitors, eachUserFriendMap, userScore);

        List<String> keyset = sortScoreThenName(userScore);
        addMaximumFiveHighScore(answer, keyset);

        return answer;
    }

    private static void initializeTotalUserSet(List<List<String>> friends, Set<String> totalUserSet) {
        for (List<String> friend : friends) {
            totalUserSet.add(friend.get(0));
            totalUserSet.add(friend.get(1));
        }
    }

    private static void initializeEachUserFriendMap(List<List<String>> friends, Set<String> totalUserSet,
                                                    Map<String, List<String>> totalUsersFriends) {
        for (String username : totalUserSet) {
            List<String> eachUserFriends = new ArrayList<>();
            for (List<String> friend : friends) {
                if (friend.get(0).equals(username)) {
                    eachUserFriends.add(friend.get(1));
                } else if (friend.get(1).equals(username)) {
                    eachUserFriends.add(friend.get(0));
                }
            }
            totalUsersFriends.put(username, eachUserFriends);
        }
    }

    private static void calculateRelationshipScore(String user,
                                                   Map<String, List<String>> eachUserFriendMap, Map<String, Integer> userScore) {
        for (String finalUserFriend : eachUserFriendMap.get(user)) {
            for (String friend : eachUserFriendMap.get(finalUserFriend)) {
                // user 제외, user와 이미 친구인 사용자 제외
                if (!friend.equals(user) && !eachUserFriendMap.get(user).contains(friend)) {
                    // 여러 친구와 함께 아는 사용자의 경우, 기존 점수 + 10
                    if (userScore.containsKey(friend)) {
                        userScore.put(friend, userScore.get(friend) + 10);
                    } else {
                        userScore.put(friend, 10);
                    }
                }
            }
        }
    }

    private static void calculateVisitorScore(String user, List<String> visitors,
                                              Map<String, List<String>> eachUserFriendMap, Map<String, Integer> userScore) {
        for (String visitor : visitors) {
            // 이미 user와 친구라면 점수 추가 X
            if (eachUserFriendMap.get(user).contains(visitor)) {
                continue;
            }

            // user 스스로 방문한 경우, 점수 계산 X
            if (visitor.equals(user)) {
                continue;
            }

            // 타임라인에 방문한 횟수에 따라 점수 부여
            if (userScore.containsKey(visitor)) {
                userScore.put(visitor, userScore.get(visitor) + 1);
            } else {
                userScore.put(visitor, 1);
            }
        }
    }

    private static List<String> sortScoreThenName(Map<String, Integer> userScore) {
        List<String> keyset = new ArrayList<>(userScore.keySet());

        // value 정렬 -> 이름 정렬
        Collections.sort(keyset);
        keyset.sort((key1, key2) -> userScore.get(key2).compareTo(userScore.get(key1)));
        return keyset;
    }

    private static void addMaximumFiveHighScore(List<String> answer, List<String> keyset) {
        for (int i = 0; i < keyset.size(); i++) {
            if (i >= 5) {
                break;
            }
            answer.add(keyset.get(i));
        }
    }
}

