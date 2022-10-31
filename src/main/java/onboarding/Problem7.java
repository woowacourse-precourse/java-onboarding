package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendsScore = new HashMap<>();
        List<String> exceptNames = new ArrayList<>();

        for (List<String> friend : friends) {
            if (isAlreadyFriends(exceptNames, friend)){     //이미 친구인 경우가 존재하면 건너뛴다.
                continue;
            }

            if (registerIsFriend(user, exceptNames, friend)) {  //친구인 경우를 등록해야할 경우 등록을 한다.
                continue;
            }

            for (String friendName : friend) {          // 요구사항에 따라서 10점을 더한다.
                countScore(friendsScore, friendName, 10);
            }
        }

        for (String visitor : visitors) {               // 이미 친구인 경우, Map에서 삭제후 건너뛴다.
            if (isAlreadyFriends(exceptNames, visitor)){
                friendsScore.remove(visitor);
                continue;
            }

            countScore(friendsScore, visitor, 1);   // 요구사항에 따라서 1점을 더한다.
        }

    }


    /**
     * 이미 친구일 경우 ExceptionName에 해당 이름을 등록한다.
     * @param user
     * @param exceptNames
     * @param friend
     * @return
     */
    private static boolean registerIsFriend(String user, List<String> exceptNames, List<String> friend) {
        if (friend.get(0).equals(user)){
            exceptNames.add(friend.get(1));
            return true;
        } else if (friend.get(1).equals(user)){
            exceptNames.add(friend.get(0));
            return true;
        }
        return false;
    }

    /**
     * Map에 이미 존재하면 해당 점수에서 score만큼 더하고, 존재하지 않는다면 처음 생성후 score만큼 더한다.
     * @param friendsScore
     * @param friendName
     * @param score
     * @return
     */
    private static Integer countScore(Map<String, Integer> friendsScore, String friendName, int score) {
        return friendsScore.put(friendName, friendsScore.getOrDefault(friendName, 0) + score);
    }

    /**
     * 이미 친구인 경우를 저장하는 exceptNames에서 들어온 파라미터가 exceptName에 존재하는지 확인
     * @param exceptNames
     * @param friend
     * @return
     */
    private static boolean isAlreadyFriends(List<String> exceptNames, List<String> friend){
        return exceptNames.contains(friend.get(0)) || exceptNames.contains(friend.get(1));
    }
    private static boolean isAlreadyFriends(List<String> exceptNames, String friend){
        return exceptNames.contains(friend);
    }
}
