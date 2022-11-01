package onboarding;

import java.util.*;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> user_friend(String user, List<List<String>> friends){ //사용자와 직접 연결된 친구를 찾는 기능
        List<String> u_finding = new ArrayList<>();
        for(int i=0; i<friends.size(); i++){
            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);
            if(name1.equals(user)) u_finding.add(name2);
            else if(name2.equals(user)) u_finding.add(name1);
        }
//        System.out.println(u_finding.toString());
        return u_finding;
    }

    public static Map<String, Integer> friend_friend(String user, List<String> user_friend, List<List<String>> friends){ //사용자의 친구의 친구를 찾아서 map에 점수와 함께 넣는 기능
        Map<String, Integer> recommend = new HashMap<>();
        for(int i=0; i<friends.size(); i++){
            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);
            if(name1.equals(user) || name2.equals(user)) continue;
            for(String str:user_friend){
                if(str.equals(name1)) recommend.put(name2, recommend.getOrDefault(name2,0)+10);
                else if(str.equals(name2)) recommend.put(name1, recommend.getOrDefault(name1, 0)+10);
            }
        }
//        System.out.println(recommend.toString());
        return recommend;
    }

    public static void visited(List<String> visitors, List<String> user_friend, Map<String, Integer> recommend){ //방문자 기록에서 점수를 매겨 맵에 넣는 기능
        for(int i=0; i<visitors.size(); i++){
            String visitor_name = visitors.get(i);
            if(user_friend.contains(visitor_name)) continue;
            recommend.put(visitor_name, recommend.getOrDefault(visitor_name,0)+1);
        }
        System.out.println(recommend.toString());
    }

    public static void sorted(Map<String, Integer> map){ //맵을 value값에 의해 정렬하는 기능
        Stream<Map.Entry<String, Integer>> sorting = map.entrySet()
                .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> list;
        Map<String, Integer> map;

        list = user_friend(user, friends);
        map = friend_friend(user, list, friends);
        visited(visitors, list, map);
        sorted(map);

        for (String key : map.keySet()) {
            answer.add(key);
        }
        return answer;
    }
}
