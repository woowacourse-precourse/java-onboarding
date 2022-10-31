package onboarding;

import java.util.*;

public class Problem7 {

    /**
     * 친구 관계 정보를 저장하는 map 생성 함수
     * @param friends : 친구 정보
     * @return 친구 관계 map
     */
    public static Map<String, List<String>> makeFriendInfoMap(List<List<String>> friends){

        Map<String, List<String>> snsFriendMap = new HashMap<>();

        for(List<String> friendList : friends){
            String friend1 = friendList.get(0);
            String friend2 = friendList.get(1);

            if (snsFriendMap.containsKey(friend1)){
                snsFriendMap.get(friend1).add(friend2);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(friend2);
                snsFriendMap.put(friend1,newList);
            }
            if(snsFriendMap.containsKey(friend2)){
                snsFriendMap.get(friend2).add(friend1);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(friend1);
                snsFriendMap.put(friend2,newList);
            }

        }
        return snsFriendMap;

    }

    /**
     * 함께 아는 사람 수 점수 추가 함수
     * @param snsFriendMap : 친구 관계 map
     * @param user : 사용자 정보
     * @return 점수 정보 map
     */
    public static Map<String, Integer> calcBothFriendPoint( Map<String, List<String>> snsFriendMap, String user){
        Map<String,Integer> score = new HashMap<>();
        for(String userFriend : snsFriendMap.getOrDefault(user, new ArrayList<>())){
            for (String relatedFriend:snsFriendMap.getOrDefault(userFriend, new ArrayList<>())){
                if (!relatedFriend.equals(user)){
                    if(score.containsKey(relatedFriend)){
                        score.put(relatedFriend, score.get(relatedFriend)+10);
                    }else{
                        score.put(relatedFriend, 10);
                    }
                }
            }
        }
        return score;
    }


    /**
     * 타임라인 방문 점수 추가 함수
     * @param score : 유저별 점수 map
     * @param visitors : 타임라인 방문 정보
     */
    public static void calcVisitorsPoint(Map<String,Integer> score, List<String> visitors){

        for(String visitor : visitors){
            if(score.containsKey(visitor)){
                score.put(visitor, score.get(visitor) +1);
            }else{
                score.put(visitor, 1);
            }
        }
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> snsFriendMap = makeFriendInfoMap(friends);
        Map<String,Integer> score = calcBothFriendPoint(snsFriendMap, user);

        calcVisitorsPoint(score, visitors);


        return answer;
    }
}
