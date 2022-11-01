package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> usersFriends = getUsersFriends(friends, user);
        List<String> userUnionFriends = getUserUnionFriends(usersFriends, friends, user);
        List<String> visitUser = getVisitUser(visitors);

        Map<String, Integer> point = new HashMap<>();
        // 겹친구의 Point 계산
        for(String userName : userUnionFriends) {
            point.put(userName, point.getOrDefault(userName, 0) + 10);
        }


        return answer;
    }

    /**
     * User의 SNS의 방문한 사람
     * @param visitors User의 SNS의 방문한 기록
     * @return visistUser
     */
    private static List<String> getVisitUser(List<String> visitors) {
        HashSet<String> visistUserSet = new HashSet<>();

        for (String visistUserName : visitors) {
            visistUserSet.add(visistUserName);
        }
        return visistUserSet.stream().collect(Collectors.toList());
    }

    /**
     * User와 겹친구인 친구목록을 찾는 메소드
     * @param usersFriends 유저의 친구목록
     * @param friends 친구 관계
     * @param user 유저 ID
     * @return {List<String>} userUnionFriends
     */
    private static List<String> getUserUnionFriends(List<String> usersFriends, List<List<String>> friends, String user) {
        HashSet<String> userUnionFriends = new LinkedHashSet<>();

        for(String user_fr : usersFriends) {
            for(List<String> fr_list : friends) {
                // 유저 자기자신은 제외
                if(fr_list.contains(user_fr) && !fr_list.contains(user)) {
                    if(fr_list.get(0).equals(user_fr)) userUnionFriends.add(fr_list.get(1));
                    else userUnionFriends.add(fr_list.get(0));
                }
            }
        }

        return userUnionFriends.stream().collect(Collectors.toList());
    }

    /**
     * User의 친구 목록을 찾는 메소드
     * @param friends 유저의 친구목록
     * @return {List<String>} usersFriends
     */
    private static List<String> getUsersFriends(List<List<String>> friends, String user) {
        List<String> usersFriends = new ArrayList<>();

        for(List<String> fr_list : friends) {
            if(fr_list.contains(user)) {
                if(fr_list.get(0).equals(user)) usersFriends.add(fr_list.get(1));
                else usersFriends.add(fr_list.get(0));
            }
        }

        return usersFriends;
    }


}
