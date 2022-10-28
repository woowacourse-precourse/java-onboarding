package onboarding;

import static onboarding.Problem7.AccountConst.FRIEND_A_INDEX;
import static onboarding.Problem7.AccountConst.FRIEND_B_INDEX;
import static onboarding.Problem7.FriendScoreConst.FRIEND_RELATION_SCORE;
import static onboarding.Problem7.FriendScoreConst.VISITOR_SCORE;
import static onboarding.Problem7.FriendsRecommender.getRecommendedFriendsName;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        return getRecommendedFriendsName(user, friends, visitors);
    }

    public static class FriendsRecommender {

        private static Map<String, Account> accountInfoMap = new HashMap<>();

        private static void initFriendsRelation(List<List<String>> friends) {
            for (List<String> friend : friends) {
                Account accountA = new Account(friend.get(FRIEND_A_INDEX));
                Account accountB = new Account(friend.get(FRIEND_B_INDEX));

                accountA.addFriend(accountB);
                accountB.addFriend(accountA);
                accountInfoMap.put(friend.get(FRIEND_A_INDEX), accountA);
                accountInfoMap.put(friend.get(FRIEND_B_INDEX), accountB);
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
            target.addScore(target.getNumberOfFriends() * FRIEND_RELATION_SCORE);
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
            accountInfoMap.get(visitor).addScore(VISITOR_SCORE);
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

        public static List<String> getRecommendedFriendsName(String user,
            List<List<String>> friends,
            List<String> visitors) {
            initFriendsRelation(friends);
            initFriendsRelationScore(user);
            initVisitorScore(visitors, user);
            List<Account> accounts = mapAccountInfoMapToAccountList(user);
            sortedScoreDescAndNameAsc(accounts);
            return accounts.stream().map(Account::getId).limit(5).collect(Collectors.toList());
        }
    }

    public abstract class AccountConst {
        public static final int FRIEND_A_INDEX = 0;
        public static final int FRIEND_B_INDEX = 1;
    }

    public abstract class FriendScoreConst {
        public static final int FRIEND_RELATION_SCORE = 10;
        public static final int VISITOR_SCORE = 1;
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
