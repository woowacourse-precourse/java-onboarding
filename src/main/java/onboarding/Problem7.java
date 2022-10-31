/**
 * hashmap, linkedhashmap, list의 자료구조를 이용한 풀이
 * 1. hashmap 초기화
 * 2. 직접적인 친구 관계를 가지고 있는 사용자를 저장한다.
 * 3. 건너서 아는 친구를 구하고 점수를 10점씩 더해준다.
 * 4. 방문자들의 점수를 1점씩 증가시킨다.
 * 5. user, user와 직접적인 친구의 점수를 0으로 초기화한다.
 * 6. hashmap을 linkedhashmap으로 변환 후 점수에 따른 내림차순 정렬
 * 7. 요구사항에 맞게 최대 5명을 선택한다.(0점인 경우 선택하지 않는다.)
 */

package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        // 1. hashmap 초기화
        hashMap = initialize(user, friends, visitors);
        // 2. 직접적인 친구를 구한 후 리스트에 저장해 놓는다.
        List<String> direct_friends = find_direct_friends(user, friends);
        // 3. 간접적인 친구를 구한 뒤 map에 10점씩 더해준다.
        for (int i = 0; i < direct_friends.size(); i++) {
            together_friends(direct_friends.get(i), friends, hashMap);
        }
        // 4. 방문자들의 점수를 증가시킨다.
        find_visitors(visitors, hashMap);
        // 5-1. user의 점수를 0점으로 초기화
        user_initial(user, hashMap);
        // 5-2. user와 직접적인 친구의 점수를 0점으로 초기화
        friend_initial(direct_friends, hashMap);
        // 6. hashmap -> linkedhashmap, 점수에 따른 내림차순 정렬
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap = sort(hashMap);
        // 7. 최대 5명 선택 후 반환(0점 제외)
        answer = select(linkedHashMap);

        return answer;
    }

    // 주어진 모든 유저들을 hashmap에 넣고 점수는 0점으로 모두 초기화한다.
    static HashMap<String, Integer> initialize(String s, List<List<String>> friends, List<String> visitor){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(s, 0);

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                map.put(friends.get(i).get(j), 0);
            }
        }

        for (int i = 0; i < visitor.size(); i++) {
            map.put(visitor.get(i), 0);
        }

        return map;
    }

    // user와 직접적으로 알고 있는 친구들을 구하는 메서드
    static List<String> find_direct_friends(String user, List<List<String>> friend){
        List<String> direct_friends = new ArrayList<>();
        for (int i = 0; i < friend.size(); i++) {
            if(friend.get(i).get(0).equals(user)){
                direct_friends.add(friend.get(i).get(1));
            }
            if(friend.get(i).get(1).equals(user)){
                direct_friends.add(friend.get(i).get(0));
            }
        }

        return direct_friends;
    }

    // user와 직접적으로 알진 못해도 건너서 아는 친구들을 구하는 메서드
    static void together_friends(String s, List<List<String>> friend, HashMap<String, Integer> map){
        int score = 10;
        for (int i = 0; i < friend.size(); i++) {
            if(friend.get(i).get(0).equals(s)){
                map.put(friend.get(i).get(1), map.get(friend.get(i).get(1)) + score);
            }
            if(friend.get(i).get(1).equals(s)){
                map.put(friend.get(i).get(0), map.get(friend.get(i).get(0)) + score);
            }
        }
    }

    // 방문자들을 확인 후 각각 1점씩 더해준다.
    static void find_visitors(List<String> visitors, HashMap<String, Integer> map){
        for (int i = 0; i < visitors.size(); i++) {
            map.put(visitors.get(i), map.get(visitors.get(i)) + 1);
        }
    }

    // map에서 user의 점수를 초기화해주는 메서드
    static void user_initial(String user, HashMap<String, Integer> map){
        map.put(user, 0);
    }

    // map에서 user와 직접적으로 아는 친구들의 점수를 초기화해주는 메서드
    static void friend_initial(List<String> list, HashMap<String, Integer> map){
        for(String str : list){
            map.put(str, 0);
        }
    }

    // Hashmap을 linkedhashmap으로 convert 후 점수를 기준으로 내림차순 정렬을 해준다.
    static LinkedHashMap<String, Integer> sort(HashMap<String, Integer> map){
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String,Integer> entry : entryList){
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        return linkedHashMap;
    }

    // linkedhashmap에서 이름, 점수를 각각 리스트로 변환 후 요구사항에 맞게 리스트 result를 구성한다.
    // result의 최대 크기 = 5 , result에는 점수를 내림차순으로 정렬했을 때 앞 순서부터 이름을 저장한다.
    static List<String> select(LinkedHashMap<String,Integer> linkedHashMap){
        List<String> name = new ArrayList<>();
        List<Integer> score = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for(String str : linkedHashMap.keySet()){
            name.add(str);
        }

        for(int val : linkedHashMap.values()){
            score.add(val);
        }

        for (int i = 0; i < score.size(); i++) {
            if(result.size() == 5){
                break;
            }
            if(score.get(i) != 0){
                result.add(name.get(i));
            }
        }

        return result;
    }
}
