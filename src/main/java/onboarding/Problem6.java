package onboarding;

import java.util.ArrayList;
import java.util.List;

import static onboarding.problem6.ExtractList.extractEmail;
import static onboarding.problem6.ExtractList.extractNickname;
import static onboarding.problem6.FindEmailList.findEmailList;
import static onboarding.problem6.Validation.*;

public class Problem6 {

    private static final String INPUT_FORM_ERROR = "입력 형식이 잘못되었습니다.";

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> emailList;
        List<String> nicknameList;

        if(isCrewOutOfRange(forms)) {
            answer.add(INPUT_FORM_ERROR);

            return answer;
        }

        emailList = extractEmail(forms);
        nicknameList = extractNickname(forms);

        if(isEmailOutOfRange(emailList) || isNicknameOutOfRange(nicknameList)
            || isInvalidEmailForm(emailList) || isInvalidNicknameForm(nicknameList)) {
            answer.add(INPUT_FORM_ERROR);

            return answer;
        }

        answer = findEmailList(nicknameList, emailList);

        return answer;
    }
}
