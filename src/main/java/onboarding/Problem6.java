package onboarding;

import onboarding.problem6.NicknameVerification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        NicknameVerification nicknameVerification = new NicknameVerification();
        List<String> answer = nicknameVerification.verificationCheck(forms);

        return answer;
    }
}
