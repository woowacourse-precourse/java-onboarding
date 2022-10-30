package onboarding;

import java.util.List;
import onboarding.problem6.NickNameSystem;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        NickNameSystem nickNameSystem = new NickNameSystem();
        answer = nickNameSystem.getEmailsToBeSent(forms);
        return answer;
    }
}
