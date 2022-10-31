package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = Collections.emptyList();

        // 추천 점수
        Map<String, Integer> scores = new HashMap<>();

        /**
         * user 와 함께 아는 친구의 수마다 10점씩 부여한다.
         */

        // 각자의 친구가 누가 있는지 조사한다. key:이름, value:친구리스트
        Map<String, List<String>> friendsDictionary = makeFreindsInfo(friends);


        // user 의 친구를 확인할 수 있는 map
        Map<String, Boolean> isUserFriend = new HashMap<>();
        for (String name : friendsDictionary.get(user)) {
            isUserFriend.put(name, true);
        }

        // user 와 함께 아는 친구가 있다면 10점씩 증가
        for (Map.Entry<String, List<String>> friendInfo : friendsDictionary.entrySet()) {
            String key = friendInfo.getKey();
            if (!key.equals(user)) { // 사용자 본인은 추천 대상자가 아니므로 점수 계산을 하지 않음
                List<String> friendList = friendInfo.getValue();
                for (String name : friendList) {
                    if (isUserFriend.getOrDefault(name, false)) {
                        scores.merge(key, 10, (k, v) -> v + 10);
                    }
                }
            }
        }

        /**
         * 방문 점수를 계산한다.
         */
        for (String key : visitors) {
            scores.merge(key, 1, (k, v) -> v + 1);
        }

        // 점수 정보를 바탕으로 결과를 반환한다.
        answer = getResult(scores, isUserFriend);
        return answer;
    }


    /**
     *
     * @param scores 점수 정보
     * @param isUserFriend User 의 친구 정보
     * @return 점수 및 이름 순으로 정렬한 추천인 5명
     */
    private static List<String> getResult(Map<String, Integer> scores, Map<String, Boolean> isUserFriend) {
        List<Person> persons = new ArrayList<>();
        List<String> result = new LinkedList<>();

        for (Map.Entry<String, Integer> info : scores.entrySet()) {
            String name = info.getKey();
            Integer score = info.getValue();
            if (score > 0 && !isUserFriend.getOrDefault(name, false)) {
                persons.add(new Person(name, score));
            }
        }
        persons.sort((Person p1, Person p2) -> {
            if (p1.score == p2.score) {
                return p1.name.compareTo(p2.name);
            } else {
                return p2.score - p1.score;
            }
        });

        Iterator<Person> it = persons.iterator();
        while (it.hasNext() && result.size() < 5) {
            result.add(it.next().name);
        }

        return result;
    }

    /**
     * 모든 사용자에 대하여 친구를 확인할 수 있는 정보를 만들어준다.
     *
     * @return Map (key:이름, value:리스트[key와 친구인 사람들])
     */
    private static Map<String, List<String>> makeFreindsInfo(List<List<String>> friends) {
        Map<String, List<String>> result = new HashMap<>();

        for (List<String> friendList : friends) {
            String key = friendList.get(0);
            String value = friendList.get(1);
            result.computeIfAbsent(key, k -> new ArrayList()).add(value);
            result.computeIfAbsent(value, k -> new ArrayList()).add(key);
        }
        return result;
    }

    static class Person {
        String name;
        int score;

        public Person(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }
    }
}
