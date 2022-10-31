package onboarding.problem6;

import java.util.*;

public class UserRepository
{
    DuplicatedChecker duplicatedChecker;
    List<User> userList;

    public UserRepository(DuplicatedChecker duplicatedChecker)
    {
        this.userList = new ArrayList<>();
        this.duplicatedChecker = duplicatedChecker;
    }

    public void addAllUser(List<User> userList)
    {
        for(User user : userList)
        {
            addUser(user);
        }
    }


    public void addUser(User user)
    {
        userList.add(user);
        String userName = user.getName();
        List<String> tokenList = Tokenizer.getTokens(userName);

        for(String token : tokenList)
        {
            List<User> userListWhoHasToken = duplicatedChecker.getUserListWhoHasToken(token);
            userListWhoHasToken.add(user);

            duplicatedChecker.check(token);
        }
    }



}