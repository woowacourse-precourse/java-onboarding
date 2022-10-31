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

    /**
     * 유저별 점수 정렬 하는 함수
     * @param score : 유저별 점수 map
     * @return : 정렬된 유저별 점수 list
     */
    public static List<Map.Entry<String,Integer>> sortPoints(Map<String,Integer> score){
        List<Map.Entry<String, Integer>> scoreList = new LinkedList<>(score.entrySet());
        scoreList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().equals(o2.getValue())){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return scoreList;
    }

    /**
     * 추천 점수가 높은 5명 추출 함수
     * @param snsFriendMap : 친구 관계 map
     * @param scoreList : 정렬된 유저별 점수
     * @param user : 사용자
     * @return : 추천 점수가 높은 5명 list
     */
    public static List<String> extractTop5( Map<String, List<String>> snsFriendMap, List<Map.Entry<String, Integer>> scoreList,String user){
        List<String> answer = new ArrayList<>();

        int count =1;
        for(Map.Entry<String,Integer> scoreFriend : scoreList){
            if (snsFriendMap.getOrDefault(user, new ArrayList<>()).contains(scoreFriend.getKey())){
                continue;
            }
            answer.add(scoreFriend.getKey());
            count +=1;

            if(count>5){
                break;
            }
        }
        return answer;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, List<String>> snsFriendMap = makeFriendInfoMap(friends);
        Map<String,Integer> score = calcBothFriendPoint(snsFriendMap, user);

        calcVisitorsPoint(score, visitors);

        List<Map.Entry<String, Integer>> scoreList = sortPoints(score);

        List<String> answer;
        answer = extractTop5(snsFriendMap, scoreList,user);

        return answer;
    }
}
