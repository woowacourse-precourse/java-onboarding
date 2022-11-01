
package onboarding;

import java.util.*;

/*
기능 목록
1. 친구 구하기
2. 친구 추천 후보 구하기
3. 친구의 친구면 10점 추가
4. 방문자면 1점 추가
5. 정렬 - 점수 같으면 이름순, 아니면 점수순
 */
public class Problem7 {
    private static Set<String> userFriend;
    private static Set<String> candidate;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        userFriend = getMyFriend(user, friends);
        candidate = getCandidate(user, userFriend, friends, visitors);

        Map<String, Integer> candidateMap = new HashMap<>();


        for (List<String> l : friends) {
            String f1 = l.get(0);
            String f2 = l.get(1);

            plusIfFriendOfFriend(candidateMap, f1, f2);
            plusIfFriendOfFriend(candidateMap, f2, f1);
        }

        for (String v : visitors) {
            plusIfVisitor(candidateMap, v);
        }

        List<String> answer = new ArrayList<>(candidateMap.keySet());
        Collections.sort(answer, (s1, s2) -> {
            int score1 = candidateMap.get(s1);
            int score2 = candidateMap.get(s2);

            if (score1 == score2)
                return s1.compareTo(s2);
            return Integer.compare(score2, score1);
        });

        if (answer.size() > 5) {
            answer = new ArrayList<>(answer.subList(0, 5));
        }

        return answer;
    }

    private static void plusIfVisitor(Map<String, Integer> candidateMap, String v) {
        if (candidate.contains(v)) {
            candidateMap.put(v, candidateMap.getOrDefault(v, 0) + 1);
        }
    }

    private static void plusIfFriendOfFriend(Map<String, Integer> candidateMap, String f1, String f2) {
        if (candidate.contains(f1)) {
            if (userFriend.contains(f2)) {
                candidateMap.put(f1, candidateMap.getOrDefault(f1, 0) + 10);
            }
        }
    }

    private static Set<String> getCandidate(String user, Set<String> userFriend, List<List<String>> friends, List<String> visitors) {
        Set<String> candidate = new HashSet<>();

        for (List<String> l : friends) {
            String f1 = l.get(0);
            if (!userFriend.contains(f1) && !user.equals(f1)) {
                candidate.add(f1);
            }

            String f2 = l.get(1);
            if (!userFriend.contains(f2) && !user.equals(f2)) {
                candidate.add(f2);
            }
        }

        for (String v : visitors) {
            if (!user.equals(v) && !userFriend.contains(v))
                candidate.add(v);
        }

        return candidate;
    }

    private static Set<String> getMyFriend(String user, List<List<String>> friends) {
        Set<String> userFriend = new HashSet<>();

        for (List<String> l : friends) {
            String f1 = l.get(0);
            String f2 = l.get(1);

            if (f1.equals(user)) {
                userFriend.add(f2);
                continue;
            }
            if (f2.equals(user)) {
                userFriend.add(f1);
            }
        }

        return userFriend;
    }
}