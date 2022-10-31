package onboarding.problem6;

import java.util.*;

public class DuplicatedChecker {
    private static final int DUPLICATED=1;
    Map<String, List<User>> tokenToUserListMap;
    Set<String> duplicatedTokens;

    public DuplicatedChecker()
    {
        this.tokenToUserListMap = new HashMap<>();
        this.duplicatedTokens = new HashSet<>();
    }

    public void check(String token)
    {
        List<User> userListWhoHasToken = tokenToUserListMap.get(token);
        if(userListWhoHasToken.size() > DUPLICATED)
        {
            duplicatedTokens.add(token);
        }
    }

    public List<User> getUserListWhoHasToken(String token)
    {
        List<User> userListWhoHasToken;
        if(tokenToUserListMap.containsKey(token))
        {
            userListWhoHasToken = tokenToUserListMap.get(token);
        }
        else
        {
            userListWhoHasToken = new ArrayList<>();
            tokenToUserListMap.put(token,userListWhoHasToken);
        }

        return userListWhoHasToken;
    }

    public Set<User> getDuplicatedUser()
    {

        Set<User> duplicatedUser = new TreeSet<>();
        duplicatedTokens.forEach(token->
        {
            List<User> userListWhoHasToken = tokenToUserListMap.get(token);
            duplicatedUser.addAll(userListWhoHasToken);
        });

        return duplicatedUser;
    }
}
