package onboarding.prob7.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InitProcessor {

    public List<String> getCandidates(String user, List<List<String>> tableOfFriends, List<String> visitors) {
        List<String> users = getSortedAllUserExceptMyself(user, tableOfFriends, visitors);
        List<String> friends = getSortedFriends(user, tableOfFriends);
        List<String> candidates = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            boolean sameUser = false;
            for (int j = 0; j < friends.size(); j++) {
                if (isEquals(users.get(i), friends.get(j))) sameUser = true;
            }
            if (sameUser) continue;
            candidates.add(users.get(i));
        }
        return candidates;
    }

    private boolean isEquals(String user, String friend) {
        return user.equals(friend);
    }

    final List<String> getSortedAllUserExceptMyself(String user, List<List<String>> tableOfFriends, List<String> visitors) {
        Set<String> candidatesSet = new HashSet<>(visitors);
        tableOfFriends.forEach(list -> {
            if (!list.get(0).equals(user)) candidatesSet.add(list.get(0));
            if (!list.get(1).equals(user)) candidatesSet.add(list.get(1));
        });
        return new ArrayList<>(candidatesSet).stream().sorted().collect(Collectors.toList());
    }

    public List<String> getSortedFriends(String user, List<List<String>> tableOfFriends) {
        Set<String> friends = new HashSet<>();
        tableOfFriends.forEach(list -> {
            if (list.get(1).equals(user)) friends.add(list.get(0));
            if (list.get(0).equals(user)) friends.add(list.get(1));
        });
        return new ArrayList<>(friends).stream().sorted().collect(Collectors.toList());
    }
}
