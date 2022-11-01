package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, Integer> recFriendScores = new HashMap<>(); //추천 친구별 점수 Map(key: id, val: score)
        HashSet<String> userFriends = new HashSet<>(); //user의 친구 Set

        for (int i = 0; i < friends.size(); i++) {
            userFriends.add(friends.get(i).get(0));
        }

        //친구의 친구 10점씩
        for (int i = 0; i < friends.size(); i++) {
            if (!friends.get(i).get(1).equals(user) && !userFriends.contains(friends.get(i).get(1))) {
                if (recFriendScores.containsKey(friends.get(i).get(1))) {
                    int temp = recFriendScores.get(friends.get(i).get(1)) + 10;
                    recFriendScores.put(friends.get(i).get(1), temp);
                } else {
                    recFriendScores.put(friends.get(i).get(1), 10);
                }
            }
        }

        //방문자 1점씩
        for (int i = 0; i < visitors.size(); i++) {
            if (!userFriends.contains(visitors.get(i))) {
                if (recFriendScores.containsKey(visitors.get(i))) {
                    int temp = recFriendScores.get(visitors.get(i)) + 1;
                    recFriendScores.put(visitors.get(i), temp);
                } else {
                    recFriendScores.put(visitors.get(i), 1);
                }
            }
        }
        // recFriendScores Map 완성 (이름 + 점수)

        // map의 정보를 리스트에 복사.
        List<Map.Entry<String, Integer>> recFriendScoresList = new ArrayList<Map.Entry<String, Integer>>(recFriendScores.entrySet());

        // top5 점수순대로 내림차순 정렬
        Collections.sort(recFriendScoresList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });


        // 같은 점수일 경우 sameScoreId 에 넣어서 오름차순으로 id 출력
        List<String> sameScoreId = new ArrayList<>();

        int score = recFriendScoresList.get(0).getValue();
        for (int i = 0; i < 5; i++) {
            if (recFriendScoresList.size() - 1 < i || recFriendScoresList.get(i).getValue() == 0) {
                break;
            } else if (recFriendScoresList.get(i).getValue() != score) {
                Collections.sort(sameScoreId);
                for (int j = 0; j < sameScoreId.size(); j++) {
                    answer.add(sameScoreId.get(j));
                }
                sameScoreId.clear();

                answer.add(recFriendScoresList.get(i).getKey());
                score = recFriendScoresList.get(i).getValue();
            } else {
                sameScoreId.add(recFriendScoresList.get(i).getKey());
            }
        }
        if (!sameScoreId.isEmpty()) {
            for (int i = 0; i < sameScoreId.size(); i++) {
                answer.add(sameScoreId.get(i));
            }
        }

        return answer;
    }
}
