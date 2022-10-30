package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, Integer> map = getPotentialFriendNameAndScore(user, friends, visitors);

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        // 점수 역순 정렬
        reverseSortByScore(entries);

        // 이름순 정렬
        ifSameScoreThenSortByName(entries);

        List<String> temp = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            temp.add(entry.getKey());
        }

        answer = temp;

        return answer;
    }

    static List<String> getAlreadyFriendWithUserListFromFriends(String user, List<List<String>> friends) {

        List<String> alreadyFriendList = new ArrayList<>();

        for (List<String> friend : friends) {

            if (friend.contains(user)) {
                List<String> temp = friend.stream()
                        .filter((name) -> !name.equals(user))
                        .collect(Collectors.toList());

                alreadyFriendList.addAll(temp);
            }
        }

        return alreadyFriendList;
    }

    static List<String> getPotentialFriendWithUserListFromFriendsAndVisitors(String user, List<List<String>> friends, List<String> visitors) {

        Set<String> set = friends.stream()
                .flatMap(Collection::stream)
                .filter(name -> !name.equals(user))
                .collect(Collectors.toSet());

        Set<String> temp = new HashSet<>(visitors);

        set.addAll(temp);

        List<String> potentialFriendList = new ArrayList<>(set);
        List<String> alreadyFriendWithUserListFromFriends = getAlreadyFriendWithUserListFromFriends(user, friends);

        potentialFriendList.removeAll(alreadyFriendWithUserListFromFriends);

//        System.out.println("potentialFriendList = " + potentialFriendList);

        return potentialFriendList;
    }

    static int howManyKnowEachOtherWithUser(String user, List<List<String>> friends, String potentialFriend) {

        List<String> alreadyFriendList = getAlreadyFriendWithUserListFromFriends(user, friends);
        List<List<String>> listList = new ArrayList<>();

        for (String alreadyFriend : alreadyFriendList) {
            List<String> temp = new ArrayList<>();
            temp.add(potentialFriend);
            temp.add(alreadyFriend);
            listList.add(temp);
        }

//        System.out.println("listList = " + listList);

//        System.out.println("friends = " + friends);

        int count = 0;
        for (List<String> friend : friends) {
            for (List<String> list : listList) {
                if (new HashSet<>(friend).containsAll(list)) {
                    count++;
                }
            }
        }

//        System.out.println("count = " + count);

        return count;
    }

    static int calculateScore(int howManyKnowEachOtherWithUser, String potentialFriend, List<String> visitors) {
        int score = howManyKnowEachOtherWithUser * ScoreType.TEN.getValue();

        score += Collections.frequency(visitors, potentialFriend);

        return score;
    }

    private enum ScoreType {
        TEN(10), ONE(1);

        private final int value;

        ScoreType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    static Map<String, Integer> getPotentialFriendNameAndScore(String user, List<List<String>> friends, List<String> visitors) {
        List<String> potentialFriendList = getPotentialFriendWithUserListFromFriendsAndVisitors(user, friends, visitors);

        Map<String, Integer> map = new HashMap<>();
        for (String potentialFriend : potentialFriendList) {
            int howManyKnowEachOtherWithUser = howManyKnowEachOtherWithUser(user, friends, potentialFriend);
            int calculateScore = calculateScore(howManyKnowEachOtherWithUser, potentialFriend, visitors);

            if (calculateScore > 0) {
                map.put(potentialFriend, calculateScore);
            }
        }

        return map;
    }

    static void reverseSortByScore(List<Map.Entry<String, Integer>> entries) {
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
                return t2.getValue().compareTo(t1.getValue());
            }
        });
    }

    static void ifSameScoreThenSortByName(List<Map.Entry<String, Integer>> entries) {
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
                if (t1.getValue().equals(t2.getValue())) {
                    return t1.getKey().compareTo(t2.getKey());
                }

                return 0;
            }
        });
    }
}
