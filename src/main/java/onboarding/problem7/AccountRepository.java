package onboarding.problem7;

import static onboarding.problem7.consts.FriendConst.FRIEND_A_INDEX;
import static onboarding.problem7.consts.FriendConst.FRIEND_B_INDEX;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 사용자의 정보를 곤리하는 일급 컬렉션
 */
public class AccountRepository {

    /**
     * (사용자 ID, Account) 방식으로 사용자의 정보를 관리하는 컬렉션
     */
    private final Map<String, Account> accounts;

    /**
     * 사용자 정보를 초기화하는 생성자
     *
     * @param friends 사용자의 친구 관계
     * @see #initFriendsRelation(List friends)
     */
    public AccountRepository(List<List<String>> friends) {
        this.accounts = new HashMap<>();
        initFriendsRelation(friends);
    }

    /**
     * 사용자의 친구 관계를 초기화하는 메소드
     *
     * @param friends 사용자의 친구 관계
     */
    private void initFriendsRelation(List<List<String>> friends) {
        friends.forEach(friend -> {
            Account accountA = accounts.computeIfAbsent(friend.get(FRIEND_A_INDEX), Account::new);
            Account accountB = accounts.computeIfAbsent(friend.get(FRIEND_B_INDEX), Account::new);

            accountA.addFriend(accountB);
            accountB.addFriend(accountA);
        });
    }

    /**
     * 사용자의 모든 친구 관계를 Stream 타입으로 반환하는 메소드
     *
     * @param user 사용자 ID
     * @return 사용자의 모든 친구 관계
     */
    public Stream<Account> findAllAccountFriendStream(String user) {
        return this.findAccount(user).getFriendRelationStream();
    }

    /**
     * 모든 사용자의 정보를 Collection 타입으로 반환하는 메소드
     *
     * @return 모든 사용자의 정보
     */
    public Collection<Account> findAllAccount() {
        return accounts.values();
    }

    /**
     * 사용자의 정보를 반환하는 메소드
     *
     * @param user 사용자 ID
     * @return 사용자 정보
     */
    public Account findAccount(String user) {
        return accounts.computeIfAbsent(user, Account::new);
    }
}
