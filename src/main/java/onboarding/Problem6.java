package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Users users = new Users(forms.stream()
                .map(user -> new User(user))
                .collect(Collectors.toList()));
        UserMatchingList userMatchingList = users.getUserMatchingList();
        return userMatchingList.mapToUserEmail();
    }
}
