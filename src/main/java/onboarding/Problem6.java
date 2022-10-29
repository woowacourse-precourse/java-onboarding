package onboarding;

import onboarding.problem6.Members;
import onboarding.problem6.WoowaCourse;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return  new WoowaCourse(new Members(forms)).findEmailsAtSimilarUserName();
    }
}
