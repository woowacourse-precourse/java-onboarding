package onboarding;

import java.util.*;

public class Problem7 {

    /**
     * user를 제외한 사용자 List를 구함
     * @param user
     * @param friends
     * @return
     */
    private static List<String> getUsersList(String user, List<List<String>> friends) {
        HashSet<String> users = new HashSet<>();

        for (List<String> next : friends) {
            if (!user.equals(next.get(0))) {
                users.add(next.get(0));
            }
            if (!user.equals(next.get(1))) {
                users.add(next.get(1));
            }
        }

        List<String> result = new ArrayList<>();
        for (String userName : users) {
            result.add(userName);
        }
        return result;
    }

    /**
     * 각 사용자별 현재 이미 친구인 사람들을 구함
     * @param userList
     * @param friends
     * @return
     */
    private static HashMap<String, HashSet<String>> getEachFriendsList(List<String> userList, List<List<String>> friends) {
        HashMap<String, HashSet<String>> result = new HashMap<>();
        for (String otherUser : userList) {
            HashSet<String> tempSet = new HashSet<>();
            result.put(otherUser, tempSet);
        }

        for(List<String> next : friends) {
            result.get(next.get(0)).add(next.get(1));
            result.get(next.get(1)).add(next.get(0));
        }
        return result;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userList = getUsersList(user, friends);
        HashMap<String, HashSet<String>> userFriendsList = getEachFriendsList(userList, friends);

        HashMap<String, Integer> userScore = new HashMap<>();
    }
}
