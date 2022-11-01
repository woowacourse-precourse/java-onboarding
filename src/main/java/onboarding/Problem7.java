package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> usersFriends = getUsersfriends(friends, user);
        System.out.println(usersFriends.toString());
        Map<String, List<String>> friend_map = getfriends(friends);

        return answer;
    }

    /**
     * User의 친구 목록을 찾는 메소드
     * @param friends
     * @return {List<String>} usersFriends
     */
    private static List<String> getUsersfriends(List<List<String>> friends, String user) {
        List<String> usersFriends = new ArrayList<>();

        for(List<String> fr_list : friends) {
            if(fr_list.contains(user)) {
                if(fr_list.get(0).equals(user)) usersFriends.add(fr_list.get(1));
                else usersFriends.add(fr_list.get(0));
            }
        }

        return usersFriends;
    }

    /**
     * 친구 관계를 정리하여 리턴
     * @param friends
     * @return
     */
    private static Map<String, List<String>> getfriends(List<List<String>> friends) {
        Map<String, List<String>> friend_map = new HashMap<>();


        for (List<String> fr_list : friends) {
            // fr_list.contains()
        }
        return null;
    }
}
