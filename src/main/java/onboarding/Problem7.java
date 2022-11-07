package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friendsWithUser = new ArrayList<>();
        Map<String, Integer> recommendGrade = new HashMap<>();

        for (List<String> group : friends) {
            if(group.contains(user))
                friendsWithUser.addAll(group);      // 기존 친구 목록 업데이트
        }
        System.out.println("이전 " + friendsWithUser);
        friendsWithUser.remove(user);// user 중복을 없앴어야함.
        System.out.println("이후 "+friendsWithUser);

        for (List<String> group : friends) {
            String friend1 = group.get(0);
            String friend2 = group.get(1);

            if(friend1.equals(user) || friend2.equals(user)) continue;

            if(friendsWithUser.contains(friend1)) {     // 같은 친구일 경우 10점 플러스
                if(recommendGrade.containsKey(friend2))
                    recommendGrade.put(friend2, recommendGrade.get(friend2)+10);
                else recommendGrade.put(friend2, 10);
            }

            if(friendsWithUser.contains(friend2)) {     // 같은 친구일 경우 10점 플러스
                if(recommendGrade.containsKey(friend1))
                    recommendGrade.put(friend1, recommendGrade.get(friend1)+10);
                else recommendGrade.put(friend1, 10);
            }
        }

        for(String visitor: visitors){  // 방문객일 경우
            if(recommendGrade.containsKey(visitor))
                recommendGrade.put(visitor, recommendGrade.get(visitor)+1);
            else recommendGrade.put(visitor, 1);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(recommendGrade.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                return o2.getValue().compareTo(o1.getValue());
            }
        };
        Collections.sort(entryList, comparator);        // 정렬

        for(Map.Entry<String, Integer> entry: entryList){
            System.out.println(entry.getKey() + " "+ entry.getValue());
            answer.add(entry.getKey());
        }
        answer.removeAll(friendsWithUser);  // 이미 친구일 경우 삭제

        // 다섯명만 추출해야하는데 처리를 까먹음.....

        return answer;
    }
}
