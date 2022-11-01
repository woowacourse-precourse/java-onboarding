package onboarding;

import java.util.*;

/*기능 요구 사항*/
/* 추천 알고리즘
 * 1. 사용자와 함께 아는 친구의 수 = 10점
 * 2. 사용자의 타임라인에 방문한 횟수
 * 3. 친구 추천 규칙에 따라 점수가 높은 순으로 최대 5명 return
 * 4. 이미 친구인 사람은 추천 X
 <solution>
 *  - 친구 관계 정보를 사용자의 친구로 나타내기 위해 해쉬맵을 이용한다.
 *  - 해쉬맵에 친구 정보를 모두 저장한다.
 *  - user를 통해 사용자의 친구 목록을 저장한다.
 *  - 이용자들의 친구 목록을 조회해 user와 겹치는 경우 친구의 수만큼 +10을 해준다.
 *  - visitors의 정보를 이용해 +1을 해준다.
 *  - 이미 친구의 경우를 제외하여, 최대 5명을 return 한다.
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        /*친구 목록 해쉬맵 구현*/
        Map<String,List<String>> friendInfo = new HashMap<>();

        for(int i=0; i<friends.size(); i++) {
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();

            if(friendInfo.containsKey(friends.get(i).get(0))){
                list1 = friendInfo.get(friends.get(i).get(0));
                list1.add(friends.get(i).get(1));
            }else list1.add(friends.get(i).get(1));

            if(friendInfo.containsKey(friends.get(i).get(1))){
                list2 = friendInfo.get(friends.get(i).get(1));
                list2.add(friends.get(i).get(0));
            } else list2.add(friends.get(i).get(0));

            friendInfo.put(friends.get(i).get(0),list1);
            friendInfo.put(friends.get(i).get(1),list2);
        }

        /*친구 목록 점수 계산*/

        List<String> userFriends = List.of();

        if(friendInfo.containsKey(user)) userFriends = friendInfo.get(user);
        Map<String,Integer> friendScore = new HashMap<>();

        for(String key:friendInfo.keySet()) {
            if(key == user) continue;
            int score =0;
            for(int i=0; i<userFriends.size(); i++){
                if(friendInfo.get(key).contains(userFriends.get(i))) score +=10;
            }
            if(score > 0){
                if(friendScore.containsKey(key)){
                    score += friendScore.get(key);
                }
                friendScore.put(key,score);
            }
        }

        return answer;
    }
}
