package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(); // 정답을 return 할 리스트
        Map<String, ArrayList<String>> friendList = new HashMap<>(); // 각 이용자 별 친구 목록
        Map<String, Integer> scores = new HashMap<>();  // 추천 점수 계산 (user 의 친구는 제외함)

        for(List<String> f : friends) {
            String user1 = f.get(0);
            String user2 = f.get(1);

            friendList.put(user1, friendList.getOrDefault(user1, new ArrayList<>()));
            friendList.put(user2, friendList.getOrDefault(user2, new ArrayList<>()));
            friendList.get(user1).add(user2);
            friendList.get(user2).add(user1);

            if(user1.equals(user) || user2.equals(user)) continue;
            if(!scores.containsKey(user1)) scores.put(user1, 0);
            if(!scores.containsKey(user2)) scores.put(user2, 0);
        }

        // 함께 아는 친구의 수
        for(String candidate : scores.keySet()) {
            int count = 0;
            for(String friend : friendList.get(user)) {
                if(friendList.get(friend).contains(candidate)) count++;
            }
            scores.put(candidate, (scores.get(candidate) + (10 * count))); // 기존 점수 + (10 * 함께 아는 친구 수)
        }

        // 방문한 횟수
        for(String visitor : visitors) {
            scores.put(visitor, (scores.getOrDefault(visitor, 0) + 1));
        }

        List<Map.Entry<String, Integer> > scoreList = new LinkedList<>(scores.entrySet());

        // 새로 만든 리스트를 주어진 조건에 따라 정렬
        Collections.sort(scoreList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                if(o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey()); // 점수가 같으면 이름순으로 정렬
                }
                return o2.getValue().compareTo(o1.getValue()); // 점수를 내림차순으로 정렬
            }
        });

        int cnt = 0; // 추천한 횟수 카운트
        Map<String, Integer> temp = new HashMap<String, Integer>();
        for (Map.Entry<String, Integer> candidate : scoreList) {
            if(friendList.get(user).contains(candidate.getKey())) continue;
            if(cnt == 5) break;                  // 5명 추천이 끝났으면 실행 종료
            if(candidate.getValue() == 0) break; // 추천 점수가 0점이면 실행 종료
            answer.add(candidate.getKey());      // 정답 리스트에 추천 친구의 이름 추가
            cnt++;
        }

        return answer;
    }
}
