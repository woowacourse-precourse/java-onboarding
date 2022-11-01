package onboarding;

import java.util.List;
import onboarding.problem6.NickNameSystem;
import onboarding.problem6.validation.Validation;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        try {
            Validation.validate(forms);
            NickNameSystem nickNameSystem = new NickNameSystem();
            answer = nickNameSystem.getEmailsToBeSent(forms);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return answer;
    }
}
