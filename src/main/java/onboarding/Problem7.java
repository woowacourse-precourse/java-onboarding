package onboarding;
import java.util.*;
// SNS 참여자의 목록을 Map(참여자, 점수)로 정리해 구현
// 1. 친구 목록 생성: List<String> getUseFriends(String user, List<List<String>> friends)
// 2. 친구의 지인 Map 생성 & 점수 부여: Map<String, Integer> rateFriends(String suer, List<List<String>> friends)
// 3. 방문자 Map 생성 & 점수 부여: Map<String, Integer> rateVisitor(List<String> friendList, List<String> visitors)
// 4. 정렬(내림차순 정렬, 최대 5명 추천) : List<String> sortMap(Map map)

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendRate = rateFriends(user, friends);
        Map<String, Integer> visitorRate =rateVisitor(getUserFriends(user, friends), visitors);

        // friends, visitors 각 Map의 점수 합하기 -> friendRate에
        visitorRate.forEach((key, value)->friendRate.merge(key, value, (v1, v2) -> v1+v2));

        // 정렬용 메서드에 넣기
        List<String> answer =sortMap(friendRate);

        return answer;
    }

    // 1. 친구 목록 생성
    public static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for(int i=0; i<friends.size(); i++) {
            if(friends.get(i).contains(user)) {
                userFriends.add(friends.get(i).get(0));
            }
        }
        return userFriends;
    }

    // 2. 친구의 지인 점수 추가
    public static Map<String, Integer> rateFriends(String user, List<List<String>> friends) {
        Map<String, Integer> friendRate = new HashMap<>();

        // 친구의 지인 map에 넣기
        for(int i=0; i<friends.size(); i++) {
            friendRate.put(friends.get(i).get(1), 0);
        }

        // 친구인 경우 10점 더하기
        int rate =0;
        for(int i=0; i<friends.size(); i++) {
            rate =friendRate.get(friends.get(i).get(1));
            rate +=10;
            friendRate.put(friends.get(i).get(1), rate);
        }
//      // user는 목록에서 제거하기
        friendRate.remove(user);
        return  friendRate;
    }

    public static Map<String, Integer> rateVisitor(List<String> friendList, List<String> visitors) {
        Map<String, Integer> visitorRate = new HashMap<>();

        // visitors를 Map에 넣기
        // (방문자 1인 당 하나의 key를 위해 set에 넣어 중복 제거)
        Set<String> setVisitor = new HashSet<>(visitors);
        // set -> Map
        for(String id:setVisitor) {
            visitorRate.put(id, 0);
        }

        // 1점씩 더하기
        int rate =0;
        for(int i=0; i<visitors.size(); i++) {
            rate =visitorRate.get(visitors.get(i));
            rate +=1;
            visitorRate.put(visitors.get(i), rate);
        }

        // 친구 제거하기
        for(int i=0; i<friendList.size(); i++) {
            visitorRate.remove(friendList.get(i));
        }
        return visitorRate;
    }


    public static List<String> sortMap(Map map) {
        // Map의 value 기준 내림차순 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        // Map->List
        List<String> answer = new ArrayList<>(map.keySet());
        // 갯수 5개로 제한
        if(answer.size()>=5) {
            answer.subList(0,5);
        }
        return answer;
    }
}