package onboarding;

import java.util.*;

// mrko // donut, shakevan

// donut // andole, jun, mrko // 1
// andole // donut, shakevan // 20
// jun // donut, shakevan // 20
// shakevan // andole, jun, mrko // 1
// bedi // 3

// andole, jun, bedi

// 그러니까 ..이 로직은 친구 추천 알고리즘에 관한 로직이니까
// 이미 친구인 사람에게는 점수를 주지 않는거구나. 이해됐다.
// 친구 목록에 user의 친구와 같은 친구가 있다면 점수에 +10
// visitors는 그냥.. 각 user 점수에 +1 해주면 되는거구
// friends 목록에 없고 visitors에만 있는 user도 있으니까 user 새로 생성해주면 되겠고
// 일단 배열을 받고 위의 표처럼 각 사용자의 친구가 누구인지 정리하는게 좋겠다.
// 그 다음 user의 친구들과 다른 users의 친구들이 같은지 비교하고, 있다면 +10

// todo
// 1. 점수를 정리할 hashmap 생성
// 1-1. java에서 set은 중복을 허용하지 않으므로 friends와 visitors의 모든 user을 하나의 set에 넣는다.
// 1-2. 중복이 제거된 users리스트를 키로 하고, 점수를 value로 하는 hashmap을 생성한다.
// 2. user의 친구목록을 따로 만들고, 각 user들의 친구와 겹치는지 확인후, 겹치면 해당 user의 점수에 10점 추가
// 2-1. user의 친구목록 생성
// 2-2. 각 user들의 친구를 확인 후 user의 친구와 비교
// 2-3. 비교 후 친구가 같다면, 해당 user 점수에 10점 추가

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<String>();

        Set<String> users = new HashSet<String>();

        Set<String> userFriendList = new HashSet<String>();

        HashMap<String,Integer> usersScoreMap = new HashMap<String, Integer>();

        for (List friend : friends) {
            if(friend.get(0) == user){
                userFriendList.add((String) friend.get(1));
            }
            if(friend.get(1) == user){
                userFriendList.add((String) friend.get(0));
            }
            users.add((String) friend.get(0));
            users.add((String) friend.get(1));
        }
        for (String visitor : visitors) {
            users.add(visitor);
        }
        System.out.println(users);

        for (String keyUser : users) {
            System.out.println(keyUser);
            usersScoreMap.put(keyUser,0);
        }
        System.out.println(usersScoreMap);
        System.out.println(userFriendList);



        return answer;
    }
}