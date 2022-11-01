package onboarding;

import onboarding.problem6.Users;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Users users = new Users(forms);
        return new ArrayList<String>(users.getEmailOfDuplicateName());
    }
}
