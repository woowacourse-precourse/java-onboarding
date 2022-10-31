package onboarding;

import onboarding.P6.EmailVerification;
import onboarding.P6.NameOverlap;
import onboarding.P6.NickNameVerification;

import java.util.*;


public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        EmailVerification emailVerification = new EmailVerification();
        NickNameVerification nickNameVerification = new NickNameVerification();
        NameOverlap nameOverlap = new NameOverlap();
        if(EmailVerification.emailverification(forms)){
            throw new IllegalArgumentException("이메일을 확인해주세요");
        }
        if(nickNameVerification.nameverification(forms)){
            throw new IllegalArgumentException("닉네임형식을 확인해주세요");
        }
        return nameOverlap.OverlapResult(forms);


    }
}


