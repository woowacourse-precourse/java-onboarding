package onboarding;

import java.util.*;

/** 추천 친구 목록을 정렬하기 위한 클래스 */
class RecommendedFriendComparator implements Comparator<String> {
    Map<String, Integer> recommendedFriend = Collections.EMPTY_MAP;
    RecommendedFriendComparator(Map<String, Integer> recommendedFriend){
        this.recommendedFriend = recommendedFriend;
    }

    /**
     * 추천 점수를 기준으로 내림차순 정렬 수행, 추천 점수가 같다면 추천 친구명 사전순으로 오름차순 수행
     * @param leftUser 비교할 첫 번째 유저
     * @param rightUser 비교할 두 번째 유저
     */
    @Override
    public int compare(String leftUser, String rightUser) {
        Integer LeftPoint = recommendedFriend.get(leftUser);
        Integer RightPoint = recommendedFriend.get(rightUser);
        if (LeftPoint.equals(RightPoint)) {
            return leftUser.compareTo(rightUser);
        }
        return RightPoint.compareTo(LeftPoint);
    }
}

/** 모든 유저들의 친구 관계를 관리하는 클래스 */
class UserManager{
    static final int VISIT_POINT = 1;
    static final int FRIEND_POINT = 10;
    private static Map<String, List<String>> friendsMap = Collections.EMPTY_MAP;
    private static UserManager userManager = new UserManager();
    private UserManager(){}


    public static UserManager getUserManager(){
        friendsMap = new HashMap<>();
        return userManager;
    }

    /**
     * friendsMap에 데이터를 추가하는 함수
     * @param sourceUser friendsMap에 들어갈 key가 된다
     * @param destUser source를 key로 가지는 리스트에 add할 String
     */
    private void addFriend(String sourceUser, String destUser){
        List<String> friends = friendsMap.getOrDefault(sourceUser, new ArrayList<>());
        friends.add(destUser);
        friendsMap.put(sourceUser, friends);
    }

    /**
     * friends를 순회하며, 각 유저들의 친구 관계를 friendsMap에 저장
     * @param friends 메소드 solution에서 인자로 받는 친구 관계 정보
     */
    public Map<String, List<String>> getFriendsMap(List<List<String>> friends){
        for(List<String> friend : friends){
            String firstUser = friend.get(0);
            String secondUser = friend.get(1);

            addFriend(firstUser, secondUser);
            addFriend(secondUser, firstUser);
        }
        return friendsMap;
    }
}

/** 사용자 정보 저장 클래스 */
class User {
    private String userName;

    /**
     * 사용자 타임 라인 방문자 리스트
     */
    private List<String> visitors;

    /**
     * 사용자 친구 리스트
     */
    private List<String> friends;

    /**
     * 사용자 추천 친구 리스트
     */
    private Map<String, Integer> recommendedFriend = new HashMap<String, Integer>();

    User(String userName, List<String> visitors, List<String> friends) {
        this.userName = userName;
        this.visitors = visitors;
        this.friends = friends;
    }
}
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
