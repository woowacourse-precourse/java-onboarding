package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Exception.EmailFormException;
import Exception.RangeException;
import Exception.KoreanException;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        try {
            crewSizeCheck(forms);
            for (int i=0;i<=1;i++)
            {
                emailCheck(forms.get(i).get(0));
                emailLengthCheck(forms.get(i).get(0));
                nickNameLengthCheck(forms.get(i).get(1));
                koreanCheck(forms.get(i).get(1));
            }
            answer = new ArrayList<>();
            List <String> nickName = nickNameList(forms);
            List <String> trim = stringTrim2(forms);
            List <Integer> deleteIdx = deleteIdx(trim,nickName);
            System.out.println("nick : "+nickName);
            System.out.println("trim : "+trim);
            System.out.println("deleteIdx : "+deleteIdx);
            answer.addAll(deleteForms(forms,deleteIdx));
        }catch (EmailFormException e)
        {
            //문제에 예외를 어떻게 처리하라는 말이 없음
            //log.error OR log.warn
            //System.out.println(e.toString());
        }catch (RangeException e)
        {
            //문제에 예외를 어떻게 처리하라는 말이 없음
            //log.error OR log.warn
            //System.out.println(e.toString());
        }catch (KoreanException e)
        {
            //문제에 예외를 어떻게 처리하라는 말이 없음
            //log.error OR log.warn
            //System.out.println(e.toString());
        }catch (IndexOutOfBoundsException e)
        {
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

    /**
     * 모든 비교의 경우를 두글자씩 자르는 것이 시간을 줄일 수 있을거라 생각
     *
     * @param forms form전체를 입력으로받음
     * @return 잘랐는 모든경우를 리스트에 넣음
     */
    public static List<String> stringTrim2 (List<List<String>> forms)
    {
        List <String> trim = new ArrayList<>();
        for (int i=0;i<=forms.size()-1;i++)
        {
            char nickNameToArray[] = forms.get(i).get(1).toCharArray();
            for (int j=0;j<nickNameToArray.length-1;j++) {
                String tmp = Character.toString(nickNameToArray[j]) + nickNameToArray[j + 1];
                trim.add(tmp);
            }
        }
        List <String> distinct =  trim.stream().distinct().collect(Collectors.toList());

        return distinct;
    }
    public static List<Integer> deleteIdx(List<String>dupCheck,List<String> nickName)
    {
        List<Integer> deleteIdx = new ArrayList<>();
        List<Integer> tmpIdx = new ArrayList<>();
        for (int j=0;j<dupCheck.size();j++) {
            int count = 0;
            for (int i = 0; i < nickName.size(); i++) {
                if(nickName.get(i).contains(dupCheck.get(j)))
                {
                    tmpIdx.add(i);
                    count++;
                }
            }
            if(count>1)
            {
                deleteIdx.addAll(tmpIdx);
            }
        }
        List <Integer> distinct =  deleteIdx.stream().distinct().collect(Collectors.toList());
        List <Integer> sortedDeleteIdx = distinct.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return sortedDeleteIdx;
    }
    public static List<String> nickNameList(List<List<String>> forms)
    {
        List <String> nickNameList = new ArrayList<>();
        for (int i=0;i<forms.size();i++)
        {
            nickNameList.add(forms.get(i).get(1));
        }
        return nickNameList;
    }
    public static List<String> deleteForms (List<List<String>>forms,List<Integer> deleteIdx)
    {
        List<List<String>> tmpForms = new ArrayList<>();
        tmpForms.addAll(forms);
        List <String> answer = new ArrayList<>();
        for (int i=0;i<deleteIdx.size();i++)
        {
            answer.add(tmpForms.get(deleteIdx.get(i).intValue()).get(0));
        }
        return answer.stream().sorted().collect(Collectors.toList());
    }
}
