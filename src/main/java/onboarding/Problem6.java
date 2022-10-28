package onboarding;

import problem6.SimilarNicknameVerifier;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        try {
            SimilarNicknameVerifier verifier = new SimilarNicknameVerifier(forms);
            return verifier.getEmails();
        } catch (RuntimeException e) {
            return null;
        }
    }
}
