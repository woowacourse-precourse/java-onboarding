package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> friendList = classifyPeople(user, friends, visitors).get(0);
        List<String> nonFriendList = classifyPeople(user, friends, visitors).get(1);

        Map<String, Integer> nonFriendScore = new HashMap<>();
        for (String nonFriend : nonFriendList) {
            nonFriendScore.put(nonFriend, 0);
        }

        Map<String, Integer> calcResult = calcScore(nonFriendScore, user, friends, friendList, visitors);

        for (String nonFriend : calcResult.keySet()) {
            if (calcResult.get(nonFriend) == 0) {
                calcResult.remove(nonFriend);
            }
        }

        List<String> keySetList = new ArrayList<>(calcResult.keySet());
        // 내림차순 //
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (calcResult.get(o1) == calcResult.get(o2)) {
                    //
                }
                return calcResult.get(o2).compareTo(calcResult.get(o1));
            }
        });

        int maxCnt = 0;
        for(String key : keySetList) {
            answer.add(key);
            maxCnt++;
            if(maxCnt == 5) {
                break;
            }
        }
        return answer;
    }

    private static List<List<String>> classifyPeople(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendList = new ArrayList<>();
        List<String> nonFriendList = new ArrayList<>();
        for (List<String> relation : friends) {
            if (relation.contains(user)) {
                String friend1 = (relation.get(0).equals(user)) ? relation.get(1) : relation.get(0);
                friendList.add(friend1);
            } else {
                nonFriendList.addAll(relation);
//                nonFriendList.add(relation.get(0));
//                nonFriendList.add(relation.get(1));
            }
        }

        nonFriendList.addAll(visitors);

        // 중복 제거
        Set<String> set = new HashSet<>(nonFriendList);
        List<String> n_nonFriendList = new ArrayList<>(set);

        // 안친구목록 중 친구 있다면 지워주기
        for (String friend : friendList) {
            if (n_nonFriendList.contains(friend)) {
                n_nonFriendList.remove(friend);
            }
        }
        return List.of(friendList, n_nonFriendList);
    }

    private static Map<String, Integer> calcScore(Map<String, Integer> nonFriendScore, String user, List<List<String>> friendRelations, List<String> friendList, List<String> visitors) {

        // 아는 친구 점수 업데이트
        for (List<String> relation : friendRelations) {
            for (String friend : friendList) {
                if (relation.contains(friend)) {
                    String nonFriend = (relation.get(0).equals(friend)) ? relation.get(1) : relation.get(0);
                    if (!nonFriend.equals(user)) {
                        nonFriendScore.put(nonFriend, nonFriendScore.get(nonFriend)+10);
                    }
                }
            }
        }

        // 방문 점수 업데이트
        for (String visitor : visitors) {
            if (nonFriendScore.containsKey(visitor)){
                nonFriendScore.put(visitor, nonFriendScore.get(visitor)+1);
            }
        }
        return nonFriendScore;
    }
}
