package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {



    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return findAllScore(user,friends,visitors);
    }


    /**
     * [사용자 아이디와 친구 관계 정보 사용자 타임 라인 방문 기록을 입력받아 친구 추천 리스트를 반환]
     *  - 모든 친구 관계를 구한다.
     *  - 사용자 친구 추천 스코어를 구한다.
     *  - 함께 아는 친구를 구해 점수를 부여한다.
     *  - 타임라인에 방문한 친구의 점수를 부여한다.
     *  - 추천 친구의 이름을 List로 반환한다.
     * @param user
     * @param friends
     * @param visitors
     * @return - 추천 친구 리스트
     */
    public static List<String> findAllScore(String user,
                                            List<List<String>> friends,
                                            List<String> visitors) {
        Map<String, List<String>> allUserFriendsList = new HashMap<>();
        Map<String, Integer> scoreBoard = new HashMap<>();
        return new ArrayList<>();
    }

    /**
     *[친구 목록 Map 변환]
     * - 입력받은 친구 관계 리스트를 각 유저 별 친구 리스트로 변환한다.
     *
     * @param friends
     * @return
     */
    public static void findFriends(List<List<String>> friends,
                                   Map<String,List<String>> allUserFriendsList) {
        for (List<String> friend : friends) {
            int check = -1;
            for (int i = 0 ; i < 2 ; i++) {
                if (!allUserFriendsList.containsKey(friend.get(i))) {
                    allUserFriendsList.put(friend.get(i), new ArrayList<>());
                }
                check *= -1;
                allUserFriendsList.get(friend.get(i)).add(friend.get(i + check));
            }
        }
    }

    /**
     * [함께 아는 친구의 점수 부여]
     * - 사용자와 직접적인 친구 리스트를 생성한다.
     * - 해당 친구의 친구 목록을 구해 점수를 부여한다.
     *
     * @param allUserFriendsList
     * @param userName
     * @param scoreBoard
     */
    public static void addAcquaintanceScore (Map<String, List<String>> allUserFriendsList,
                                             String userName,
                                             Map<String, Integer> scoreBoard) {

    }

    /**
     * [방문한 친구의 점수 부여]
     * - 사용자의 타임라인에 방문한 사용자에게 점수를 부여한다.
     * - 사용자와 친구가 아닌 사용자를 추출한다.
     * @param visitors
     * @param allUserFriendsList
     * @param user
     * @param scoreBoard
     */
    public static void addVisitedScore(List<String> visitors,
                                       Map<String, List<String>> allUserFriendsList,
                                       String user,
                                       Map<String, Integer> scoreBoard){


    }

    /**
     * [추천 친구 리스트 생성]
     * - 점수가 가장 높은 5명의 친구를 선정하여 리스트로 반환한다.
     * - 점수가 같은 경우 사전순으로 정렬한다.
     * - 0점인 친구는 추천하지 않는다.
     * @param scoreBoard
     * @return
     */
    public static List<String> changeRecommendedRankingList(Map<String, Integer> scoreBoard) {
        return new ArrayList<>();
    }

}
