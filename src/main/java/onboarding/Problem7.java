package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 1. user와의 친구관계 정리
        List<List<String>> friendsExceptUser = new ArrayList<>();
        HashSet<String> friendsWithUser = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            String left = friends.get(i).get(0);
            String right = friends.get(i).get(1);
            if (left == user) {
                friendsWithUser.add(right);
            } else if (right == user) {
                friendsWithUser.add(left);
            } else {
                friendsExceptUser.add(friends.get(i));
            }
        }
//        System.out.println(friendsWithUser);
//        System.out.println(friendsExceptUser);


        // 2. 추천점수 계산
        HashMap<String, Integer> recommend = new HashMap<>();
        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);
            if (!friendsWithUser.contains(visitor)) {
                recommend.put(visitor, recommend.containsKey(visitor) ? recommend.get(visitor) + 1 : 1);
            }
        }
        for (int i = 0; i < friendsExceptUser.size(); i++) {
            String left = friendsExceptUser.get(i).get(0);
            String right = friendsExceptUser.get(i).get(1);
            if (friendsWithUser.contains(left) && !friendsWithUser.contains(right)) {
                recommend.put(right, recommend.containsKey(right) ? recommend.get(right) + 10 : 10);
            } else if (!friendsWithUser.contains(left) && friendsWithUser.contains(right)) {
                recommend.put(left, recommend.containsKey(left) ? recommend.get(left) + 10 : 10);
            } else {
            }
        }
//        System.out.println(recommend);


        // 3. Map -> List 변환, 정렬
        List<Map.Entry<String, Integer>> list = new ArrayList<>(recommend.entrySet());
        Collections.sort(list, (o1, o2) -> {
            return o1.getValue() > o2.getValue() ?
                    -1 :
                    o1.getValue() < o2.getValue() ?
                            1 :
                            // 추천 점수가 같은 경우는 이름순으로 정렬한다.
                            o1.getKey().compareTo(o2.getKey()) < 0 ?
                                -1: 1;
        });
        for (int i=0; i<5 && i<list.size(); i++){
            answer.add(list.get(i).getKey());
        }
//        System.out.println(list);


       return answer;
    }
}
