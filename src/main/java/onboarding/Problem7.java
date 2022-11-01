package onboarding;

import java.util.*;

public class Problem7 {

    /**
     * user와 친구인 친구를 찾아 set에 저장한 후 set을 리턴한다.
     *
     * @param user    친구관계의 주인
     * @param friends 여러 친구관계를 담은 배열
     * @return user와 친구인 사람들의 set
     */
    public static Set<String> findFriends(String user, List<List<String>> friends) {
        Set<String> friendsOfUser = new HashSet<>();

        for (List<String> li : friends) {
            if (li.contains(user)) {
                Optional<String> friend = li.stream()
                        .filter(x -> !x.equals(user))
                        .findFirst();

                friend.ifPresent(friendsOfUser::add);
            }
        }
        return friendsOfUser;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> friendsOfUser = findFriends(user, friends);

    }
}
