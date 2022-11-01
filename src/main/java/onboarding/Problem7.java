package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        ArrayList friendsList = new ArrayList();
        ArrayList friendsOfAFriends = new ArrayList();
        HashMap<String, Integer> friendCandidates = new HashMap<>();

        // 친구 리스트 저장
        for (List<String> e : friends) {
            if (e.size() == 2) {
                if (e.get(0) == user) {
                    friendsList.add(e.get(1));
                }
                if (e.get(1) == user) {
                    friendsList.add(e.get(0));
                }
            }
        }

        // 친구의 친구 리스트 저장
        for (int i = 0; i < friendsList.size(); i++) {
            for (List<String> e : friends) {
                // 친구의 친구 리스트에 user와 친구가 포함되면 안되는 조건
                if (e.get(0) == friendsList.get(i) && e.get(1) != user && !friendsList.contains(e.get(1))) {
                    friendsOfAFriends.add(e.get(1));
                }
                if (e.get(1) == friendsList.get(i) && e.get(0) != user && !friendsList.contains(e.get(0))) {
                    friendsOfAFriends.add(e.get(0));
                }
            }
        }

        // 친구의 친구 점수
        for (int i = 0; i < friendsOfAFriends.size(); i++) {
            if (!friendCandidates.containsKey(friendsOfAFriends.get(i))) {
                friendCandidates.put((String) friendsOfAFriends.get(i), 10);
            } else {
                friendCandidates.replace((String) friendsOfAFriends.get(i), friendCandidates.get(friendsOfAFriends.get(i)) + 10);
            }
        }

        // 방문자 점수
        for (int i = 0; i < visitors.size(); i++) {
            // 방문자에서 이미 친구인 사람 제거
            if (friendsList.contains(visitors.get(i))) {
                continue;
            }
            if (friendCandidates.containsKey(visitors.get(i))) {
                friendCandidates.replace(visitors.get(i), friendCandidates.get(visitors.get(i)) + 1);
            } else {
                friendCandidates.put(visitors.get(i), 1);
            }
        }

        // HashMap => Set
        Set<Map.Entry<String, Integer>> entrySet = friendCandidates.entrySet();

        // Set을 리스트로 저장
        List<Map.Entry<String, Integer>> friendCandidatesList = new ArrayList<>(entrySet);

        // 선정된 후보자 수
        int cnt = 0;

        List<String> tmp = new ArrayList<>();
        List<String> result = new ArrayList<>();

        while (cnt <= 5 && friendCandidatesList.size() > 0) {

            int maxValue = Collections.max(friendCandidates.values());

            for (int i = 0; i < friendCandidatesList.size(); i++) {
                if (friendCandidatesList.get(i).getValue() == maxValue) {
                    // 현재 max 점수인 후보자 tmp에 저장
                    tmp.add(friendCandidatesList.get(i).getKey());
                    cnt++;

                    // 선정된 후보자 제거
                    friendCandidates.remove(friendCandidatesList.get(i).getKey());
                    friendCandidatesList.remove(i);
                    i--;
                }
            }

            // 알파벳순 정렬
            Collections.sort(tmp);

            // 선정된 후보자 저장
            if (cnt <= 5) {
                result.addAll(tmp);
            }

            tmp.clear();
        }

        return result;
    }
}

