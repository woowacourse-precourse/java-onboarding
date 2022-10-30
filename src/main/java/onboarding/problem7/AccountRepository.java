package onboarding.problem7;

import static onboarding.problem7.consts.FriendConst.FRIEND_A_INDEX;
import static onboarding.problem7.consts.FriendConst.FRIEND_B_INDEX;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class AccountRepository {

    private final Map<String, Account> accounts;

    public AccountRepository(List<List<String>> friends) {
        this.accounts = new HashMap<>();
        initFriendsRelation(friends);
    }

    private void initFriendsRelation(List<List<String>> friends) {
        friends.forEach(friend -> {
            Account accountA = accounts.computeIfAbsent(friend.get(FRIEND_A_INDEX), Account::new);
            Account accountB = accounts.computeIfAbsent(friend.get(FRIEND_B_INDEX), Account::new);

            accountA.addFriend(accountB);
            accountB.addFriend(accountA);
        });
    }

    public Stream<Account> findAllAccountFriendStream(String user) {
        return this.findAccount(user).getFriendRelationStream();
    }

    public Collection<Account> findAllAccount() {
        return accounts.values();
    }

    public Account findAccount(String user) {
        return accounts.computeIfAbsent(user, Account::new);
    }
}
