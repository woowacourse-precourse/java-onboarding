package onboarding.Problem6;

import java.util.*;

public class UserRepository
{
    private static final int DUPLICATED=1;
    Map<String, List<User>> tokenToUserListMap;
    Set<String> duplicatedTokens;
    List<User> userList;
    public UserRepository()
    {
        this.userList = new ArrayList<>();
        this.tokenToUserListMap = new HashMap<>();
        this.duplicatedTokens = new HashSet<>();
    }

    public void addAllUser(List<User> userList)
    {
        for(User user : userList)
        {
            addUser(user);
        }
    }

    private void checkDuplicated(String token)
    {
        List<User> userListWhoHasToken = tokenToUserListMap.get(token);
        if(userListWhoHasToken.size() > DUPLICATED)
        {
            duplicatedTokens.add(token);
        }

    }

    public void addUser(User user)
    {
        userList.add(user);
        String userName = user.getName();
        List<String> tokenList = Tokenizer.getTokens(userName);

        for(String token : tokenList)
        {
            List<User> userListWhoHasToken = tokenToUserListMap.getOrDefault(token,new ArrayList<>());
            userListWhoHasToken.add(user);
            tokenToUserListMap.put(token,userListWhoHasToken);
            checkDuplicated(token);
        }
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