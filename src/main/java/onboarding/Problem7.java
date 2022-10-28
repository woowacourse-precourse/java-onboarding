package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 📚 기능 목록
 *
 * 1. 사용자의 친구를 구하는 기능
 * 2. 함께 아는 친구(위에서 구한 친구)를 가진 사용자를 구하는 기능
 * 3. 점수를 부여하는 기능
 * 4. 결과를 정렬하는 기능
 */
public class Problem7 {

    /** 사용자의 친구 목록이 저장된다 */
    static Set<String> friendDictionary = new HashSet<>();

    /** 모든 사용자의 이름,점수가 저장된다 */
    static Map<String, Integer> memberDictionary = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        initDictionary(user, friends);

        return answer;
    }

    /**
     * friendDictionary와 memberDictionary에 초기값을 넣는다
     * @param user : 사용자 이름
     * @param friends : 친구관계 목록
     */
    private static void initDictionary(String user, List<List<String>> friends) {
        friends.forEach(pair -> updateDictionary(pair, user));
    }

    /**
     * 사용자의 친구를 memberFriends List에 저장한다.
     * 모든 사용자를 구해 otherMembers Map에 저장한다.
     * @param pair 한 쌍의 친구관계
     * @param user 사용자 이름
     */
    private static void updateDictionary(List<String> pair, String user) {
        if (pair.get(0).equals(user)) {
            friendDictionary.add(pair.get(1));
            memberDictionary.put(pair.get(1), 0);
        }

        if (pair.get(1).equals(user)) {
            friendDictionary.add(pair.get(0));
            memberDictionary.put(pair.get(0), 0);
        }

        if (!pair.contains(user)) {
            memberDictionary.put(pair.get(0), 0);
            memberDictionary.put(pair.get(1), 0);
        }
    }
}
