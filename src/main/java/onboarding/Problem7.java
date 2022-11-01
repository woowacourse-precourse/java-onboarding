package onboarding;

import java.util.*;
/* 사용자와 함께 아는 친구에게 10점 부여 조건 : 사용자와 친구의 친구 사이여야한다. 사용자의 친구에게는 무조건 0점이 부여야되어야한다. 
*  사용자의 타임 라인에 방문한 친구에게 1점 부여 조건 : 사용자와 친구 사이여선 안된다. 
* 따라서, 사용자와 친구인 사람의 목록을 따로 구하여 사용한다. */

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> scoreMap = new HashMap<>(); // 점수 부여 hashmap
        List<String> friendwithuser = new ArrayList<>();    // user와 직접 관계인 사람
        String name = null;

        for (List<String> friend : friends) {
            name = findFriendWithUser(user, friend);
            if (name != null) {
                friendwithuser.add(name);   // user와 직접 친구인 사람의 이름 리스트
                scoreMap.put(name, 0);      // user와 친구관계임으로 0점 부여
            }
        }
        // user와 직접 관계인 사람 목록

        for (List<String> friend : friends) {
            name = findFriendWith(friend, friendwithuser, user);    // 직접친구와 친구인 사람을 찾는 메서드
            if (name != null) {
                if (!scoreMap.containsKey(name))
                    scoreMap.put(name, 10);
                else if ((scoreMap.containsKey(name))&&(scoreMap.get(name) != 0))
                    scoreMap.put(name, (scoreMap.get(name)) + 10);
            }   // 점수 부여
        }
        // 직접 관계 사람과 친구인 사람에게 점수 부여

        for (String person : visitors) {
            int check = 0;
            for (int i = 0; i < friendwithuser.size(); i++) {
                if (person.equals(friendwithuser.get(i))) {  // 직접관계인 사람의 방문일 경우
                    check = 1;
                }
            }
            if (check == 0) {
                if (!scoreMap.containsKey(person))
                    scoreMap.put(person, 1);
                else {
                    scoreMap.put(person, (scoreMap.get(person)) + 1);
                }
            }
        }
        // 방문자 점수 부여

        List<Map.Entry<String, Integer>> entryList = sortByscore(scoreMap);
        // 점수별로 정렬

        for (Map.Entry<String, Integer> key : entryList) {
            if ((answer.size() < 5) && (key.getValue() > 0))
                answer.add(key.getKey());
        }


        return answer;
    }

    private static String findFriendWithUser(String user, List<String> friend) {
        if (user.equals(friend.get(0)))
            return friend.get(1);
        else if (user.equals(friend.get(1)))
            return friend.get(0);
        else
            return null;
    }
    // user와 직접 친구인 [사람]을 찾는 메서드 : user - [friend]

    private static String findFriendWith(List<String> friend, List<String> friendwithuser, String user) {
        for (String person : friendwithuser) {
            if ((person.equals(friend.get(0))) && (!user.equals(friend.get(1)))) {  // 친구관계인 사람과 친구이면서, 본인이 아닌 경우
                return friend.get(1);   // andoler, jun
            } else if ((person.equals(friend.get(1))) && (!user.equals(friend.get(0)))) {
                return friend.get(0);
            }
        }
        return null;
    }
    // 직접 친구와 친구인 [사람]을 찾는 메서드 : user - friend - [friend]
    
    private static List<Map.Entry<String, Integer>> sortByscore (HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() == o1.getValue())
                    if (o1.getKey().compareTo(o2.getKey()) < 0)
                        return -1;
                // 같은 점수일 경우, 이름순으로 정렬

                return o2.getValue() - o1.getValue();
                // 내림차순
            }
        });
        return entryList;
    }
    // 점수별 정렬 메서드. 점수가 같을 경우 이름순으로 정렬

}
