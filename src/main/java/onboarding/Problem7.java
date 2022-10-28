package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
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

        private static void initFriendsRelationScore(String user) {
            for (Account target : accountInfoMap.values()) {
                calculateFriendsRelationScore(target, user);
            }
        }

        private static void calculateFriendsRelationScore(Account target, String user) {
            if (target.isAccountId(user) || target.isFriend(user)) {
                return;
            }
            target.addScore(target.getNumberOfFriends() * 10);
        }

        private static void initVisitorScore(List<String> visitors, String user) {
            for (String visitor : visitors) {
                calculateVisitorScore(visitor, user);
            }
        }

        private static void calculateVisitorScore(String visitor, String user) {
            if (!accountInfoMap.containsKey(visitor)) {
                accountInfoMap.put(visitor, new Account(visitor));
            }
            if (accountInfoMap.get(visitor).isFriend(user)) {
                return;
            }
            accountInfoMap.get(visitor).addScore(1);
        }

        private static List<Account> mapAccountInfoMapToAccountList(String user) {
            return accountInfoMap.values().stream().filter(account -> !account.isAccountId(user))
                .filter(Account::scoreOverThanZero).collect(Collectors.toList());
        }

        private static void sortedScoreDescAndNameAsc(List<Account> accounts) {
            accounts.sort((accountA, accountB) -> {
                if (accountA.isEqualsScore(accountB)) {
                    return accountA.getId().compareTo(accountB.getId());
                }
                return accountB.getScore() - accountA.getScore();
            });
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

    public boolean isAccountId(String id) {
        return this.id.equals(id);
    }

    public boolean isFriend(String id) {
        return friendsRelation.stream().anyMatch(account -> account.isAccountId(id));
    }

    public int getNumberOfFriends() {
        return friendsRelation.size();
    }

    public void addScore(int score) {
        this.score += score;
    }

    public boolean scoreOverThanZero() {
        return score > 0;
    }

    public int getScore() {
        return this.score;
    }

    public boolean isEqualsScore(Account account) {
        return this.score == account.getScore();
    }

    public String getId() {
        return this.id;
    }
}
