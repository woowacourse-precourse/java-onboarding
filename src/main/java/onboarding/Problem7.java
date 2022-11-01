package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> usersFriends = getUsersFriends(friends, user);
        List<String> userUnionFriends = getUserUnionFriends(usersFriends, friends, user);
        List<String> visitUser = getVisitUser(visitors, usersFriends);

        // Map에 추천친구에 해당하는 user의 point 넣기
        Map<String, Integer> point = setUserMap(visitUser, userUnionFriends);
        
        // Point 값에 따라 정렬하기
        List<String> keySet = setOrderByPointAndName(point);

        // 상위 5개를 추려서 추천 친구리스트에 담기
        for(int i = 0; i < keySet.size() && i < 5; i++) answer.add(keySet.get(i));

        return answer;
    }

    /**
     * point 점수와 이름에 따라서 정렬한는 메소드
     * @param point 추천 유저의 정보를 담은 Map
     * @return
     */
    private static List<String> setOrderByPointAndName(Map<String, Integer> point) {
        List<String> keySet = new ArrayList<>(point.keySet());
        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(point.get(o1) == point.get(o2)) {
                    return o1.compareTo(o2);
                } else return point.get(o1).compareTo(point.get(o2));
            }
        });

        return keySet;
    }

    /**
     * 추천친구에 해당하는 대상의 point 넣기
     * @param visitUser User의 SNS의 방문한 사람
     * @param userUnionFriends User와 겹친구인 친구목록
     * @return point
     */
    private static Map<String, Integer> setUserMap(List<String> visitUser, List<String> userUnionFriends) {
        Map<String, Integer> point = new HashMap<>();


        if(!visitUser.isEmpty()) {
            for(String userName : visitUser) point.put(userName, point.getOrDefault(userName, 0) + 10);
        }

        if(!userUnionFriends.isEmpty()) {
            for(String userName : userUnionFriends) point.put(userName, point.getOrDefault(userName, 0) + 1);
        }

        return point;
    }

    /**
     * User의 SNS의 방문한 사람 중 User와 친구가 아닌 사람을 찾는 메소드
     * @param visitors User의 SNS의 방문한 기록
     * @param usersFriends User의 친구 List
     * @return visistUser
     */
    private static List<String> getVisitUser(List<String> visitors, List<String> usersFriends) {
        HashSet<String> visistUserSet = new HashSet<>();

        for (String visistUserName : visitors) {
            if(!usersFriends.contains(visistUserName)) visistUserSet.add(visistUserName);
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

