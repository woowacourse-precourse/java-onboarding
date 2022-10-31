package onboarding;

import onboarding.problem6.FormValidation;

import java.util.List;

public class Problem6 {
    static final int MAX_CREW_MEMBER = 10000 ;
    static final int MIN_CREW_MEMBER = 1;
    public static List<String> solution(List<List<String>> forms) {
        if (!validateCrewMemberLength(forms.size())) {
            return null;
        }
        FormValidation formValidation = FormValidation.from(forms);
        List<String> answer = formValidation.findEmailHavingDuplicationNickName();
        return answer;
    }

    public static boolean validateCrewMemberLength(int numberOfCrewMember) {
        if (numberOfCrewMember < MIN_CREW_MEMBER || numberOfCrewMember > MAX_CREW_MEMBER) {
            return false;
        }
        return true;
    }
}
