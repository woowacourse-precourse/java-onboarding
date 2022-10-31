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
    public static HashMap<String, Integer> calcScore(String user, HashMap<String, List<String>> friendMap, List<String> visitors){
        HashMap<String, Integer> scoreMap=new HashMap<>();
        //사용자와 함께 아는 친구 점수 추가
        if(friendMap.get(user)!=null) {
            for (String friend : friendMap.get(user)) {
                for (String recommand : friendMap.get(friend)) {
                    if (friendMap.get(user).contains(recommand) || recommand.equals(user)) continue;
                    scoreMap.put(recommand, scoreMap.getOrDefault(recommand, 0) + 10);
                }
            }
        }
        //사용자의 타임 라인에 방문한 횟수 점수 추가
        for(String visitor : visitors){
            if(friendMap.get(user)!=null && friendMap.get(user).contains(visitor)) continue;
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0)+1);
        }
        return scoreMap;
    }
    public static List<Map.Entry<String, Integer>> sorting(HashMap<String, Integer> scoreMap){
        List<Map.Entry<String, Integer>> listEntries = new ArrayList<Map.Entry<String, Integer>>(scoreMap.entrySet());

        // 비교함수 Comparator를 사용하여 점수 내림차순 정렬(점수가 동일하면 이름순정렬)
        Collections.sort(listEntries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                if(obj2.getValue()==obj1.getValue()){
                    return obj1.getKey().compareTo(obj2.getKey());
                }
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        return listEntries;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> friendMap=makeFriendMap(friends); //친구 관계 HashMap 만들기
        /*
        for(Map.Entry<String, List<String>> entrySet: friendMap.entrySet()){
            System.out.println("key : " + entrySet.getKey()+" value : " +Arrays.toString(entrySet.getValue().toArray()));
        }
         */
        HashMap<String, Integer> scoreMap=calcScore(user, friendMap, visitors); // 추천 점수 계산

        /*
        for(Map.Entry<String, Integer> entrySet:scoreMap.entrySet()){
            System.out.println("key : "+entrySet.getKey()+" value : "+entrySet.getValue());
        }
         */
        List<Map.Entry<String, Integer>> sortScore=sorting(scoreMap); //점수, 이름 기준 정렬

        //점수가 0점 이상인 추천친구 return(최대 5명)
        int cnt=0;
        for(Map.Entry<String, Integer> entry : sortScore) {
            if(entry.getValue()>0) {
                answer.add(entry.getKey());
                cnt+=1;
            }
            if(cnt==5){
                break;
            }
        }

        return answer;
    }
}
