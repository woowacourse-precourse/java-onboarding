package onboarding.problem7;

import static java.util.stream.Collectors.toList;
import static onboarding.problem7.consts.FriendConst.RECOMMEND_FRIEND_LIST_LIMIT;
import static onboarding.problem7.consts.FriendConst.FRIEND_RELATION_SCORE;
import static onboarding.problem7.consts.FriendConst.VISITOR_SCORE;

import java.util.List;

/**
 * 친구 추천 목록을 제공하는 클래스
 */
public class FriendRecommendService {

    /**
     * 회원의 정보를 관리하는 일급 컬렉션
     */
    private final AccountRepository accountRepository;

    /**
     * 친구 추천 목록을 추천받을 사용자
     */
    private final String targetUser;

    /**
     * 회원 정보와 친구 목록을 추천받을 사용자를 초기화하는 생성자
     *
     * @param accountRepository 회원의 정보를 관리하는 일급 컬렉션
     * @param visitors          사용자의 타임 라인에 방문한 다른 사용자
     * @param targetUser        친추 목록을 추천받을 사용자
     */
    public FriendRecommendService(AccountRepository accountRepository, List<String> visitors,
        String targetUser) {
        this.accountRepository = accountRepository;
        this.targetUser = targetUser;
        initFriendsRelationScore();
        initVisitorScore(visitors);
    }

    /**
     * 친구 추천 목록을 구하는 메소드
     *
     * @return 친구 추천 목록
     */
    public List<String> getRecommendedFriendsName() {
        List<Account> accounts = findRecommendedAccounts();

        sortedScoreDescAndNameAsc(accounts);
        return accounts.stream()
            .map(Account::getId)
            .limit(RECOMMEND_FRIEND_LIST_LIMIT)
            .collect(toList());
    }

    /**
     * 사용자의 친구의 모든 친구 목록을 조회하며 점수를 계산하는 메소드
     */
    private void initFriendsRelationScore() {
        accountRepository
            .findAllAccountFriendStream(targetUser)
            .forEach(this::calculateFriendsRelationScore);
    }

    /**
     * 사용자와 함께 아는 친구의 수에 의한 친구 추천 점수를 계산하는 메소드
     *
     * @param account 사용자의 친구
     */
    private void calculateFriendsRelationScore(Account account) {
        account
            .getFriendRelationStream()
            .filter(this::isAddFriendsRelationScoreTarget)
            .forEach(target -> target.addScore(FRIEND_RELATION_SCORE));
    }

    /**
     * 사용자의 타임 라인에 방문한 사용자 목록을 조회하며 점수를 계산하는 메소드
     *
     * @param visitors 타임 라인에 방문한 사용자 ID 목록
     */
    private void initVisitorScore(List<String> visitors) {
        visitors.forEach(this::calculateVisitorScore);
    }

    /**
     * 사용자의 타임 라인에 방문한 횟수에 의한 친구 추천 점수를 계산하는 메소드
     *
     * @param visitorId 타임 라인에 방문한 사용자 ID
     */
    private void calculateVisitorScore(String visitorId) {
        Account visitor = accountRepository.findAccount(visitorId);

        if (!visitor.isFriend(targetUser)) {
            visitor.addScore(VISITOR_SCORE);
        }
    }

    /**
     * 사용자의 친구로 추천할 수 있는 유의미한 사용자의 목록을 조회하는 메소드
     *
     * @return 추천받을 사용자가 아니면서 친구 추천 점수가 0을 초과하는 사용자의 목록
     */
    private List<Account> findRecommendedAccounts() {
        return accountRepository.findAllAccount().stream()
            .filter(account -> !account.isAccountId(targetUser))
            .filter(Account::scoreOverThanZero)
            .collect(toList());
    }

    /**
     * 사용자의 친구 추천 목록을 점수 내림차순, 이름 오름차순으로 정렬하는 메소드
     *
     * @param recommendedAccounts 정렬된 친구 추천 목록
     */
    private void sortedScoreDescAndNameAsc(List<Account> recommendedAccounts) {
        recommendedAccounts.sort((accountA, accountB) -> {
            if (accountA.isEqualsScore(accountB)) {
                return accountA.getId().compareTo(accountB.getId());
            }
            return accountB.getScore() - accountA.getScore();
        });
    }

    /**
     * 해당 사용자가 친구 추천의 대상이 되는지에 대한 여부를 확인하는 메소드
     *
     * @param account 친구 추천 점수를 계산할 사용자
     * @return 친구 추천의 대상이 되는지에 대한 여부
     */
    private boolean isAddFriendsRelationScoreTarget(Account account) {
        return !(account.isAccountId(targetUser) || account.isFriend(targetUser));
    }
}
