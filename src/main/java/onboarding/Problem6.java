package onboarding;

import onboarding.p6.DuplicateHandler;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        DuplicateHandler handler = new DuplicateHandler(forms);
        return handler.getDuplicateNicknameToEmail();
    }
}
