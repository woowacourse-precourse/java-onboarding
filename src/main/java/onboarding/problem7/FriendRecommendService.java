package onboarding.problem7;

import static java.util.stream.Collectors.toList;
import static onboarding.problem7.consts.FriendListConst.RECOMMEND_FRIEND_LIST_LIMIT;
import static onboarding.problem7.consts.FriendScoreConst.FRIEND_RELATION_SCORE;
import static onboarding.problem7.consts.FriendScoreConst.VISITOR_SCORE;

import java.util.List;

public class FriendRecommendService {

    private final AccountRepository accountRepository;
    private final String targetUser;

    public FriendRecommendService(AccountRepository accountRepository, List<String> visitors,
        String targetUser) {
        this.accountRepository = accountRepository;
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
        for (Account account : accountRepository.getAllAccountInfo()) {
            calculateFriendsRelationScore(account);
        }
    }

    private void calculateFriendsRelationScore(Account account) {
        if (isAddFriendsRelationScoreTarget(account)) {
            account.addScore(account.getNumberOfFriends() * FRIEND_RELATION_SCORE);
        }
    }

    private void initVisitorScore(List<String> visitors) {
        for (String visitor : visitors) {
            calculateVisitorScore(visitor);
        }
    }

    private void calculateVisitorScore(String visitorId) {
        Account visitor = accountRepository.getAccount(visitorId);

        if (!visitor.isFriend(targetUser)) {
            visitor.addScore(VISITOR_SCORE);
        }
    }

    private List<Account> mapAccountInfoToList() {
        return accountRepository.getAllAccountInfo().stream()
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
