/*
* 기능 목록
* 1. user의 친구 리스트 구하는 함수
* 2. 친구리스트의 친구들 점수 계산하기
* 3. visit한 사람의 점수 계산하기
* 4. 이미 친구가 되어있는 사람의 점수 삭제
* 5. sort
 */
package onboarding;

import java.util.*;

public class Problem7 {
    static final int VISIT = 1;
    static final int TOGETHER_HAVE_FRIEND = 10;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriendList = GetFriendShipFromName(friends, user);
        Map<String, Integer> friendshipScore = new HashMap<>();
        friend(friendshipScore, userFriendList, friends);
        visitCheck(friendshipScore, visitors);
        alreadyFriendCheck(friendshipScore, userFriendList);
        return resultSort(friendshipScore);
    }

    public static List<String> GetFriendShipFromName(List<List<String>> friendRelations, String user) {
        List<String> userfriendList = new LinkedList<>();
        userfriendList.add(user);
        for (List<String> friendRelation : friendRelations) {
            if (friendRelation.contains(user)) {
                friendRelationAddUser(userfriendList, friendRelation, user);
            }
        }
        return userfriendList;
    }

    public static void friendRelationAddUser(List<String> userFriendList, List<String> friendRelation, String user) {
        for (String friendName : friendRelation) {
            if (friendName.equals(user)) {
                continue;
            } else {
                userFriendList.add(friendName);
            }
        }
    }

    public static void friend(Map<String, Integer> friendshipScore, List<String> userFriend, List<List<String>> friends) {
        for (String name : userFriend) {
            List<String> nameFriendList = GetFriendShipFromName(friends, name);
            friendListCheck(friendshipScore, nameFriendList, TOGETHER_HAVE_FRIEND);
        }
    }

    public static void friendListCheck(Map<String, Integer> friendshipScore, List<String> list, int score) {
        for (String name : list) {
            friendScoreCalculate(friendshipScore, name, score);
        }
    }

    public static void friendScoreCalculate(Map<String, Integer> friendshipScore, String name, int score) {
        if (friendshipScore.containsKey(name)) {
            friendshipScore.replace(name, friendshipScore.get(name) + score);
        } else {
            friendshipScore.put(name, score);
        }
    }

    public static void visitCheck(Map<String, Integer> friendshipScore, List<String> visitors) {
        friendListCheck(friendshipScore, visitors, VISIT);
    }

    public static void alreadyFriendCheck(Map<String, Integer> friendshipScore, List<String> userFriend) {
        for (String name : userFriend) {
            friendshipScore.remove(name);
        }
    }

    public static List<String> resultSort(Map<String, Integer> friendshipScore) {
        List<String> answer = new LinkedList<>();
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(friendshipScore.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue().equals(o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i = 0; i < 5 && i < entries.size(); i++) {
            Map.Entry<String, Integer> entry = entries.get(i);
            System.out.println(entry.getKey());
            answer.add(entry.getKey());
        }

        return answer;
    }
}
