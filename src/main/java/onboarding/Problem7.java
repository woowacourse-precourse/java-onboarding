package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        TreeSet<String> friendSet = findFriends(user, friends);
        TreeSet<String> peopleSet = findPeople(user, friends, visitors, friendSet);
        LinkedHashMap commonFriendMap = new LinkedHashMap();
        LinkedHashMap visitCount = new LinkedHashMap();

        for (String person : peopleSet) {
            commonFriendMap.put(person, makeCommonFriends(person, friends));
        }

        for (String person : peopleSet) {
            visitCount.put(person, countVisits(person));
        }


        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static TreeSet<String> findFriends(String user, List<List<String>> friends) {
        TreeSet<String> Set = new TreeSet<String>();
        for (List<String> e : friends) {
            int indexOfMe = e.indexOf(user);
            if (indexOfMe == 1) {
                String friendName = e.get(0);
                Set.add(friendName);
            } else if (indexOfMe == 0) {
                String friendName = e.get(1);
                Set.add(friendName);
            }
        }
        return Set;
    }

    private static TreeSet<String> findPeople(String user, List<List<String>> friends, List<String> visitors, TreeSet<String> friendSet) {
        TreeSet<String> Set = new TreeSet<String>();
        for (List<String> e : friends) {
            Set.add(e.get(0));
            Set.add(e.get(1));
        }
        for (String e : visitors) {
            Set.add(e);
        }
        Set.remove(user);
        Set.removeAll(friendSet);
        return Set;
    }

    private static TreeSet<String> makeCommonFriends(String person, List<List<String>> friends) {
        TreeSet<String> commonFriendSet = new TreeSet<>();
        for (List<String> j : friends) {
            if (j.indexOf(person) != -1) {
                int indexOfPerson = j.indexOf(person);
                if (indexOfPerson == 1) {
                    String friendName = j.get(0);
                    commonFriendSet.add(friendName);
                } else if (indexOfPerson == 0) {
                    String friendName = j.get(1);
                    commonFriendSet.add(friendName);
                }
            }
        }
        return commonFriendSet;
    }

    private static int countVisits(String person, List<String> visitors) {
        int count = 0;
        for (String visitor : visitors) {
            if (visitor.indexOf(person) != -1) {
                count = count + 1;
            }
        }
        return count;
    }

}
