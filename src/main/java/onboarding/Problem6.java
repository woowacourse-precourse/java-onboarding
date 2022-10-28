package onboarding;

import onboarding.problem6.NicknameChecker;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        NicknameChecker nicknameChecker = new NicknameChecker();
        nicknameChecker.addCrews(forms);
        List<String> answer = nicknameChecker.checkSimilarNickname()
                .getSimilarNicknameCrewEmail();
        return answer;
    }
}
