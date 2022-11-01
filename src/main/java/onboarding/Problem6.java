package onboarding;

import onboarding.newExceptions.InvalidRestrictionException;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Problem6 restrictions = new Problem6();
        if(restrictions.isTeamSizeNotValid(forms)){
            throw new InvalidRestrictionException("크루원들의 수가 1명 이상 10,000명 이하에 속하지 않습니다.");
        }

        Set<String> emailSet = new HashSet<>();

        for(int i = 0; i < forms.size(); i++){
            for(int j = i; j < forms.size(); j++){
                if((i != j) && isSimilar(forms.get(i).get(1),forms.get(j).get(1))){
                    addOnEmailSet(emailSet,forms.get(i),forms.get(j));
                }
            }
        }

        List<String> answer = new ArrayList<>(emailSet);
        Collections.sort(answer);

        return answer;
    }
    static boolean isSimilar(String A, String B){
        for(int i = 1; i < B.length(); i++){
            if(A.contains(B.substring(i-1,i+1))){
                return true;
            }
        }
        return false;
    }
    static void addOnEmailSet(Set<String> emailSet,List<String> formA, List<String> formB){
        if(isViolatedRestrictions(formA.get(0),formA.get(1)) || isViolatedRestrictions(formB.get(0),formB.get(1))){
            throw new InvalidRestrictionException("제한사항에 맞지 않는 인원이 존재합니다.");
        }

        emailSet.add(formA.get(0));
        emailSet.add(formB.get(0));
    }
    static boolean isViolatedRestrictions(String email, String nickname){
        boolean isEmailLengthValid = (11 <= email.length() && email.length() < 20);
        boolean isEmailFormatValid = email.endsWith("@email.com");
        boolean isNickNameHaveOnlyKorean = nickname.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*");
        boolean isNickNameSizeValid = (1 <= nickname.length() && nickname.length() <= 20);

        return !(isEmailLengthValid && isEmailFormatValid && isNickNameSizeValid && isNickNameHaveOnlyKorean);
    }
    boolean isTeamSizeNotValid(List<List<String>> forms){
        return !(1 <= forms.size() && forms.size() <= 10_000);
    }
}
