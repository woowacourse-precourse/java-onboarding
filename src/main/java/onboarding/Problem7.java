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
// 3. visitors에 있는 user마다 1점 추가
// 4. 점수가 높은 순대로 정렬하고 점수가 같다면 이름순으로 정렬한다.
// 5. 정렬한 결과를 answer에 넣고 반환

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

        for (String keyUser : users) {
            usersScoreMap.put(keyUser,0);
        }

        for (List friend : friends) {
            for(String userFriend : userFriendList){
                if(friend.get(0) == userFriend){
                    usersScoreMap.put((String) friend.get(1), usersScoreMap.get(friend.get(1)) + 10);
                }
                if(friend.get(1) == userFriend){
                    usersScoreMap.put((String) friend.get(0), usersScoreMap.get(friend.get(0)) + 10);
                }
            }
        }

        for (String visitor : visitors) {
            usersScoreMap.put(visitor, usersScoreMap.get(visitor) + 1);
        }

        usersScoreMap.remove(user);
        for (String userFriend : userFriendList){
            usersScoreMap.remove(userFriend);
        }

        List<Map.Entry<String, Integer>> valueSortUserScoreMap = new LinkedList<>(usersScoreMap.entrySet());

        Collections.sort(valueSortUserScoreMap, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        System.out.println(usersScoreMap);
        System.out.println(valueSortUserScoreMap);

        for (Map.Entry<String, Integer> valueSortUserScore : valueSortUserScoreMap) {
            answer.add(valueSortUserScore.getKey());
        }

        return answer;
    }
}