package onboarding.Problem6;

import java.util.*;

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
        DuplicatedChecker duplicatedChecker = new DuplicatedChecker();
        UserRepository userRepository = new UserRepository(duplicatedChecker);

        List<User> userList = getUserListFromForms(forms);
        userRepository.addAllUser(userList);

        Set<User> duplicatedUser = duplicatedChecker.getDuplicatedUser();

        List<String> answer = new ArrayList<>();
        duplicatedUser.forEach(user ->
        {
            answer.add(user.getEmail());
        });

        return answer;
    }
}
