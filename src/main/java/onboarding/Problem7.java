package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        int size = friends.size(); // 리스트 friends 의 크기

        // 1. remove 가능한 List 의 형태로 바꿔주기 위해 friends 가 아닌 copy_friends 를 선언
        List<List<String>> copy_friends = makeFriendsCopyList(friends);

        // 2. 리스트 friends 안에 있는 모든 이름을 다 검사. - user 의 친구 목록을 체크
        List<String> now_friends = addFriends(size, copy_friends, user);

        //  3. 친구 추천 대상자인 사람들의 이름을 저장할 공간인 HashMap 을 생성
        Map<String,Integer> map1 = new HashMap<>();

        // 4. 리스트 copy_friends 안에 있는 모든 이름을 다 검사. - user 의 친구 추천 대상자들을 체크
        map1 = check_potential(map1, copy_friends, now_friends);

        // 5. 방문자들 체크하기
        map1 = check_visitors(map1, visitors, now_friends);

        // 6.  value 내림차순으로 정렬하고, value가 같으면 key 오름차순으로 정렬
        Map<String, Integer> sortedMap = sort_map(map1);

        // 7. 상위 5개를 컷
        answer = returnTopFive(answer, sortedMap);

        return answer;
    }

    // 1. 편집 가능한 형태로 2차원 List 내용을 복제
    static List<List<String>> makeFriendsCopyList (List<List<String>> friends){
        List<List<String>> copy_friends = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++){
            copy_friends.add(new ArrayList<>());
            copy_friends.set(i, friends.get(i));
        }

        return copy_friends;
    }

    // 2. 리스트 copy_friends 안에 있는 모든 이름을 다 검사. - user 의 친구 목록을 체크
    static List<String> addFriends (int size, List<List<String>> copy_friends, String user){
        List<String> now_friends = new ArrayList<>(); // user 의 현재 친구들의 이름을 저장하는 List

        for (int i = 0; i< size; i++){ // 리스트 friends 안에 있는 모든 이름을 다 검사. - user 의 친구 목록을 체크
            String s0 = copy_friends.get(i).get(0); // 리스트 friends 의 요소 [0],
            String s1 = copy_friends.get(i).get(1); // [1] 에 저장된 String(이름)을 체크

            if ( s0 == user ){ // 둘 중 하나가 user 에 해당하면, 나머지 String 을 List 에 저장.
                now_friends.add(s1);
                copy_friends.remove(i);
                i -= 1;
                size -= 1;
            }
            else if(s1 == user){
                now_friends.add(s0);
                copy_friends.remove(i);
                i -= 1;
                size -= 1;
            }
            else{
                continue;
            }
        }
        return now_friends;
    }

    // 4. 리스트 copy_friends 안에 있는 모든 이름을 다 검사. - user 의 친구 추천 대상자들을 체크
    private static Map<String, Integer> check_potential(Map<String,Integer> map1,  List<List<String>> copy_friends, List<String> now_friends) {

        // 4. 리스트 copy_friends 안에 있는 모든 이름을 다 검사. - user 의 친구 추천 대상자들을 체크
        for(int i = 0; i < copy_friends.size(); i++){
            String s0 = copy_friends.get(i).get(0);
            String s1 = copy_friends.get(i).get(1);

            if (now_friends.contains(s0) && !now_friends.contains(s1)){ // 첫번쨰 글짜가 now_friends 에 속하면
                if(!map1.containsKey(s1)){ // 맵에 현재 두번째 글자와 같은 이름의 친구가 없으면
                    map1.put(s1, 10); // 새로 등록하고 10점으로 value 를 저장
                }
                else{ // 맵에 현재 같은 이름의 친구가 있으면
                    map1.put(s1, map1.get(s1) + 10); // value 에 10점 추가
                }
            }
            else if (!now_friends.contains(s0) && now_friends.contains(s1)){ // 두번쨰 글짜가 now_friends 에 속하면
                if(!map1.containsKey(s0)){ // 맵에 현재 첫번째 글자와 같은 이름의 친구가 없으면
                    map1.put(s0, 10); // 새로 등록하고 10점으로 value 를 저장
                }
                else{ // 맵에 현재 같은 이름의 친구가 있으면
                    map1.put(s0, map1.get(s0) + 10); // value 에 10점 추가
                }
            }
            else{
                continue;
            }
        }
        return map1;
    }

    // 5. 방문자들 체크하기
    private static Map<String, Integer> check_visitors(Map<String,Integer> map1, List<String> visitors, List<String> now_friends) {
        // 이제 방문자들을 살펴본다
        for(int i = 0; i<visitors.size(); i++){
            String term = visitors.get(i); // 방문자 리스트의 현재 값을 가져와서

            if (now_friends.contains(term)){ // 그 값이 내 현재 친구에 속해있다면 continue
                continue;
            }
            else{                           // 그게 아니라면
                if(!map1.containsKey(term)){ // 현재 map1 에 속해있는지 확인하고, 속하지 않았다면
                    map1.put(term, 1); // 새로 등록하고 1점으로 value 를 저장
                }
                else { // 이미 속해있다면
                    map1.put(term, map1.get(term) + 1); // value 에 1점 추가
                }
            }
        }
        return map1;
    }

    // 6. value 내림차순으로 정렬하고, value가 같으면 key 오름차순으로 정렬
    static Map<String, Integer> sort_map(Map<String, Integer> map1){
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map1.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparison = (o1.getValue() - o2.getValue()) * -1;
                return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
            }
        });

        // 순서유지를 위해 LinkedHashMap 을 사용
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    // 7. HashMap 에서 상위 5개만 추출
    static List<String> returnTopFive(List<String> answer, Map<String, Integer> sortedMap){

        Collection k = sortedMap.keySet();
        Iterator itr = k.iterator();
        for (int i = 0; i < 5; i++){
            answer.add((String) itr.next());
            if (!itr.hasNext()){
                break;
            }
        }
        return answer;
    }
}

