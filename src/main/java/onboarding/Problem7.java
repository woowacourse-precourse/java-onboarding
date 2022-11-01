package onboarding;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Comparator;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scores = new HashMap<>(); // id를 key로, 점수를 value로 하는 Map

        List<String> friendsList = pickUserFriends(user, friends); // 해당 사용자와 친구 상태 id 목록

        recordFriendsScore(scores, friendsList, friends, user); // 친구의 친구에 대한 점수 계산
        recordVisitorScore(scores, visitors, friendsList); // 타임라인에 방문한 것에 대한 점수 계산

        /* id-점수 Map의 key-value값을 value에 내림차순, 같을 경우 key에 오름차순으로 정렬한 List */
        List<Map.Entry<String,Integer>> scoreMapEntryList = sortScoreMapList(scores);

        return pickBestFiveRecommendation(scoreMapEntryList); // 정렬된 List에서 점수가 0점보다 높은 사용자중 최대 5명을 뽑은 List
    }

    /* 누군가가 주어졌을 때 길이 2인 List에 없으면 "", 있으면 나머지 한명 반환하는 메서드 */
    private static String pickAnotherOne(List<String> friendPair, String someone) {
        int index;
        if (!(friendPair.contains(someone))) {
            return "";
        }

        index = friendPair.indexOf(someone);
        String friend = friendPair.get(1-index);
        return friend;
    }

    /* friends 목록을 순회하면서 유저의 친구를 뽑아내 List로 반환하는 메서드 */
    private static List<String> pickUserFriends(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (List<String> friendPair : friends) {
            String someone = pickAnotherOne(friendPair, user);

            if (!(someone.equals(""))) {
                result.add(someone);
            }
        }

        return result;
    }

    /* 주어진 아이디를 key로 하는 Map에 원하는 만큼 점수 추가 하는 메서드 */
    private static void incrementScore(Map<String, Integer> score, String id, int scoreAmount) {
        int point = score.getOrDefault(id, 0) + scoreAmount;
        score.put(id, point);
    }

    /* 사용자의 친구의 친구를 찾아 그 사람들에게 10점씩 추가하고 Map에 기록하는 메서드 */
    private static void recordFriendsScore(Map<String, Integer> scores, List<String> userFriends, List<List<String>> friends, String user) {
        for (String friend : userFriends) {
            for (List<String> friendPair : friends) {
                String someone = pickAnotherOne(friendPair, friend);

                if (!(someone.equals("")) && !(someone.equals(user))) {
                    incrementScore(scores, someone, 10);
                }
            }
        }
    }
    /* 방문자 List를 순회하면서 그 사람의 점수를 1점씩 올려주고 Map에 기록하는 메서드 */
    private static void recordVisitorScore(Map<String, Integer> scores, List<String> visitors, List<String> userFriend) {
        for (String visitor : visitors) {

            /* 이미 친구인 id를 무시 */
            if (userFriend.contains(visitor)) {
                continue;
            }
            incrementScore(scores, visitor, 1);
        }
    }

    /* Map의 value를 기준으로 내림차순 정렬, 동점이라면 key를 기준으로 오름차순 정렬하는 Compartor */
    private static Comparator<Map.Entry<String, Integer>> downToScoreUptoId = new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> leftId, Map.Entry<String, Integer> rightId) {
            int leftScore = leftId.getValue();
            int rightScore = rightId.getValue();

            if (leftScore == rightScore) {

                String leftName = leftId.getKey();
                String rightName = rightId.getKey();

                return leftName.compareTo(rightName);
            }
            return (rightScore - leftScore);
        }
    };

    /* 아이디-점수 Map을 value를 기준으로 내림차순 정렬, 동점이라면 key를 기준으로 오름차순 정렬 된 List 형태로 반환 */
    private static List<Map.Entry<String,Integer>> sortScoreMapList(Map<String, Integer> scores) {
        Set<Map.Entry<String, Integer>> scoresEntrySet = scores.entrySet();
        List<Map.Entry<String,Integer>> idScoreList = new ArrayList<>(scoresEntrySet);

        idScoreList.sort(downToScoreUptoId);

        return idScoreList;
    }

    /* 0점보다 높은 점수를 가진 id 중에서 최대 다섯개를 선택해 List 타입으로 반환하는 메서드 */
    private static List<String> pickBestFiveRecommendation(List<Map.Entry<String,Integer>> sortedIdList) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            try {
                Map.Entry<String,Integer> element = sortedIdList.get(i);
                String id = element.getKey();
                int score = element.getValue();

                if (score > 0) {
                    result.add(id);
                }
            } catch(IndexOutOfBoundsException exception) {
                break;
            }
        }

        return result;
    }
}
