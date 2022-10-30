package onboarding.problem7;

import static java.util.stream.Collectors.toList;
import static onboarding.problem7.consts.FriendConst.RECOMMEND_FRIEND_LIST_LIMIT;
import static onboarding.problem7.consts.FriendConst.FRIEND_RELATION_SCORE;
import static onboarding.problem7.consts.FriendConst.VISITOR_SCORE;

import java.util.List;

public class FriendRecommendService {

    private final AccountInfo accountInfo;
    private final String targetUser;

    public FriendRecommendService(AccountInfo accountInfo, List<String> visitors,
        String targetUser) {
        this.accountInfo = accountInfo;
        this.targetUser = targetUser;
        initFriendsRelationScore();
        initVisitorScore(visitors);
    }

    public List<String> getRecommendedFriendsName() {
        List<Account> accounts = mapAccountInfoToList();

        sortedScoreDescAndNameAsc(accounts);
        return accounts.stream()
            .map(Account::getId)
            .limit(RECOMMEND_FRIEND_LIST_LIMIT)
            .collect(toList());
    }

    private void initFriendsRelationScore() {
        accountInfo
            .findAllAccountFriendStream(targetUser)
            .forEach(this::calculateFriendsRelationScore);
    }

    private void calculateFriendsRelationScore(Account account) {
        account
            .getFriendRelationStream()
            .filter(this::isAddFriendsRelationScoreTarget)
            .forEach(abc -> abc.addScore(FRIEND_RELATION_SCORE));
    }

    private void initVisitorScore(List<String> visitors) {
        visitors.forEach(this::calculateVisitorScore);
    }

    private void calculateVisitorScore(String visitorId) {
        Account visitor = accountInfo.findAccount(visitorId);

        if (!visitor.isFriend(targetUser)) {
            visitor.addScore(VISITOR_SCORE);
        }
    }

    private List<Account> mapAccountInfoToList() {
        return accountInfo.findAllAccount().stream()
            .filter(account -> !account.isAccountId(targetUser))
            .filter(Account::scoreOverThanZero)
            .collect(toList());
    }

    private void sortedScoreDescAndNameAsc(List<Account> accounts) {
        accounts.sort((accountA, accountB) -> {
            if (accountA.isEqualsScore(accountB)) {
                return accountA.getId().compareTo(accountB.getId());
            }
            return accountB.getScore() - accountA.getScore();
        });
    }

    private boolean isAddFriendsRelationScoreTarget(Account account) {
        return !(account.isAccountId(targetUser) || account.isFriend(targetUser));
    }
}
