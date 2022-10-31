package onboarding;

import onboarding.problem6.DuplicatedChecker;
import onboarding.problem6.User;
import onboarding.problem6.UserRepository;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    private static final int USER_EMAIL_INDEX = 0;
    private static final int USER_NAME_INDEX = 1;
    private static final String EMAIL_FORMAT = "@email.com";
    private static final String KOREAN_PATTER = "^[ㄱ-힣]*$";

    private static User getUserFromUserInfoList(List<String> userInfoList)
    {
        String email = userInfoList.get(USER_EMAIL_INDEX);
        String name = userInfoList.get(USER_NAME_INDEX);
        return new User(email,name);
    }

    private static boolean emailValidation(String email)
    {
        if(!email.contains(EMAIL_FORMAT))
        {
            return false;
        }

        return true;
    }

    private static boolean userNameValidation(String userName)
    {
        return Pattern.matches(KOREAN_PATTER,userName);
    }

    public static boolean userValidation(User user)
    {
        if(!emailValidation(user.getEmail()))
        {
            throw new IllegalArgumentException("이메일 형식이 잘못되었습니다.");
        }

        if(!userNameValidation(user.getName()))
        {
            throw new IllegalArgumentException("이름 형식이 잘못되었습니다.");
        }

        return true;
    }


    private static List<User> getUserListFromForms(List<List<String>> forms)
    {
        List<User> userList = new ArrayList<>();
        forms.forEach(userInfo ->{
            User user = getUserFromUserInfoList(userInfo);
            userValidation(user);
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
