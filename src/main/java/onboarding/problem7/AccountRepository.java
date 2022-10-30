package onboarding.problem7;

import static onboarding.problem7.consts.FriendListConst.FRIEND_A_INDEX;
import static onboarding.problem7.consts.FriendListConst.FRIEND_B_INDEX;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class AccountRepository {

    private final Map<String, Account> accountInfoMap;

    public AccountRepository(List<List<String>> friends) {
        this.accountInfoMap = new HashMap<>();
        initFriendsRelation(friends);
    }

    private void initFriendsRelation(List<List<String>> friends) {
        for (List<String> friend : friends) {
            Account accountA = accountInfoMap.computeIfAbsent(friend.get(FRIEND_A_INDEX),
                Account::new);
            Account accountB = accountInfoMap.computeIfAbsent(friend.get(FRIEND_B_INDEX),
                Account::new);

            accountA.addFriend(accountB);
            accountB.addFriend(accountA);
        }
    }

    public Stream<Account> getAccountFriendStream(String user) {
        return this.getAccount(user).getFriendRelationStream();
    }

    public Collection<Account> getAllAccountInfo() {
        return accountInfoMap.values();
    }

    public Account getAccount(String user) {
        return accountInfoMap.computeIfAbsent(user, Account::new);
    }
}
