package onboarding;

import java.util.*;

/*
기능 목록
1. 친구 관계 HashMap 만들기(friendMap)
    1-1. key는 ID, value는 key와 친구인 id 리스트
2. 추천 점수 계산(scoreMap)
    2-1. key는 ID, value는 추천점수
3. 점수, 이름 기준 정렬
4. 점수가 0점 이상인 추천친구 return(최대 5명)
 */
public class Problem7 {
    public static HashMap<String, List<String>> makeFriendMap(List<List<String>> friends) {
        HashMap<String, List<String>> friendMap=new HashMap<>();
        for(List<String> friend : friends){
            List<String> tmp1=friendMap.getOrDefault(friend.get(0), new ArrayList<>());
            tmp1.add(friend.get(1));
            friendMap.put(friend.get(0), tmp1);
            List<String> tmp2=friendMap.getOrDefault(friend.get(1), new ArrayList<>());
            tmp2.add(friend.get(0));
            friendMap.put(friend.get(1), tmp2);
        }
        return friendMap;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, List<String>> friendMap=makeFriendMap(friends); //친구 관계 HashMap 만들기
        for(Map.Entry<String, List<String>> entrySet: friendMap.entrySet()){
            System.out.println("key : " + entrySet.getKey()+" value : " +Arrays.toString(entrySet.getValue().toArray()));
        }
        return answer;
    }
}
