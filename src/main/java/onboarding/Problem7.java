package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> allNames = getAllNames(friends, visitors, user);
        List<Integer>[] friendship = new List[allNames.size()];
        friendshipInnerInit(allNames, friendship);

        Map<String, Integer> nameToIdMap = new HashMap<>();
        Map<Integer, String> idToNameMap = new HashMap<>();

        setId(allNames, nameToIdMap, idToNameMap);
        setFriendship(friends, friendship, nameToIdMap);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Set<String> getAllNames(List<List<String>> friends, List<String> visitor, String user) {
        Set<String> allNames = new HashSet<>();

        for (List<String> friend : friends) {
            for (String name : friend) {
                allNames.add(name);
            }
        }

        for (String name : visitor) {
            allNames.add(name);
        }

        allNames.add(user);

        return allNames;
    }

    private static void friendshipInnerInit(Set<String> allNames, List<Integer>[] friendship) {
        for (int i = 0; i < allNames.size(); i++) {
            friendship[i] = new ArrayList<>();
        }
    }

    private static void setId(Set<String> allNames, Map<String, Integer> nameToIdMap, Map<Integer, String> idToNameMap) {
        int sequence = 0;
        for (String name : allNames) {
            nameToIdMap.put(name, sequence);
            idToNameMap.put(sequence, name);

            sequence++;
        }
    }

    private static void setFriendship(List<List<String>> friends, List<Integer>[] friendship, Map<String, Integer> nameToIdMap) {
        for (int i = 0; i < friends.size(); i++) {
            int people = nameToIdMap.get(friends.get(i).get(0));
            int otherPeople = nameToIdMap.get(friends.get(i).get(1));

            friendship[people].add(otherPeople);
            friendship[otherPeople].add(people);
        }
    }
}
