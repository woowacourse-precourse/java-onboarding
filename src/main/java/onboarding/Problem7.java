package onboarding;

import onboarding.exception.InputRangeException;
import onboarding.exception.InputTypeException;

import java.util.*;
import java.util.regex.Pattern;

public class Problem7 {

    // 전체 사용자의 친구 관계를 정의할 Map을 선언한다.
    // key 값으로 사용자의 아이디, value 값으로 리스트로 해당 사용자의 친구 리스트가 들어간다.
    static Map<String, List<String>> friendMap;

    // 점수 정보를 관리할 Map을 선언한다.
    // key 값으로 사용자의 아이디, value 값으로 점수가 들어간다.
    static Map<String, Integer> scoreMap;

    // 사용자의 친구 목록 리스트를 관리한다.
    static List<String> userFriendList;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendMap = new HashMap<>();
        scoreMap = new HashMap<>();

        // 입력으로 받은 user 문자열에 대해 검증한다.
        checkRangeValidation(user.length(), 1, 30);

        // friends의 사이즈에 대해서 검증한다.
        checkRangeValidation(friends.size(), 1, 10000);

        // visitors 사이즈에 대해서 검증한다.
        checkRangeValidation(visitors.size(), 0, 10000);

        // 전체 사용자에 대한 친구 관계를 정의한다.
        for(List<String> relationship : friends) {
            // 각 원소의 길이가 2인지 검증한다.
            checkRangeValidation(relationship.size(), 2, 2);
            defineFriendship(relationship);
        }

        // 사용자의 친구 목록을 조회한다.
        userFriendList = friendMap.get(user);

        // 친구 관계 Map에서 사용자의 정보를 제거한다. (기준이 사용자이기 때문)
        friendMap.remove(user);

        // 다른 사용자의 친구 리스트를 조회하여 사용자의 친구 리스트와 비교한다.
        for(String diffUser : friendMap.keySet()) {
            getFriendsOfDiffUserAndCompare(diffUser);
        }

        // 사용자의 타임라인을 방문한 사용자에 대해 1점씩 부여한다.
        addOneScoreToVisitors(visitors);

        // 사용자와 이미 친구인 사용자는 추천에서 제외한다.
        removeAlreadyUserFriend();

        // 점수가 0점인 사용자는 제거한다.
        for(String recommendUser : scoreMap.keySet()) {
            removeUserWithZeroScore(recommendUser);
        }

        // 점수와 이름 순서대로 정렬을 진행한다.
        List<String> recommendUserList = new ArrayList<>(scoreMap.keySet());
        recommendUserList.sort(Problem7::sortByScoreAndName);

        // 최종적으로 추천할 인원을 선별한다.
        return selectRecommendUsers(recommendUserList);
    }

    /**
     * 입력 범위에 대한 검증을 진행한다.
     *
     * @param number 검증할 숫자
     * @param start 첫 범위
     * @param end 끝 범위
     */
    private static void checkRangeValidation(int number, int start, int end) {
        if(number < start || number > end) {
            throw new InputRangeException(start + "~" + end + " 사이여야 합니다.");
        }
    }

    /**
     * 입력받은 아이디에 대한 검증을 진행한다.
     *
     * @param userId 사용자의 아이디
     */
    private static void checkIdValidation(String userId) {
        // 아이디의 길이는 1~30 사이로, 소문자로만 구성되어야 한다.
        String regex = "^[a-z]{1,30}$";
        if (!Pattern.matches(regex, userId)) {
            throw new InputTypeException("아이디의 길이는 1~30 사이로, 소문자로만 구성되어야 합니다.");
        }
    }

    /**
     * 최종적으로 추천할 사용자를 뽑는다.
     *
     * @param recommendUserList 정렬된 사용자 리스트
     * @return 추천할 사용자 리스트를 리턴한다.
     */
    private static List<String> selectRecommendUsers(List<String> recommendUserList) {
        List<String> answer = new ArrayList<>();

        // 기존 추천 리스트에 담긴 인원이 5명보다 작으면 그대로, 아니라면 최대 5명까지 선별한다.
        int numberOfUser = Math.min(recommendUserList.size(), 5);

        for(int i=0; i<numberOfUser; i++) {
            answer.add(recommendUserList.get(i));
        }

        return answer;
    }

    /**
     * 추천 리스트를 점수(내림차순)와 이름(사전순)에 따라 정렬한다.
     *
     * @param userA 비교할 사용자 A
     * @param userB 비교할 사용자 B
     * @return 정렬 결과에 따른 -1, 0(변경하지 않음), 1(자리 변경)이 리턴된다.
     */
    private static int sortByScoreAndName(String userA, String userB) {
        // 점수가 같다면 이름순으로 정렬한다.
        if (Objects.equals(scoreMap.get(userA), scoreMap.get(userB))) {
            return userA.compareTo(userB);
        }
        // 그게 아니라면 점수를 기준으로 내림차순 정렬한다.
        return scoreMap.get(userB) - scoreMap.get(userA);
    }

    /**
     * 점수가 0점인 사용자는 점수 Map에서 제거한다.
     *
     * @param recommendUser 추천 후보 사용자 아이디
     */
    private static void removeUserWithZeroScore(String recommendUser) {
        if (scoreMap.get(recommendUser) == 0) {
            scoreMap.remove(recommendUser);
        }
    }

    /**
     * 사용자와 이미 친구인 경우 제거한다.
     */
    private static void removeAlreadyUserFriend() {
        for(String userFriend : userFriendList) {
            scoreMap.remove(userFriend);
        }
    }

    /**
     * 사용자의 타임라인을 방문한 사용자에게 1점씩 부여한다.
     *
     * @param visitors 사용자의 타임라인 방문자
     */
    private static void addOneScoreToVisitors(List<String> visitors) {
        for(String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor,0) + 1);
        }
    }

    /**
     * 다른 사용자의 친구 리스트를 조회하여 사용자의 친구 리스트와 비교한다.
     *
     * @param diffUser 다른 사용자의 아이디
     */
    private static void getFriendsOfDiffUserAndCompare(String diffUser) {
        List<String> diffFriendList = friendMap.get(diffUser);
        for(String friendOfDiffUser : diffFriendList) {
            addTenScore(diffUser, friendOfDiffUser);
        }
    }

    /**
     * 사용자의 친구 리스트와 동일한 친구를 가지고 있다면, 해당 사용자에게 10점을 부여한다.
     *
     * @param diffUser 다른 사용자 아이디
     * @param friendOfDiffUser 다른 사용자의 친구
     */
    private static void addTenScore(String diffUser, String friendOfDiffUser) {
        if (userFriendList.contains(friendOfDiffUser)) {
            scoreMap.put(diffUser, scoreMap.getOrDefault(diffUser, 0) + 10);
        }
    }

    /**
     * 전체 사용자의 친구 목록을 친구 관계 Map에 저장한다.
     *
     * @param relationship 친구 관계 정보
     */
    private static void defineFriendship(List<String> relationship) {
        String userA = relationship.get(0);
        String userB = relationship.get(1);

        // 아이디에 대한 검증을 진행한다.
        checkIdValidation(userA);

        // 만약 처음 삽입된다면 초기화 작업을 진행해준다.
        List<String> friendListOfUserA = friendMap.getOrDefault(userA, new ArrayList<>());
        // 친구 정보를 추가한다.
        friendListOfUserA.add(userB);

        List<String> friendListOfUserB = friendMap.getOrDefault(userB, new ArrayList<>());
        friendListOfUserB.add(userA);

        // 친구 관계 Map에 추가한다.
        friendMap.put(userA, friendListOfUserA);
        friendMap.put(userB, friendListOfUserB);
    }
}
