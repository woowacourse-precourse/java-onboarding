package onboarding;

import java.util.*;

/*
친구 추천 알고리즘
user의 친구는 userFriend라는 HashSet에 저장한다
user의 친구와 친구는 hashMap에 저장한다
friends문을 돌며 사용자와 함께 아는 친구인 경우 default+10 점 부여
타임라인에 방문한 경우 default+1점
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());

        HashMap<String,Integer> hashMap=new HashMap<String, Integer>();
        HashSet<String> userFriend = new HashSet<>();

        for(List<String> friend:friends){
            if(friend.contains(user)) {
                userFriend.add(friend.get(0));
                userFriend.add(friend.get(1));
            }
        }
        userFriend.remove(user);

        for(List<String> friend:friends){
            if(friend.contains(user)) continue;
            if(userFriend.contains(friend.get(0))&&!userFriend.contains(friend.get(1))) hashMap.put(friend.get(1), hashMap.getOrDefault(friend.get(1),0)+10);
            if(userFriend.contains(friend.get(1))&&!userFriend.contains(friend.get(0))) hashMap.put(friend.get(0), hashMap.getOrDefault(friend.get(0),0)+10);
        }

        for(String visitor:visitors){
            if(userFriend.contains(visitor.toString())) continue;
            hashMap.put(visitor, hashMap.getOrDefault(visitor,0)+1);
        }

        //정렬 : value값 기준 내림차순으로, 값이 같다면 key 값 기준 알파벳순으로 정렬
        List<String> keySet=new ArrayList<>(hashMap.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(hashMap.get(o1)==hashMap.get(o2))
                    return (int)o1.charAt(0) - (int)o2.charAt(0);
                return hashMap.get(o2)-(hashMap.get(o1));
            }
        });

        int i=0;
        for(String name:keySet){
            answer.add(name);
            if(++i==5) break;
        }

        return answer;
    }
}
