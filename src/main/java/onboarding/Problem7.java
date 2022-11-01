package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> friendsMap = new HashMap<>();  // 친구1  : [친구1의 친구들], ... 형태의 자료구조
        HashMap<String, Integer> pointsMap = new HashMap<>();   // 친구추천점수 산출을 위한 자료구조

        for (int i = 0; i < friends.size(); i++){
            /*
            if - 사용자의 친구들을 userFriends에 추가
            else - 사용자는 제외한 친구들을 pointsMap, friendsMap에 추가
            */
            if (friends.get(i).get(0).equals(user)) {
                friendsMap.put(user, new ArrayList<>());  // 사용자 : 사용자 친구 목록
            }
            else{
                pointsMap.put(friends.get(i).get(0), 0);
                friendsMap.put(friends.get(i).get(0), new ArrayList<>());
            }
            if (friends.get(i).get(1).equals(user)) {
                friendsMap.put(user, new ArrayList<>());
            }
            else{
                pointsMap.put(friends.get(i).get(1), 0);
                friendsMap.put(friends.get(i).get(1), new ArrayList<>());
            }
        }

        System.out.println(friendsMap);

        // visitors들을 pointsMap에 추가, 점수 부여
        for (int i = 0; i < visitors.size(); i++){
            System.out.println(visitors.get(i));
            if (pointsMap.containsKey(visitors.get(i))){
                pointsMap.put(visitors.get(i), pointsMap.get(visitors.get(i)) + 1);
            }
            else
                pointsMap.put(visitors.get(i), 1);
        }
        System.out.println(pointsMap);

        // 각 친구관계를 friendsMap에 추가
        // 친구1  : [친구1의 친구들] 형태
        for (int i = 0; i < friends.size(); i++){

            String me = friends.get(i).get(0);
            String friend = friends.get(i).get(1);
            if (friendsMap.containsKey(me)){
                friendsMap.get(me).add(friend);
            }
            me = friends.get(i).get(1);
            friend = friends.get(i).get(0);
            if (friendsMap.containsKey(me)){
                friendsMap.get(me).add(friend);
            }
        }
        System.out.println(friendsMap);



        return answer;
    }
}
