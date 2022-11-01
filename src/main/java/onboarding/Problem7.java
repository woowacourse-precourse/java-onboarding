package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // people = 등장하는 사람의 아이디를 모두 저장 (중복 X)
        HashSet<String> people = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            people.add(friends.get(i).get(0));
            people.add(friends.get(i).get(1));
        }
        for(String visitor :visitors){
            people.add(visitor);
        }

        List<String> peopleList = new ArrayList<>(people);

        // friend_map = {key: 아이디(string), value: 친구 목록(list<string>)}
        HashMap<String, List<String>> friend_map = new HashMap<>();
        // score_map = {key: 아이디(string), value: 추천 점수(integer)}
        HashMap<String, Integer> score_map = new HashMap<>();

        for (List<String> friend : friends) {
            String first = friend.get(0);
            String second = friend.get(1);

            // 친구 리스트의 첫번째 아이디가 이미 map의 key로 있으면, list에 두번째 아이디추가
            if (friend_map.containsKey(first)) {
                List<String> list = friend_map.get(first);
                list.add(second);
                friend_map.put(first,list);
                // 친구 리스트의 첫번째 아이디가 map의 key로 없으면, list 생성 후 list에 두번째 아이디추가
            }else{
                List<String> list = new ArrayList<>();
                list.add(second);
                friend_map.put(first, list);
            }
            // 첫번째와 두번째 아이디 순서를 바꿔서 위의 연산 재실행
            if (friend_map.containsKey(second)){
                List<String> list = friend_map.get(second);
                list.add(first);
                friend_map.put(second,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(first);
                friend_map.put(second,list);
            }
        }
        // score_map = {key: 아이디(string), value: 추천 점수(integer)}
        for(String pl : peopleList){
            String key = pl;
            Integer value=0;
            score_map.put(key,value);
        }
        //userFriends = user의 친구를 저장한 리스트
        List<String> userFriends = friend_map.get(user);
        for(String userFriend : userFriends){
            List<String> scoreFriends = friend_map.get(userFriend);
            for(String scoreFriend : scoreFriends){
                //scoreFriend가 user가 아니고, user와 친구가 아니면 추천 점수 10점 추가
                if(!scoreFriend.equals(user) && !friend_map.get(user).contains(scoreFriend)) {
                    Integer score = score_map.get(scoreFriend);
                    score_map.put(scoreFriend, score + 10);
                }
            }
        }

        for(String visitor: visitors){
            //visitor가 user의 친구목록에 없으면 추천 점수 1점추가
            if (!friend_map.get(user).contains(visitor)) {
                Integer score = score_map.get(visitor);
                score_map.put(visitor, score + 1);
            }
        }

        List<Map.Entry<String,Integer>> entries = new ArrayList<Map.Entry<String,Integer>>(score_map.entrySet());
        // 정렬
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int result = o2.getValue().compareTo(o1.getValue());
                return result == 0 ? o1.getKey().compareTo(o2.getKey()) : result;
            }
        });

        List<String> recommendList = new ArrayList<>();

        int cnt = 0;
        for(Map.Entry<String,Integer> entry : entries){
            if (cnt  == 5){
                break;
            }
            if (entry.getValue() != 0) {
                recommendList.add(entry.getKey());
            }
            cnt ++;
        }

        return recommendList;
    }
}
