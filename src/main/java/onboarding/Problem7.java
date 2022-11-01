package onboarding;

import java.util.*;

public class Problem7 {
    private static final Integer FRIEND_SCORE = 10;
    private static final Integer VISIT_SCORE = 1;
    private static final Integer MAX_RECOMMEND_VALUE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = getRecommendation(user, friends, visitors);
        return answer;
    }

    // 친구 추천 받기 기능
    private static List<String> getRecommendation(String user, List<List<String>> AllFriends, List<String> visitors) {
        List<String> myFriends = findMyFriends(user, AllFriends);
        HashMap<String, Integer> score = getScoreByVisit(visitors, getScoreByFriends(user, myFriends, AllFriends), myFriends);
        return getTop5(score);
    }

    // 전체 친구들 중에 user의 친구 찾기
    private static List<String> findMyFriends(String user, List<List<String>> AllFriends) {
        List<String> myFriends = new ArrayList<>();
        AllFriends.forEach(friend -> {
            if (user.equals(friend.get(1))) {
                myFriends.add(friend.get(0));
            }
        });
        return myFriends;
    }

    // 함께아는 친구 점수 추가 기능
    private static HashMap<String, Integer> getScoreByFriends(String user, List<String> myFriends, List<List<String>> AllFriends) {
        HashMap<String, Integer> ranking = new HashMap<>();
        if (myFriends.isEmpty()) {
            return ranking;
        }
        AllFriends.forEach(friend -> {
            String name = friend.get(1); // 이름
            String friendName = friend.get(0); // name의 친구 이름
            if (myFriends.contains(friendName) && !name.equals(user)) {
                if (ranking.containsKey(name)) {
                    ranking.put(name, ranking.get(name) + FRIEND_SCORE);
                } else if (!ranking.containsKey(name)) {
                    ranking.put(name, FRIEND_SCORE);
                }
            }
        });
        return ranking;
    }

    // 방문자 점수 추가 기능
    private static HashMap<String, Integer> getScoreByVisit(List<String> visitors, HashMap<String, Integer> ranking, List<String> myFriends) {
        visitors.forEach(name -> {
            if (ranking.keySet().contains(name)) {
                ranking.put(name, ranking.get(name) + VISIT_SCORE);
            }
            else if (!ranking.keySet().contains(name)) {
                if (!myFriends.contains(name)) {
                    ranking.put(name, VISIT_SCORE);
                }
            }
        });
        return ranking;
    }

    // 추천 친구 랭킹에서 점수가 높은 최대 5명의 친구 추천
    private static List<String> getTop5(HashMap<String, Integer> score) {
        List<String> recommend = new ArrayList<>();
        String[][] scoreList = ScoreMapToList(score);
        List<String> ranking = sortRanking(scoreList);
        for (int i = 0; i < ranking.size(); i++) {
            if (i < MAX_RECOMMEND_VALUE) {
                recommend.add(ranking.get(i));
                continue;
            }
            break;
        }
        return recommend;
    }

    private static String[][] ScoreMapToList(HashMap<String, Integer> score) {
        String[][] scoreList = score.entrySet()
                .stream()
                .map(e -> new String[]{e.getKey(), e.getValue().toString()})
                .toArray(String[][]::new);
        return scoreList;
    }

    // 점수 내림차순, 이름 오름차순으로 랭킹 정렬
    private static List<String> sortRanking(String[][] scoreList) {
        List<String> ranker = new ArrayList<>();
        Arrays.sort(scoreList, (o1, o2) -> {
            if (o1[1].contentEquals(o2[1]))
                return o1[0].compareTo(o2[0]);
            else
                return o1[1].compareTo(o2[1]);
        });
        for (int i = 0; i < scoreList.length; i++) {
            ranker.add(scoreList[i][0]);
        }
        return ranker;
    }
}