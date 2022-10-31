package onboarding;

import problem6.SimilarNicknamesChecker;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        try {
            SimilarNicknamesChecker checker = new SimilarNicknamesChecker(forms);
            return checker.getEmailsOf();
        } catch (RuntimeException e) {
            return null;
        }
    }
}
