package onboarding;

import java.util.*;

public class Problem7 {

    /**
     * 기능 목록
     * 1. user의 친구목록
     * 2. friends와 visitors에 있는 친구 정리
     * 3. user와 함께 아는 친구의 수 점수 계산
     * 4. user의 타임 라인에 방문한 친구 점수 계산
     * 5. 추천인 5명 뽑기
     * 6. 이미 친구인 사이 삭제
     */

    // friends와 visitors의 친구 목록 정리
    static HashMap<String, Integer> friendList = new HashMap<>();

    /**
     * 1. user의 친구목록
     * @param user : user 아이디
     * @param friends : 친구 관계
     * @return : user의 친구목록
     */
    static List<String> findUserFriends(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            String id1 = friend.get(0);
            String id2 = friend.get(1);

            // 친구 관계에 user 아이디가 존재하면 user와 친구 관계
            if (id1.equals(user)) userFriends.add(id2);
            if (id2.equals(user)) userFriends.add(id1);
        }

        return userFriends;
    }

    /**
     * 2. friends와 visitors에 있는 친구 정리
     * @param user : user 아이디
     * @param friends : 친구 관계
     * @param visitors : 방문자
     */
    static void makeFriendList(String user, List<List<String>> friends, List<String> visitors){

        for (List<String> friend : friends) {
            String id1 = friend.get(0);
            String id2 = friend.get(1);

            // user 아이디가 아니면서 friendList에 없는 경우 친구 목록에 추가
            if (!id1.equals(user)) friendList.put(id1, 0);
            if (!id2.equals(user)) friendList.put(id2, 0);
        }

        // 방문자 친구 목록에 추가
        for (String visitor : visitors) {
            friendList.put(visitor, 0);
        }
    }

    /**
     * 3. user와 함께 아는 친구의 수 점수 계산
     * @param user : user 아이디
     * @param userFriends : user의 친구목록
     * @param friends : 친구 관계
     */
    static void countFriends (String user, List<String> userFriends, List<List<String>> friends){
        for (List<String> friend : friends) {
            String id1 = friend.get(0);
            String id2 = friend.get(1);

            for (String userFriend : userFriends) {
                if (id1.equals(userFriend) && !user.equals(id2)) friendList.put(id2, friendList.get(id2) + 10);
                if (id2.equals(userFriend) && !user.equals(id2)) friendList.put(id1, friendList.get(id1) + 10);
            }
        }
    }

    /**
     * 4. user의 타임 라인에 방문한 친구 점수 계산
     * @param visitors : 방문자
     */
    static void countVisitors (List<String> visitors){
        for (String visitor : visitors) {
            friendList.put(visitor, friendList.get(visitor) + 1);
        }
    }

    /**
     * 5. 추천인 5명 뽑기
     * @param userFriends : user 친구목록
     * @return : 추천인 5명
     */
    static List<String> selectFriends (List<String> userFriends) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(friendList.entrySet());
        entries.sort((value1, value2) -> value2.getValue().compareTo(value1.getValue()));

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries){
            if (entry.getValue() != 0 && result.size() < 5) result.add(entry.getKey());
            if (entry.getValue() == 0) break;
        }

        deleteAlreadyFriend(result, userFriends);

        return result;
    }

    /**
     * 6. 이미 친구인 사이 삭제
     * @param answer : 추천인 5명 목록
     * @param userFriends : user 친구 목록
     */
    static void deleteAlreadyFriend(List<String> answer, List<String> userFriends){
        for (String userFriend : userFriends) {
            for (int j = 0; j < answer.size(); j++) {
                if (userFriend.equals(answer.get(j))) {
                    answer.remove(j);
                    j--;
                }
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // user의 친구 목록
        List<String> userFriends = findUserFriends(user, friends);

        makeFriendList(user, friends, visitors);
        countFriends(user, userFriends, friends);
        countVisitors(visitors);
        
        return selectFriends (userFriends);
    }
}
