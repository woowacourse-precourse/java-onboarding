package onboarding;

import java.util.*;

public class Problem7 {
    // 주어진 아이디A, B 의 친구관계를 친구 관계 목록 map 에 추가하는 함수
    public static void setUserFriendsMap(List<String> friend, Map<String, Info> map){
        String left = friend.get(0);
        String right = friend.get(1);

        if(!map.keySet().contains(left)){
            map.put(left, new Info(0,new ArrayList<>()));
        }
        if(!map.keySet().contains(right)){
            map.put(right, new Info(0,new ArrayList<>()));
        }

        map.get(left).knowing.add(right);
        map.get(right).knowing.add(left);
    }

    // 주어진 방문자 정보들을 친구 관계 목록 map에 추가하고 같은 방문자는 점수를 올리는 함수
    public static void setVisitorsToMap(String visitUser, Map<String, Info> map){
        if(!map.keySet().contains(visitUser)){
            map.put(visitUser, new Info(1, new ArrayList<>()));
        }else{
            map.get(visitUser).point += 1;
        }
    }

    // 사용자와 이미 친구가 되어있는 유저를 제외하고 사용자와 함께 아는 친구의 수에 따라 유저의 점수를 올리는 함수
    public static String checkMapKnowingFriends(String name, Map<String, Info> map, String user){
        List<String> friendList = map.get(name).knowing;
        for(String friend : friendList){
            if(map.get(user).knowing.contains(friend)){
                map.get(name).point += 10;
            }
        }
        return name;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
