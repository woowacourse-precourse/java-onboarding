package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    // List<List<String>> 이 나을까? 아니면 List<Person> 이 나을까 고민하다가,
    // 눈으로 더 정확하게 보이는 것은 List<Person> 이라고 생각해 Person 클래스 추가.
    static class Person {

        private String name;
        private int score;

        public Person(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> userFriends = getUserFriends(user, friends);
        Map<String, Integer> friendsOfFriend = getFriendsOfFriend(user, friends, userFriends);
        List<Person> recommendList = checkVisitors(friendsOfFriend, visitors, userFriends);
        List<String> result = makeResult(recommendList);

        return result;
    }

    private static List<String> makeResult(List<Person> recommendList) {

        Collections.sort(recommendList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.score == o2.score) {
                    return o1.name.compareTo(o2.name);
                }
                return o2.score - o1.score;
            }
        });

        List<String> result = recommendList.stream().map(person -> person.name)
                .limit(5)
                .collect(Collectors.toList());

        return result;
    }

    private static List<Person> checkVisitors(Map<String, Integer> friendsOfFriend, List<String> visitors, List<String> userFriends) {
        for (String visitor : visitors) {
            if (NotMyFriend(visitor, userFriends)) {
                friendsOfFriend.put(visitor, friendsOfFriend.getOrDefault(visitor, 0) + 1);
            }
        }
        return mapToPersonList(friendsOfFriend);
    }

    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            List<String> list = friends.get(i);
            if (list.get(0).equals(user)) {
                userFriends.add(list.get(1));
            }
            if (list.get(1).equals(user)) {
                userFriends.add(list.get(0));
            }
        }
        return userFriends;
    }

    private static Map<String, Integer> getFriendsOfFriend(String user, List<List<String>> friends, List<String> userFriends) {
        Map<String, Integer> relationMap = new HashMap<>();

        for (List<String> pair : friends) {
            for (String userFriend : userFriends) {
                if (pair.get(0).equals(userFriend) && isNotUser(pair.get(1), user)) {
                    relationMap.put(pair.get(1), relationMap.getOrDefault(pair.get(1), 0) + 10);
                }
                if (pair.get(1).equals(userFriend) && isNotUser(pair.get(0), user)) {
                    relationMap.put(pair.get(0), relationMap.getOrDefault(pair.get(0), 0) + 10);
                }
            }
        }

        return relationMap;
    }

    private static List<Person> mapToPersonList(Map<String, Integer> map) {
        List<Person> list = new ArrayList<>();

        for (String name : map.keySet()) {
            Person person = new Person(name, map.get(name));
            list.add(person);
        }

        return list;
    }

    private static boolean isMyFriend(String name, List<String> userFriends) {
        for (int i = 0; i < userFriends.size(); i++) {
            if (userFriends.get(i).equals(name)) {
                return true; //name과 user_friends 중 이름이 같다면 true
            }
        }
        return false; //name 이 같지 않다면 false 반환
    }

    private static boolean NotMyFriend(String name, List<String> userFriends) {
        return !isMyFriend(name, userFriends);
    }
    private static boolean isNotUser(String name, String user) {
        return !name.equals(user); //name과 user가 같지 않다면 true, 같다면 false
    }
}
