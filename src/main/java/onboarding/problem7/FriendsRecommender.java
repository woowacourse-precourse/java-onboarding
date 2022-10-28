package onboarding.problem7;

import static onboarding.problem7.consts.AccountConst.FRIEND_A_INDEX;
import static onboarding.problem7.consts.AccountConst.FRIEND_B_INDEX;
import static onboarding.problem7.consts.FriendScoreConst.FRIEND_RELATION_SCORE;
import static onboarding.problem7.consts.FriendScoreConst.VISITOR_SCORE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FriendsRecommender {

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
