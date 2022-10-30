package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Database.validateData(forms);
        Database.setData(forms);
        List<String> answer = getEmailListByCheckNickname();
        return answer;
    }
}
