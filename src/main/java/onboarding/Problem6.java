package onboarding;

import java.util.ArrayList;
import java.util.List;
import Exception.EmailFormException;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(List.of("answer"));
        try {
            emailCheck(forms.get(0).get(0));
        }catch (EmailFormException e)
        {
            answer.add("answer"); //test
            //문제에 예외를 어떻게 처리하라는 말이 없음
            //log.error OR log.warn
            //System.out.println(e.toString());
        }
        return answer;
    }

    /**
     * 이메일형식이 맞는가? 그중에서도 @email.com이 맞는가?
     *
     * @param email list에서 이메일만 입력
     * @throws EmailFormException @email.com이 아니면 발생
     */
    public static void emailCheck(String email) throws EmailFormException
    {
        if(!email.contains("@email.com"))throw new EmailFormException("@email.com이 아닙니다");
    }
}
