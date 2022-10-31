package onboarding;

import java.util.*;

public class Problem7 {
    /***
     * user의 친구 추출
     * user와 함께 아는 친구 추출
     * 방문자 추출
     * 점수 내림차순 정렬
     * map의 key 값만 추출
     * 이미 친구인 사람 추출
     * 리스트에서 이미 친구인 사람 삭제
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return result(user,friends,visitors);
    }

    /**
     * user의 친구 추출
     */
    static List<String> userFriends(String user, List<List<String>> friends) {
        List<String> myFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (friend.get(0).equals(user)) {
                    myFriends.add(friend.get(1));
                }else {
                    myFriends.add(friend.get(0));
                }
            }
        }
        return myFriends;
    }

    /**
     * user와 함께 아는 친구 추출
     */
    static Map<String,Integer> together(String user, List<List<String>> friends) {
        Map<String,Integer> together = new TreeMap<>();
        List<String> myFriends = userFriends(user,friends);
        for (String myFriend : myFriends) {
            for (List<String> fr1 : friends) {
                if (fr1.contains(myFriend) && !(fr1.contains(user))) {
                    if (!(fr1.get(0).contains(myFriend))) {
                        together.put(fr1.get(0), together.getOrDefault(fr1.get(0), 0) + 10);
                    } else {
                        together.put(fr1.get(1), together.getOrDefault(fr1.get(1), 0) + 10);
                    }
                }
            }
        }
        return together;
    }

    /**
     * 방문자 추출
     */
    static Map<String, Integer> visitor(String user, List<List<String>> friends, List<String> visitors) {
        Map<String,Integer> result = together(user,friends);
        List<String> uf = userFriends(user,friends);

        for (String visitor : visitors) {
            if (!(visitor.equals(uf))) {
                result.put(visitor, result.getOrDefault(visitor, 0) + 1);
            }
        }
        return result;
    }

    /**
     *점수 내림차순 정렬
     */
    static List<Map.Entry<String,Integer>> sort(Map<String,Integer> result){

        List<String> keySet = new ArrayList<>(result.keySet());
        Collections.sort(keySet);

        List<Map.Entry<String,Integer>> keyList = new LinkedList<>(result.entrySet());
        Collections.sort(keyList, (o1, o2) -> o2.getValue() - o1.getValue());

        return keyList;
    }

    /**
     * map의 key 값만 추출
     */
    static List<String> list(List<Map.Entry<String,Integer>> keyList){
        List<String> key = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : keyList){
            key.add(entry.getKey());
        }
        return key;
    }

    /**
     * 이미 친구인 사람 추출
     */
    static List<String> friends(List<String> answer,String user, List<List<String>> friends){
        List<String> result = userFriends(user,friends);
        List<String> remove = new ArrayList<>();
        for (String s : answer) {
            for (String value : result) {
                if (s.equals(value)) {
                    remove.add(s);
                }
            }
        }
        return remove;
    }

    /**
     * 리스트에서 이미 친구인 사람 삭제
     */
    static List<String> remove(List<String> answer, List<String> result){
        for(String item : result){
            answer.remove(item);
        }
        return answer;
    }

    static List<String> result(String user,List<List<String>> friends, List<String> visitors) {
        Map<String,Integer> map = visitor(user,friends,visitors);
        List<Map.Entry<String,Integer>> sort = sort(map);
        List<String> answer = list(sort);
        List<String> result = friends(answer,user,friends);

        return remove(answer,result);
    }
}
