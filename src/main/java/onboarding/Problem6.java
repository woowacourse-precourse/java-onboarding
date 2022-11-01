package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Problem6 {
    private static LinkedHashMap<String, Boolean> visited;
    private static List<String> answer;

    // 닉네임 비슷한지
    public static boolean nickNameSimilarCheck(String nickName1,String nickName2)
    {
        for (int i = 0 ; i<nickName1.length()-1; i++)
        {
            if (nickName2.contains(nickName1.substring(i,i+2)))
                return true;
        }
        return false;
    }

    // 연속 리스트에 들어가 있는지 체크
    public static boolean visitedCheck(String email)
    {
        return visited.get(email);
    }

    // 연속리스트에 ADD.
    public static void visitedAdd (String email){
        answer.add(email);
        visited.put(email,true);
    }


    public static void   nickNameCheck(List<String> form1,List<String> form2)
    {
        String nickName1 = form1.get(1);
        String email1 = form1.get(0);
        String nickName2 = form2.get(1);
        String email2 = form2.get(0);

        // 두 닉네임이 비슷한지 체크
        if(nickNameSimilarCheck(nickName1, nickName2))
        {
            if (!visitedCheck(email1))
                visitedAdd(email1);
            if (!visitedCheck(email2))
                visitedAdd(email2);
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        answer = new ArrayList<>();
        visited = new LinkedHashMap<>();

        // 연속리스트에 있는지 (방문 여부) 체크
        for (int i = 0 ; i < forms.size() ; i++){
            visited.put(forms.get(i).get(0), false);
        }
        // 닉네임 체크
        for (int i = 0 ; i < forms.size(); i++)
        {
            for (int j = i + 1 ; j< forms.size(); j++)
                nickNameCheck(forms.get(i), forms.get(j));
        }
        // 연속리스트 오름차순 정렬
        Collections.sort(answer);
        return answer;
    }
}
