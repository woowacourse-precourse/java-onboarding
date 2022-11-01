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
        List<List<String>> newForms = new ArrayList<>();
        newForms.addAll(forms);
        try {
            crewSizeCheck(newForms);
            for (int i=0;i<newForms.size();i++)
            {
                System.out.println(i);
                if(emailLengthCheck(newForms.get(i).get(0))) {
                    newForms.remove(i);
                    i=0;
                }
                if(nickNameLengthCheck(newForms.get(i).get(1))) {
                    newForms.remove(i);
                    i=0;
                }
                if(koreanCheck(newForms.get(i).get(1)))
                {
                    newForms.remove(i);
                    i=0;
                };
                if(!emailCheck(newForms.get(i).get(0))){
                    newForms.remove(i);
                    i=0;
                }
            }
            answer = new ArrayList<>();
            List <String> nickName = nickNameList(newForms);
            List <String> trim = stringTrim2(newForms);
            List <Integer> deleteIdx = deleteIdx(trim,nickName);
            answer.addAll(deleteForms(newForms,deleteIdx));
        }catch (RangeException e)
        {
            System.out.println("range");
            //문제에 예외를 어떻게 처리하라는 말이 없음
            //log.error OR log.warn
            //System.out.println(e.toString());
        }catch (IndexOutOfBoundsException e)
        {
            System.out.println("index");

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
    public static boolean emailCheck(String email)
    {
        if(email.contains("@email.com")) return true;
        else return false;
    }

    /**
     * 이메일 길이가 11~20자미만인가?
     *
     * @param email list에서 이메일만 입력
     * @throws RangeException 11~20자미만이 아니면 발생
     */
    public static boolean emailLengthCheck(String email)
    {
        if(email.length()<11||email.length()>=20) return true;
        else return false;
    }

    /**
     * 닉네임 길이가 1~20자미만인가?
     *
     * @param nickName list에서 닉네임만 입력
     * @throws RangeException 1~20자미만이 아니면 발생
     */
    public static boolean nickNameLengthCheck(String nickName)
    {
        if(nickName.length()<1||nickName.length()>=20) return true;
        else return false;
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
    public static boolean koreanCheck(String nickName)
    {
        if(!nickName.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) return true;
        else return false;
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
