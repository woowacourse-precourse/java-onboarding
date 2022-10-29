package onboarding;

import problem6.SimilarNicknameChecker;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        try {
            SimilarNicknameChecker verifier = new SimilarNicknameChecker(forms);
            return verifier.getEmails();
        } catch (RuntimeException e) {
            return null;
        }
    }
}
