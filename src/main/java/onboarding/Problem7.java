package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 📚 기능 목록
 * 1. 사전 객체 - Dictionary
 * 1-1. 사용자의 친구와 전체 인원의 점수 map을 가진다. - friends, memberAndScore
 * 1-2. 사용자와 친구관계 List를 받아 위 변수를 초기화한다. - Dictionary(String user, List friendsForm)
 * 1-3. 주어진 친구관계 List를 받아 해당하는 인원에게 점수를 적용한다. - updateScoreByRelationShip
 * 1-4. 주어진 방문자 목록을 받아 해당하는 인원에게 점수를 적용한다. - updateScoreByVisit
 * 1-5. 가지고있는 정보를 토대로 주어진 조건에 맞춰 결과값을 반환한다. - getResult
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

                if (isAlreadyFriend(user)) {
                    memberAndScore.put(other, memberAndScore.get(other) + 10);
                }

                if (isAlreadyFriend(other)) {
                    memberAndScore.put(user, memberAndScore.get(user) + 10);
                }

            });
        }

        public void updateScoreByVisit(List<String> visitors) {
            visitors.forEach(visitor -> memberAndScore.merge(visitor, 1, Integer::sum));
        }

        public List<String> getResult() {
            return memberAndScore.keySet().stream()
                    .filter(member -> !isZeroScore(member) && !isAlreadyFriend(member) && !isOriginUser(member))
                    .sorted()
                    .sorted((o1, o2) -> memberAndScore.get(o2).compareTo(memberAndScore.get(o1)))
                    .limit(5)
                    .collect(Collectors.toList());
        }

        private boolean isZeroScore(String o) {
            return memberAndScore.get(o) == 0;
        }

        private boolean isOriginUser(String other) {
            return other.equals(originUser);
        }

        private boolean isAlreadyFriend(String user) {
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
