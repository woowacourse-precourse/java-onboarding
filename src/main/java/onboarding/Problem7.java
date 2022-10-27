package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static class FriendsRecommender {
        private static Map<String, Account> accountInfoMap = new HashMap<>();

        private static void initFriendsRelation(List<List<String>> friends) {
            for (List<String> friend : friends) {
                Account accountA = new Account(friend.get(0));
                Account accountB = new Account(friend.get(1));

                accountA.addFriend(accountB);
                accountB.addFriend(accountA);
                accountInfoMap.put(friend.get(0), accountA);
                accountInfoMap.put(friend.get(1), accountB);
            }
        }
    }
}

class Account {
    private final String id;
    private final Set<Account> friendsRelation;
    private int score;

    public Account(String id) {
        this.id = id;
        this.friendsRelation = new HashSet<>();
        this.score = 0;
    }

    public void addFriend(Account friend) {
        friendsRelation.add(friend);
    }
}