package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //친구 관계 저장
        Map<String, Set<String>> friendsMap = new HashMap<>();
        for(List<String> friend : friends){
            String p1 = friend.get(0);
            String p2 = friend.get(1);

            Set<String> p1Friends = friendsMap.getOrDefault(p1, new HashSet<>());
            p1Friends.add(p2);
            friendsMap.put(p1, p1Friends);

            Set<String> p2Friends = friendsMap.getOrDefault(p2, new HashSet<>());
            p2Friends.add(p1);
            friendsMap.put(p2, p2Friends);
        }

        //함께 아는 친구 +10점
        Map<String, Integer> map = new HashMap<>();
        Set<String> userFriends = friendsMap.get(user);
        for(String p : friendsMap.keySet()){
            if(p.equals(user) || userFriends.contains(p)){
                continue;
            }
            Set<String> pSet = friendsMap.get(p);
            for(String f : userFriends){
                if(pSet.contains(f)){
                    map.put(p, map.getOrDefault(p, 0) + 10);
                }
            }
        }

        //방문한 친구 +1점
        for(String visitor : visitors){
            if(friendsMap.get(user).contains(visitor)){
                continue;
            }
            map.put(visitor, map.getOrDefault(visitor, 0) +1);
        }

        //내림차순 Comparator
        Map<Integer, List<String>> sort = new TreeMap<>(Comparator.reverseOrder());
        for(String p : map.keySet()){
            List<String> list = sort.getOrDefault(map.get(p), new ArrayList<>());
            list.add(p);
            sort.put(map.get(p), new ArrayList<>(list));
        }

        List<String> answer = new ArrayList<>();
        for(int i : sort.keySet()){
            List<String> list = sort.get(i);
            Collections.sort(list);
            answer.addAll(list);
        }

        return answer;
    }
}
