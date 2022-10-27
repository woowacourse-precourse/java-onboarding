package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 유저의 친구목록
        List<String> userFriends = new ArrayList<>();

        // 유저 친구들의 친구관계 맵
        HashMap<String, List<String>> relationMap = new HashMap<>();

        // 추천 대상 : 점수 맵
        HashMap<String, Integer> userRecomScores = new HashMap<>();

        // 유저의 친구 목록
        // 친구들의 친구들 목록(Map)
        for (List<String> relation : friends) {
            String name = relation.get(0);
            String withWho = relation.get(1);

            if (withWho.equals(user)) {
                userFriends.add(name);
            } else {
                List<String> friendsList = relationMap.getOrDefault(name, new ArrayList<>());
                friendsList.add(withWho);
                relationMap.put(name, friendsList);
            }
        }

        // 유저 친구들과 친구인 사람 (추천대상)
        for (String buddy : userFriends) {
            List<String> friendsList = relationMap.get(buddy);

            for (String target : friendsList) {

                // 이미 유저의 친구면 제외
                if (userFriends.contains(target)) {
                    continue;
                }

                int score = userRecomScores.getOrDefault(target, 0);
                score += 10;
                userRecomScores.put(target, score);
            }
        }

        // 방문자 처리
        for (String visitor : visitors) {

            // 이미 유저의 친구면 제외
            if (userFriends.contains(visitor)) {
                continue;
            }

            int score = userRecomScores.getOrDefault(visitor, 0);
            score++;
            userRecomScores.put(visitor, score);
        }

        List<String> answer = new ArrayList<>(userRecomScores.keySet());

        Collections.sort(answer, (r, l) -> {
            if (userRecomScores.get(r) == userRecomScores.get(l)) {
                return r.compareTo(l); // 점수가 같을때 이름 오름차
            } else {
                return userRecomScores.get(l) - userRecomScores.get(r); // 점수순으로
            }
        });

        return answer;
    }
}
