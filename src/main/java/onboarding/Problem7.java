package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, Integer> recommendList = new HashMap<>();

        //나와 친구인 유저의 아이디 set 만들기
        Set<String> friendSet = new HashSet<>();
        for (List<String> list: friends) {
            if(list.contains(user)) {
                friendSet.add(list.get(0));
                friendSet.add(list.get(1));
            }
        }
        friendSet.remove(user);

        //나와 친구인 사람과 친구인 사람 list 만들기
        for (List<String> list: friends) {
            for (String friend: friendSet) {
                //list 안에 친구가 있는지 확인
                isAlreadyFriend(list, friend, friendSet, user, recommendList);
            }
        }

        //방문자 횟수만큼 나와 친구가 아닌 방문자 점수 부여
        for (String visitor:visitors) {
            setScore(friendSet, visitor, user, recommendList, 1);
        }

        //점수 내림차순 정렬하기
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(recommendList.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        return answer;
    }

    static void isAlreadyFriend(List<String> list, String friend, Set<String> friendSet, String user, HashMap<String, Integer> recommend) {
        if (list.contains(friend)) {
            for (int i=0; i<list.size(); i++) {
                setScore(friendSet, list.get(i), user, recommend, 10);
            }
        }
    }

    static void setScore(Set<String> friendSet, String id, String userId, HashMap<String, Integer> recommend, int score) {
        if (!friendSet.contains(id) && !id.equals(userId)) {
            if (recommend.containsKey(id)){
                recommend.put(id, recommend.get(id)+score);
            } else {
                recommend.put(id, score);
            }
        }
    }
}
