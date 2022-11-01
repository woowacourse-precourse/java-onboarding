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

    private static List<String> findMyFriends(String user, List<List<String>> AllFriends) {
        List<String> myFriends = new ArrayList<>();
        // 전체 친구들 중에 user의 친구 찾기
        AllFriends.forEach(friend -> {
            if (user.equals(friend.get(1))) {
                myFriends.add(friend.get(0));
            }
        });
        return myFriends;
    }

    private static HashMap<String, Integer> getScoreByFriends(String user, List<String> myFriends, List<List<String>> AllFriends) {
        HashMap<String, Integer> ranking = new HashMap<>();
        if (myFriends.isEmpty()) {
            return ranking;
        }
        AllFriends.forEach(friend -> {
            String name = friend.get(1);
            String friendName = friend.get(0);
            // name의 친구가 나의 친구와 친구 관계이고, name이 내가 아닐 때
            if (myFriends.contains(friendName) && !name.equals(user)) {
                // 추천 랭킹에 이미 이름이 있으면
                if (ranking.containsKey(name)) {
                    // 함께아는 친구 점수 추가
                    ranking.put(name, ranking.get(name) + FRIEND_SCORE);
                } else if(!ranking.containsKey(name)) {
                    // 그렇지 않으면 name에게 친구 추천 점수를 주고 랭킹에 등록
                    ranking.put(name, FRIEND_SCORE);
                }
            }
        });
        return ranking;
    }

    private static HashMap<String, Integer> getScoreByVisit(List<String> visitors, HashMap<String, Integer> ranking, List<String> myFriends) {
        Set<String> ranker = ranking.keySet();
        visitors.forEach(name -> {
            // 친구 추천 랭킹에 이미 이름이 있으면
            if (ranker.contains(name)) {
                // 방문 기록 점수 추가
                ranking.put(name, ranking.get(name) + VISIT_SCORE);
            }
            // 친구 추천 랭킹에 이름이 없을 때
            else if(!ranker.contains(name)) {
                // 나와 친구가 아니라면
                if(!myFriends.contains(name)) {
                    // name에 방문 기록 점수주고 친구 추천 랭킹에 등록
                    ranking.put(name, VISIT_SCORE);
                    ranker.add(name);
                }
            }
        });
        return ranking;
    }

    private static List<String> getTop5(HashMap<String,Integer> score){
        List<String> recommend = new ArrayList<>();
        // Map을 List로 변환
        String[][] scoreList = score.entrySet()
                .stream()
                .map(e -> new String[]{e.getKey(), e.getValue().toString()})
                .toArray(String[][]::new);
        // 최대 랭킹 순으로 최대 5명 추천 리스트 생성 ( 정렬 알고리즘 추가해야함 )
        for(int i = 0;i<scoreList.length;i++){
            if(i < MAX_RECOMMEND_VALUE){
                recommend.add(scoreList[i][0]);
                continue;
            }
            break;
        }
        return recommend;
    }

    private static List<String> getRecommendation(String user, List<List<String>> AllFriends, List<String> visitors) {
        List<String> myFriends = findMyFriends(user, AllFriends);
        HashMap<String, Integer> score = getScoreByVisit(visitors, getScoreByFriends(user, myFriends, AllFriends), myFriends);
        return getTop5(score);
    }




}
