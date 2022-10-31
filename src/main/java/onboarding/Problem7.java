package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> friendsDic = new HashMap<>();
        Map<String, Integer> scores = new HashMap<>();
        visitors = new ArrayList<>(visitors);

        // 친구 정보를 dic에 담는 반복문
        for (List<String> f:friends) {
            String friend1 = f.get(0);
            String friend2 = f.get(1);

            List<String> friend1List = new ArrayList<>();
            List<String> friend2List = new ArrayList<>();

            if (!friend2.equals(user)) {                        // 넣을 사람이 user일 경우 제외
                if (friendsDic.containsKey(friend1)) {
                    friend1List = friendsDic.get(friend1);
                }
                friend1List.add(friend2);
                friendsDic.put(friend1, friend1List);           // 첫 번째 친구 목록에 두 번째 친구 넣기
            }

            if (!friend1.equals(user)) {                        // 넣을 사람이 user일 경우 제외
                if (friendsDic.containsKey(friend2)) {
                    friend2List = friendsDic.get(friend2);
                }
                friend2List.add(friend1);
                friendsDic.put(friend2, friend2List);           // 두 번째 친구 목록에 첫 번째 친구 넣기
            }
        }

        // 함께 아는 친구의 score +10점 올리기
        List<String> userFriends = new ArrayList<>();
        if (friendsDic.containsKey(user)) {                     // user가 친구를 가지고 있는 경우
            userFriends = friendsDic.get(user);
            for (String u : userFriends) {
                List<String> friendFriends = friendsDic.get(u);

                for (int i = 0; i < friendFriends.size(); i++) {
                    String name = friendFriends.get(i);
                    int score = 0;

                    if (scores.containsKey(name)) {
                        score = scores.get(name);
                    }
                    score += 10;
                    scores.put(name, score);
                }
            }
        }

        // 타임라인에 방문한 친구 +1점 올리기
        for (String v:visitors) {
            int score = 0;
            if (scores.containsKey(v)) {
                score = scores.get(v);
            }
            score += 1;
            scores.put(v, score);
        }

        // 정렬
        Map<String, Integer> sortedMap = new TreeMap<>(scores);                                 // 키 기준 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(sortedMap.entrySet());
        entryList.sort(((o2, o1) -> sortedMap.get(o1.getKey()) - sortedMap.get(o2.getKey())));  // 값 기준 정렬

        // answer에 점수가 높은 순대로 이름 넣기
        for (Map.Entry<String, Integer> e:entryList) {
            String key = e.getKey();

            if(!userFriends.contains(key)) {                    // user의 친구일 경우 제외
                answer.add(key);
            }
        }

        return answer;
    }
}
