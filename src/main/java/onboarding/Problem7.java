package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem7 {
    private final static int MAX_RECOMMEND_FRIENDS = 5;

    private static Map<String, Integer> preFriends;
    private static List<String> realFriends;

    private static String me;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initialize();

        validateFriends(friends);
        validateVisitors(visitors);

        setMe(user);
        addAllRealFriends(friends);


        List<String> answer = Collections.emptyList();

        return answer;
    }

    /**
     * 친구 목록 갯수 검증
     * @param friends 데이터
     */
    private static void validateFriends(List<List<String>> friends) {
        int sizeForms = friends.size();

        if (sizeForms == 0 || sizeForms >= 10_000) {
            throw new RuntimeException("친구 목록이 1명 이상 10,000명 이하여야 합니다.");
        }

        for (List<String> friend : friends) {
            if (friend.size() != 2) {
                throw new RuntimeException("친구 목록 중 친구 관계가 올바르게 설정되지 않은 요소가 있습니다.");
            }

            validateUsers(friend);
        }
    }

    /**
     * 방문자 목록 갯수 검증
     * @param visitors 데이터
     */
    private static void validateVisitors(List<String> visitors) {
        int sizeForms = visitors.size();

        if (sizeForms == 0 || sizeForms >= 10_000) {
            throw new RuntimeException("방문자 목록이 1명 이상 10,000명 이하여야 합니다.");
        }

        validateUsers(visitors);
    }

    /**
     * 유저 목록에서 유저 검증
     * @param users 유저 목록
     */
    private static void validateUsers(List<String> users) {
        for (String user: users) {
            if (!validateUser(user)) {
                throw new RuntimeException("유저 데이터 중 올바르지 않는 형식의 유저가 있습니다.");
            }
        }
    }

    /**
     * 유저 검증
     * @param user 유저 정보
     * @return 검증 결과
     */
    private static boolean validateUser(String user) {
        return Pattern.matches("^[a-z]{1,30}$", user);
    }

    /**
     * 친구의 친구에게 10점 주기
     * @param friends 진짜 친구 목록
     */
    private static void addFriendOfFriendPoint(List<List<String>> friends) {
        String me = getMe();

        for(List<String> friend: friends) {
            for (String user : friend) {
                if (existPreFriend(user) && !user.equals(me)) {
                    addPreFriendPoint(friend.get(friend.indexOf(user) ^ 1), 10);
                }
            }
        }
    }



    /**
     * 추천 친구 구하기
     * @param maxRecommendFriends 최대 추천 친구
     * @return 추천 친구 목록
     */
    private static List<String> getTopPreFriends(int maxRecommendFriends) {
        Map<Integer, List<String>> pointAndUsers = new TreeMap<>((i, j) -> (j - i));
        List<String> topPreFriends = new ArrayList<>();

        for (Map.Entry<String, Integer> preFriend : preFriends.entrySet()) {
            String user = preFriend.getKey();
            int point = preFriend.getValue();

            List<String> friends = pointAndUsers.getOrDefault(point, new ArrayList<>());
            friends.add(user);

            pointAndUsers.put(point, friends);
        }

        int rotateKeyPointAndUsers = 0;

        for (int keyPointAndUsers : pointAndUsers.keySet()) {
            if (rotateKeyPointAndUsers >= maxRecommendFriends) {
                break;
            }

            List<String> users = pointAndUsers.get(keyPointAndUsers);
            users.sort(String.CASE_INSENSITIVE_ORDER);
            topPreFriends.addAll(users);

            rotateKeyPointAndUsers++;
        }

        return topPreFriends;
    }

    /**
     * 등록된 예비 친구에게 점수 부여
     * @param user 유저 정보
     * @param point 추가할 점수
     */
    private static void addPreFriendPoint(String user, int point) {
        int previousPoint = getPreFriendsPoint(user);

        putPreFriendAndPoint(user, previousPoint + point);
    }

    /**
     * 예비 친구 등록
     * @param user 유저 정보
     * @param point 기본 점수 설정
     */
    private static void putPreFriendAndPoint(String user, int point) {
        if (user.equals(getMe())) {
            return;
        }

        preFriends.put(user, point);
    }

    /**
     * 예비 친구 존재 여부 확인
     * @param user 유저 정보
     * @return 존재 여부
     */
    private static boolean existPreFriend(String user) {
        return preFriends.containsKey(user);
    }

    /**
     * 예비 친구의 점수 가져오기
     * @param user 유저 정보
     * @return 예비 친구의 점수
     */
    private static int getPreFriendsPoint(String user) {
        return preFriends.getOrDefault(user, 0);
    }

    /**
     * 본인 데이터 가져오기
     * @return 본인 데이터
     */
    private static String getMe() {
        return me;
    }

    /**
     * 친구 목록에 유저 정보 추가
     * @param friends 친구 목록
     */
    private static void addAllRealFriends(List<List<String>> friends) {
        String me = getMe();

        for (List<String> friend : friends) {
            for (String user: friend) {
                if (user.equals(me)) {
                    realFriends.add(friend.get(friend.indexOf(user) ^ 1));
                }
            }
        }
    }

    /**
     * 친구 정보 존재 여부 확인
     * @param user 유저 정보
     * @return 존재 여부
     */
    private static boolean existRealFriend(String user) {
        return realFriends.contains(user);
    }

    /**
     * 친구 정보 가져오기
     * @return 친구 정보
     */
    private static List<String> getRealFriends() {
        return realFriends;
    }

    /**
     * 본인 데이터 설정
     * @param user 유저 정보
     */
    private static void setMe(String user) {
        me = user;
    }

    /**
     * 초기화
     */
    private static void initialize() {
        preFriends = new HashMap<>();
        realFriends = new ArrayList<>();
        me = "";
    }
}
