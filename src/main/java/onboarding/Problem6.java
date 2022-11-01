package onboarding;

import java.util.*;

public class Problem6 {
    private static List<String> answer;

    //1) 같은 글자가 연속적으로 포함 되어있는지 체크
    public static boolean SimilarCheck(String nickName1,String nickName2) {
        for (int i = 0; i < nickName1.length() - 1; i++) {
            if (nickName2.contains(nickName1.substring(i, i + 2)))
                return true;
        }
        return false;
    }
    
    //2) 연속적으로 포함되어 있다면, 이메일 값 추가
    public static void   nickNameCheck(List<String> form1,List<String> form2) {
        String nickName1 = form1.get(1);
        String email1 = form1.get(0);
        String nickName2 = form2.get(1);
        String email2 = form2.get(0);

        //두 닉네임이 비슷한지 체크
        if(SimilarCheck(nickName1, nickName2))
        {
            //중복 저장하면 안되므로 중복 유무 검사
            if (!answer.contains(email1))
                answer.add(email1);
            if (!answer.contains(email2))
                answer.add(email2);
        }
    }
    
    public static List<String> solution(List<List<String>> forms) {
        answer = new ArrayList<>();

        //3) form 길이만큼 반복하여 체크
        for (int i = 0 ; i < forms.size(); i++)
        {
            for (int j = i + 1 ; j< forms.size(); j++)
            {
                nickNameCheck(forms.get(i), forms.get(j));
            }
        }
        
        //4) 오름차순 정렬
        Collections.sort(answer);
        return answer;
    }
    
}