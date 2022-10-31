package onboarding;

import java.util.*;

public class Problem7 {

    static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        List<String> friendList = new ArrayList<>();
        HashMap<String, Integer> scores = new HashMap<>();

        addFriendList(user, friends, friendList);
        addMutableFriendScore(user, friendList, friends, scores);
        addVisitorScore(friendList, visitors, scores);
        answer = sortScore(scores);

        return answer;
    }

    static void addFriendList(String user, List<List<String>> friends, List<String> friendList) {
        for(List<String> users : friends) {
            String user1 = users.get(0);
            String user2 = users.get(1);

            if(user1.equals(user)) friendList.add(user2);
            if(user2.equals(user)) friendList.add(user1);
        }
    }

    static void addMutableFriendScore(String user, List<String> friendList,
                                    List<List<String>> friends, HashMap<String, Integer> scores) {
        for(List<String> list : friends) {
            String user1 = list.get(0);
            String user2 = list.get(1);

            if(!user1.equals(user) && !friendList.contains(user1)) {
                scores.put(user1, (scores.getOrDefault(user1, 0) + 10));
            }
            if(!user2.equals(user) && !friendList.contains(user2)) {
                scores.put(user2, (scores.getOrDefault(user2, 0) + 10));
            }
        }
    }

    static void addVisitorScore(List<String> friendList, List<String> visitors, HashMap<String, Integer> scores) {
        List<String> temp = new ArrayList<>(visitors);
        temp.removeAll(friendList);

        for(String visitor : temp) {
            scores.put(visitor, (scores.getOrDefault(visitor, 0) + 1));
        }
    }

    static List<String> sortScore(HashMap<String, Integer> scores) {
        List<String> answer = new ArrayList<>();

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
            if(cnt == 5) break;                  // 5명 추천이 끝났으면 실행 종료
            if(candidate.getValue() == 0) break; // 추천 점수가 0점이면 실행 종료
            answer.add(candidate.getKey());      // 정답 리스트에 추천 친구의 이름 추가
            cnt++;
        }

        return answer;
    }
}
