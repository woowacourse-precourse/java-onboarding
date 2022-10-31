package onboarding;

import java.util.ArrayList;
import java.util.List;
import Exception.EmailFormException;
import Exception.RangeException;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        try {
            emailCheck(forms.get(0).get(0));
            emailLengthCheck(forms.get(0).get(0));
        }catch (EmailFormException e)
        {
            answer= new ArrayList<>();
            answer.add("Email"); //test
            //문제에 예외를 어떻게 처리하라는 말이 없음
            //log.error OR log.warn
            //System.out.println(e.toString());
        }catch (RangeException e)
        {
            answer= new ArrayList<>();
            answer.add("Range"); //test
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

    /**
     * 이메일 길이가 11~20자미만인가?
     *
     * @param email list에서 이메일만 입력
     * @throws RangeException 11~20자미만이 아니면 발생
     */
    public static void emailLengthCheck(String email) throws RangeException
    {
        if(email.length()<11||email.length()>=20) throw new RangeException("Email 입력범위 11~20미만에 해당하지 않습니다");
    }
}
