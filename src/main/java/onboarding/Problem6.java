package onboarding;

import java.util.ArrayList;
import java.util.List;
import Exception.EmailFormException;
import Exception.RangeException;
import Exception.KoreanException;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        try {
            emailCheck(forms.get(0).get(0));
            emailLengthCheck(forms.get(0).get(0));
            nickNameLengthCheck(forms.get(0).get(1));
            koreanCheck(forms.get(0).get(1));
            crewSizeCheck(forms);
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
        }catch (KoreanException e)
        {
            answer= new ArrayList<>();
            answer.add("Korean"); //test
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

    /**
     * 닉네임 길이가 1~20자미만인가?
     *
     * @param nickName list에서 닉네임만 입력
     * @throws RangeException 1~20자미만이 아니면 발생
     */
    public static void nickNameLengthCheck(String nickName) throws RangeException
    {
        if(nickName.length()<1||nickName.length()>=20) throw new RangeException("NickName 입력범위 1~20자미만에 해당하지 않습니다");
    }

    /**
     * 크루원의 사이즈가 1~10000인가?
     *
     * @param forms list를 입력한다
     * @throws RangeException 1~10000가 아니면 발생
     */
    public static void crewSizeCheck(List<List<String>> forms) throws RangeException
    {
        if(forms.size()<1||forms.size()>10000) throw new RangeException("Crew원의 인원이 1~10000에 해당하지않습니다");
    }

    /**
     * 한글이 아닌 입력이 있는가?
     *
     * @param nickName list에서 닉네임만 입력한다
     * @throws KoreanException 한글이 아닌경우 발생
     */
    public static void koreanCheck(String nickName)throws KoreanException
    {
        if(!nickName.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) throw new KoreanException("한글이 아닌 입력이 있습니다");
    }
}
