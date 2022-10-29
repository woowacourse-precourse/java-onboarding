package onboarding;

import java.util.*;

class User implements Comparable<User>
{
    private String email;
    private String name;

    public User(String email,String name)
    {
        this.email = email;
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(User o) {
        return email.compareTo(o.email);
    }
}

class Tokenizer
{
    private static final int SEQUENCE = 2;
    public static List<String> getTokens(String input)
    {
        List<String> resultList = new ArrayList<>();

        for(int i = 0 ; i <= input.length() - SEQUENCE;i++)
        {
            resultList.add(input.substring(i,i+SEQUENCE));
        }

        return resultList;
    }
}

class UserRepository
{
    private static final int DUPLICATED=1;
    Map<String,List<User>> tokenToUserListMap;
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
public class Problem6 {
    private static final int USER_EMAIL_INDEX = 0;
    private static final int USER_NAME_INDEX = 1;

    private static User getUserFromUserInfoList(List<String> userInfoList)
    {
        String email = userInfoList.get(USER_EMAIL_INDEX);
        String name = userInfoList.get(USER_NAME_INDEX);
        return new User(email,name);
    }

    private static List<User> getUserListFromForms(List<List<String>> forms)
    {
        List<User> userList = new ArrayList<>();
        forms.forEach(userInfo ->{
            User user = getUserFromUserInfoList(userInfo);
            userList.add(user);
        });
        return userList;
    }

    public static List<String> solution(List<List<String>> forms)
    {
        UserRepository userRepository = new UserRepository();
        List<User> userList = getUserListFromForms(forms);
        userRepository.addAllUser(userList);
        Set<User> duplicatedUser = userRepository.getDuplicatedUser();
        List<String> answer = new ArrayList<>();
        duplicatedUser.forEach(user ->
        {
            answer.add(user.getEmail());
        });

        return answer;
    }
}
