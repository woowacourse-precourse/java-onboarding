package onboarding.problem7;

import static onboarding.problem7.consts.FriendListConst.FRIEND_A_INDEX;
import static onboarding.problem7.consts.FriendListConst.FRIEND_B_INDEX;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {

    private final Map<String, Account> accountInfoMap;

    public AccountRepository(List<List<String>> friends) {
        this.accountInfoMap = new HashMap<>();
        initFriendsRelation(friends);
    }

    private void initFriendsRelation(List<List<String>> friends) {
        for (List<String> friend : friends) {
            Account accountA = new Account(friend.get(FRIEND_A_INDEX));
            Account accountB = new Account(friend.get(FRIEND_B_INDEX));

            accountA.addFriend(accountB);
            accountB.addFriend(accountA);
            accountInfoMap.put(friend.get(FRIEND_A_INDEX), accountA);
            accountInfoMap.put(friend.get(FRIEND_B_INDEX), accountB);
        }
    }

    public Collection<Account> getAllAccountInfo() {
        return accountInfoMap.values();
    }

    public Account getAccount(String user) {
        return accountInfoMap.computeIfAbsent(user, key -> new Account(key));
    }
}
