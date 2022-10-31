package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {

    /**
     *
     * @param user : 주어진 사용자 이름 string
     * @param friends : friends 관계가 나타내져 있는 String[][]
     * @param visitors : 방문자 String
     * @return Set<String> : 모든 유저 이름을 담은 Set
     */
    public static Set<String> getAllUserSet(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> allUser = new HashSet<>();
        allUser.add(user);
        for (String visitor : visitors) {
            allUser.add(visitor);
        }
        for (int i = 0; i < friends.size(); i++) {
            allUser.add(friends.get(i).get(0));
            allUser.add(friends.get(i).get(1));
        }
        return allUser;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
