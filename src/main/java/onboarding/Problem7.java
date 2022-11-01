package onboarding;

import java.util.*;

public class Problem7 {
    /**
     * 친구 추천 알고리즘에 따라 추천된 상위 5명의 이름을 리턴합니다.
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendsCollection<String> friendsCollection = new FriendsCollection<>();
        Counter<String> counter = new Counter<>();
        ScoreCounter<String> scoreCounter = new ScoreCounter<>();

        friendsCollection.addFriendshipAll(friends);
        counter.addAll(visitors);

        for (String other : friendsCollection.getAllUniqueIdentifiers()) {
            Integer mutualFriends = friendsCollection.countMutualFriends(user, other);
            scoreCounter.addScore(other, 10 * mutualFriends);
        }

        for (String other : counter.getAllUniqueIdentifiers()) {
            Integer visitCount = counter.count(other);
            scoreCounter.addScore(other, 1 * visitCount);
        }

        scoreCounter.remove(user);

        for (String friend : friendsCollection.getFriendsOf(user)) {
            scoreCounter.remove(friend);
        }

        return scoreCounter.getTopScorers(5);
    }


    /**
     * 친구 관계를 관리하는 컬렉션
     * <p>
     * 친구 관계를 추가하고, 같이 아는 친구의 수를 조사할 수 있슴니다.
     */
    private static class FriendsCollection<T> {
        private final HashMap<T, HashSet<T>> userNameToFriendsMap = new HashMap<>();

        /**
         * {@code a}와 {@code b} 사이에 친구 관계를 추가합니다.
         */
        public void addFriendship(T a, T b) {
            userNameToFriendsMap.putIfAbsent(a, new HashSet<>());
            userNameToFriendsMap.putIfAbsent(b, new HashSet<>());

            userNameToFriendsMap.get(a).add(b);
            userNameToFriendsMap.get(b).add(a);
        }

        /**
         * 컬렉션의 각 친구 관계를 추가합니다.
         */
        public void addFriendshipAll(Collection<List<T>> c) {
            for (List<T> friendship : c) {
                T friend0 = friendship.get(0);
                T friend1 = friendship.get(1);

                addFriendship(friend0, friend1);
            }
        }

        /**
         * {@code a}의 모든 친구의 컬렉션을 리턴합니다.
         */
        public Collection<T> getFriendsOf(T a) {
            return userNameToFriendsMap.get(a);
        }

        /**
         * {@code a}와 {@code b}가 함께 아는 친구의 수를 리턴합니다.
         */
        public Integer countMutualFriends(T a, T b) {
            userNameToFriendsMap.putIfAbsent(a, new HashSet<>());
            userNameToFriendsMap.putIfAbsent(b, new HashSet<>());

            Set<T> friendsOfA = userNameToFriendsMap.get(a);
            Set<T> friendsOfB = userNameToFriendsMap.get(b);

            Set<T> intersection = new HashSet<>(friendsOfA);
            intersection.retainAll(friendsOfB);

            return intersection.size();
        }

        /**
         * 컬렉션에 존재하는 모든 원소의 집합을 리턴합니다.
         */
        public Set<T> getAllUniqueIdentifiers() {
            return userNameToFriendsMap.keySet();
        }
    }

    /**
     * 원소들을 추가하고, 특정 원소의 개수를 알 수 있는 카운터
     */
    private static class Counter<T> {
        private final HashMap<T, Integer> map = new HashMap<>();

        /**
         * 카운터에 원소 {@code t}를 {@code count}개 추가합니다.
         */
        public void add(T t, Integer count) {
            map.merge(t, count, Integer::sum);
        }

        /**
         * 카운터에 원소를 추가합니다.
         */
        public void add(T t) {
            add(t, 1);
        }

        /**
         * 컬렉션의 각 원소를 카운터에 추가합니다.
         */
        public void addAll(Collection<T> c) {
            for (T t : c) {
                add(t);
            }
        }

        /**
         * 특정 원소를 모두 삭제합니다.
         */
        public void removeToZero(T t) {
            map.remove(t);
        }

        /**
         * 카운터에 특정 원소가 몇 개 있는지 리턴합니다.
         * 해당 원소가 없으면 0을 리턴합니다.
         */
        public Integer count(T t) {
            return map.getOrDefault(t, 0);
        }

        /**
         * 카운터에 존재하는 모든 원소의 집합을 리턴합니다.
         */
        public Set<T> getAllUniqueIdentifiers() {
            return map.keySet();
        }
    }

    /**
     * 점수를 관리하는 카운터
     */
    private static class ScoreCounter<T extends Comparable<? super T>> {
        private final Counter<T> counter = new Counter<>();

        /**
         * 원소 {@code t}에 {@code score}점을 추가합니다.
         */
        public void addScore(T t, Integer score) {
            counter.add(t, score);
        }

        /**
         * 원소의 점수를 리턴합니다.
         */
        public Integer getScore(T t) {
            return counter.count(t);
        }

        /**
         * 원소를 점수표에서 삭제합니다.
         */
        public void remove(T t) {
            counter.removeToZero(t);
        }

        /**
         * 가장 높은 점수를 가지는 원소 {@code length}개를 점수가 높은 순서로 리턴합니다.
         * <p>
         * 점수가 0인 원소는 무시합니다. 동점의 경우 원소의 순서로 정렬합니다.
         */
        public List<T> getTopScorers(Integer length) {
            List<T> elements = new ArrayList<>(counter.getAllUniqueIdentifiers());
            length = Math.min(length, elements.size());

            elements.removeIf(t -> getScore(t) == 0);
            
            Comparator<T> comparator = Comparator
                .<T, Integer>comparing(t -> getScore(t))
                .reversed()
                .thenComparing(t -> t);
            elements.sort(comparator);

            return elements.subList(0, length);
        }
    }
}
