package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, List<String>> friendsMap = new HashMap<>();  // 친구1  : [친구1의 친구들], ... 형태의 자료구조
        Map<String, Integer> pointsMap = new TreeMap<>();   // 친구추천점수 산출을 위한 자료구조 -> TreeMap을 사용하여 key값이 기본적으로  정렬되어 있음

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

        //System.out.println(friendsMap);

        // visitors들을 pointsMap에 추가, 점수 부여
        for (int i = 0; i < visitors.size(); i++){
            if (pointsMap.containsKey(visitors.get(i))){
                pointsMap.put(visitors.get(i), pointsMap.get(visitors.get(i)) + 1);
            }
            else
                pointsMap.put(visitors.get(i), 1);
        }
        //System.out.println(pointsMap);

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
        //System.out.println(friendsMap);

        List<String> answer;
        
        // user와 친구인 사람이 있다면
        if (friendsMap.get(user) != null){

            // user와 친구인 사람들의 친구들에게 점수 +10
            for (int i = 0; i < friendsMap.get(user).size(); i++){
                String userFriend = friendsMap.get(user).get(i);    // user의 친구 중 한 명
                List<String> targetFriends = friendsMap.get(userFriend);    // user의 친구의 친구들 리스트
                for (int j = 0; j < targetFriends.size(); j++){
                    // user는 제외
                    if (targetFriends.get(j).equals(user))
                        continue;
                    int targetFriendPoint = pointsMap.get(targetFriends.get(j));    // user의 친구의 친구의 현재 점수
                    pointsMap.put(targetFriends.get(j), targetFriendPoint + 10);    // user의 친구의 친구에겐 10점을 추가해줌
                }
            }

            // 이미 user와 친구인 사람들은 pointsMap에서 제거
            for (int i = 0; i < friendsMap.get(user).size(); i++){
                pointsMap.remove(friendsMap.get(user).get(i));
            }

            //System.out.println(pointsMap);

            answer = new ArrayList<>(pointsMap.keySet());

            // 정렬
            Collections.sort(answer, (k1, k2) -> (pointsMap.get(k2).compareTo(pointsMap.get(k1))));

            // 5명 이상일 경우 -> 상위 5명만
            if (answer.size() > 5){
                answer = answer.subList(0, 5);
            }
        }
        // user와 친구인 사람이 없다면
        else
            answer = new ArrayList<>();


        //System.out.println(answer);
        return answer;
    }
}
