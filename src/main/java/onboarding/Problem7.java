package onboarding;

import java.util.*;

public class Problem7 {

    static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        HashMap<String, Set<String>> friendList = new HashMap<>();
        HashMap<String, Integer> scores = new HashMap<>();

        addFriendList(user, friends, friendList);
        addMutableFriendScore(user, friendList, scores);
        addVisitorScore(user, friendList, visitors, scores);

        answer = sortScore(scores);

        return answer;
    }

    // user 의 친구 목록
    static void addFriendList(String user, List<List<String>> friends, HashMap<String, Set<String>> friendList) {
        for(List<String> users : friends) {
            String user1 = users.get(0);
            String user2 = users.get(1);

            if(friendList.containsKey(user1)) {
                friendList.get(user1).add(user2);
            }
            if(friendList.containsKey(user2)) {
                friendList.get(user2).add(user1);
            }

            Set<String> set = new HashSet<>();
            if(!friendList.containsKey(user1)) {
                friendList.put(user1, set);
                friendList.get(user1).add(user2);
            }
            if(!friendList.containsKey(user2)) {
                friendList.put(user2, set);
                friendList.get(user2).add(user1);
            }
        }
    }

    // 함께 아는 친구 점수
    static void addMutableFriendScore(String user, HashMap<String, Set<String>> friendList,
                                    HashMap<String, Integer> scores) {
        for(String candidate : friendList.keySet()) {
            if(!candidate.equals(user) && !friendList.get(user).contains(candidate)) {
                int count = countFriendNum(user, friendList, candidate);
                scores.put(candidate, (count * 10));
            }
        }
    }

    static int countFriendNum(String user, HashMap<String, Set<String>> friendList, String candidate) {
        int count = 0;
        for(String friend : friendList.get(user)) {
            if(friendList.get(friend).contains(candidate)) count++;
        }
        return count;
    }

    // 타임라인 방문 점수
    static void addVisitorScore(String user, HashMap<String, Set<String>> friendList,
                                List<String> visitors, HashMap<String, Integer> scores) {
        List<String> temp = new ArrayList<>(visitors);
        temp.removeAll(friendList.get(user));

        for(String visitor : temp) {
            scores.put(visitor, (scores.getOrDefault(visitor, 0) + 1));
        }
    }

    // 점수를 담고 있는 HashMap을 점수에 따라 내림차순 정렬
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
