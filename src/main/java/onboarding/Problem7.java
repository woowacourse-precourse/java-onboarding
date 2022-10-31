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

    private static class Dictionary {
        private final Set<String> friends = new HashSet<>();
        private final Map<String, Integer> memberAndScore = new HashMap<>();
        private String originUser;

        Dictionary() {
        }

        Dictionary(String user, List<List<String>> friendsForm) {
            this.originUser = user;

            friendsForm.forEach(pair -> {
                if (isOriginUser(pair.get(0))) {
                    friends.add(pair.get(1));
                }

                if (isOriginUser(pair.get(1))) {
                    friends.add(pair.get(0));
                }

                memberAndScore.put(pair.get(0), 0);
                memberAndScore.put(pair.get(1), 0);
            });
        }

        public void updateScoreByRelationShip(List<List<String>> friendsForm) {
            friendsForm.forEach(relationShip -> {
                String user = relationShip.get(0);
                String other = relationShip.get(1);

                if (isFriendWithOriginsFriend(user)) {
                    memberAndScore.put(other, memberAndScore.get(other) + 10);
                }

                if (isFriendWithOriginsFriend(other)) {
                    memberAndScore.put(other, memberAndScore.get(other) + 10);
                }

            });
        }

        public void updateScoreByVisit(List<String> visitors) {
            visitors.forEach(visitor -> memberAndScore.merge(visitor, 1, Integer::sum));
        }

        public List<String> getResult() {
            return memberAndScore.keySet().stream()
                    .filter(member -> isZeroScore(member) && !isFriendWithOriginsFriend(member) && !isOriginUser(member))
                    .sorted()
                    .sorted((o1, o2) -> memberAndScore.get(o2).compareTo(memberAndScore.get(o1)))
                    .limit(5)
                    .collect(Collectors.toList());
        }

        private boolean isZeroScore(String o) {
            return memberAndScore.get(o) != 0;
        }

        private boolean isOriginUser(String other) {
            return other.equals(originUser);
        }

        private boolean isFriendWithOriginsFriend(String user) {
            return friends.contains(user);
        }

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Dictionary dictionary = new Dictionary(user, friends);

        dictionary.updateScoreByRelationShip(friends);

        dictionary.updateScoreByVisit(visitors);

        return dictionary.getResult();
    }

}
