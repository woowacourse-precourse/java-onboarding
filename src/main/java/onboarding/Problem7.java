package onboarding;

import java.text.CollationKey;
import java.util.*;

/**
 * 1. user의 친구들 구하기
 * 2. 추천 점수 계산
 * 3. 방문자 점수 계산
 * 4. 점수 높은순으로 정렬 및 5명 반환
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashSet<String> userFriend = new HashSet<>();
        HashMap<String, Integer> friendOfFriendMap = new HashMap<>();

        //user의 친구들 구하기
        for (List<String> friendList : friends) {
            if(friendList.contains(user)){
                userFriend.add(friendList.get(0));
                userFriend.add(friendList.get(1));
            }
        }
        //자기 자신 제거
        userFriend.remove(user);

        //추천 점수 계산 , user의 친구의 친구일시 +10점
        for (List<String> friendList : friends) {
            String humanA = friendList.get(0);
            String humanB = friendList.get(1);
            String friendOfFriend = "";

            //어떤 사람이 user의 친구일 경우
            if(userFriend.contains(humanA) && !userFriend.contains(humanB)){
                friendOfFriend = humanB;
            }else if(userFriend.contains(humanB) && !userFriend.contains(humanA)){
                friendOfFriend = humanA;
            }

            if(user.equals(friendOfFriend) || friendOfFriend.equals(""))
                continue;

            //친구의 친구Map에 추천 점수 추가
            friendOfFriendMap.put(friendOfFriend ,  friendOfFriendMap.getOrDefault(friendOfFriend,0) + 10);
        }

        //타임라인방문 점수 계산
        for (String visitor : visitors) {
            //방문자가 유저의 친구가 아닐시
            if(!userFriend.contains(visitor)){
                friendOfFriendMap.put(visitor ,  friendOfFriendMap.getOrDefault(visitor,0) + 1);
            }
        }
        //점수를 기준으로 내림차순 정렬 , 점수 같을시 이름순으로 정렬
        List<Map.Entry<String, Integer>> humanScoreMap = new ArrayList<>(friendOfFriendMap.entrySet());
        Collections.sort(humanScoreMap, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> friendOfFriend1, Map.Entry<String, Integer> friendOfFriend2) {
                //점수가 같다면 이름순으로 정렬
                if(friendOfFriend1.getValue().equals(friendOfFriend2.getValue())){
                    return friendOfFriend1.getKey().compareTo(friendOfFriend2.getKey());
                }else{
                    return friendOfFriend2.getValue() - friendOfFriend1.getValue();
                }
            }
        });

        for (Map.Entry<String, Integer> humanAndScore : humanScoreMap) {
            if(answer.size() < 5)
                answer.add(humanAndScore.getKey());
            else
                break;
        }

        return answer;
    }
}
