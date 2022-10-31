package onboarding;

import problem6.User;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        User user = new User(forms);
        List<String> answer = user.findDuplicateUser();
        return answer;
    }
}
