package onboarding;

import java.util.*;

/**
 * 기능 요구사항
 * 1. 친구 추천 알고리즘에 따라서 점수를 산정한다.
 * 2. 추천 점수가 같은 경우 이름순으로 정렬해야 한다.
 * 3. 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 보여줘야 한다.
 */
public class Problem7 {
    static Set<String> friend;
    static HashSet<String> userfriends;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        userfriends = new HashSet<>(); // 사용자 친구
        Map<String, Integer> map = new HashMap<>();
        friend = new HashSet<>(); // 사용자 친구의 친구

        calculateTheScore(user, friends, visitors, map);
        List<Map.Entry<String, Integer>> score = sortByName(map);

        answer = showList(answer, score);

        return answer;
    }

    private static List<String> showList(List<String> answer, List<Map.Entry<String, Integer>> score) {
        int cnt = 0;
        for(Map.Entry<String, Integer>e: score){
            cnt++;
            answer.add(e.getKey());
            if(cnt==5) break; // 최대 5명
        }
        return answer;
    }

    private static List<Map.Entry<String, Integer>> sortByName(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> {
            if(o1.getValue()==o2.getValue()){
                return o1.getKey().compareTo(o2.getKey());
            }
            else{ // 내림차순
                return o2.getValue() - o1.getValue();
            }
        });
        return entryList;
    }

    private static void calculateTheScore(String user, List<List<String>> friends, List<String> visitors, Map<String, Integer> map) {
        for(List<String>list : friends){
            findFriends(list, user);
        }

        for(List<String>list : friends){
            findAFriendOfAFriend(list, user);
        }
        // 친구의 친구들은 10점을 준다
        for(Object s : userfriends.toArray()){
            map.put((String) s, 10);
        }
        // 타임라인에 방문한 사람들은 1점
        for(String s : visitors){
            if(friend.contains(s)) continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    // 사용자 친구 찾기
    public static void findFriends(List<String>list, String user){
        String str1 = list.get(0);
        String str2 = list.get(1);
        if(str1.equals(user)){
            friend.add(str2);
        }
        else if(str2.equals(user)){
            friend.add(str1);
        }
    }

    // 친구의 친구 찾기
    public static void findAFriendOfAFriend(List<String>list, String user){
        String str1 = list.get(0);
        String str2 = list.get(1);
        if(friend.contains(str1)){
            if(!str2.equals(user)){
                userfriends.add(str2);
            }
        }
        else if(friend.contains(str2)){
            if(!str1.equals(user)){
                userfriends.add(str1);
            }
        }
    }

}
