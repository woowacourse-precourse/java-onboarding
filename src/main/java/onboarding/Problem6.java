package onboarding;

import java.util.List;

import onboarding.problem6.SimilarNicknameCrewSelector;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        SimilarNicknameCrewSelector similarNicknameCrewSelector = new SimilarNicknameCrewSelector(forms);

        List<String> answer = similarNicknameCrewSelector.makeSimilarNicknameCrewEmailList();

        return answer;
    }
}
