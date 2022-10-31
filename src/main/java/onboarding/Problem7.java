package onboarding;

import java.util.Collections;
import java.util.List;

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

        return answer;
    }
}
