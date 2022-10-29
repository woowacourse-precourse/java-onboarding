package onboarding;

import java.util.*;
// 기능목록
//1.사용자와 친구인 유저의 이름 배열에 담기
//2.사용자와 함께 아는 친구의 이름 해쉬맵에 추가 후 10점 주기
//3.방문한 유저를 해쉬맵에 넣고 1점 주기 이미 값이 있다면 1점 추가
//4.해쉬맵을 value값으로 내림차순 정렬 후 retun!
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> arr = new ArrayList<>();
        HashMap<String,Integer> map= new HashMap<>();
        //사용자와 친구인 유저의 이름 배열에 담기
        for(List<String> friend : friends){
            if(!friend.contains(user)) continue;
            if (Objects.equals(friend.get(0), user)) {
                arr.add(friend.get(1));
            } else {
                arr.add(friend.get(0));
            }
        }
        // 사용자와 함께 아는 친구를 해쉬맵에 추가하고 10점을 준다.
        for (List<String> friend : friends){
            for(String userFriend : arr){
                if(!friend.contains(userFriend) || friend.contains(user)) continue;
                String name = Objects.equals(friend.get(0), userFriend) ? friend.get(1) : friend.get(0);
                map.put(name,map.containsKey(name) ? map.get(name) + 10 : 10);
            }
        }

        return arr;
    }
}
