package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Problem6 {
    private static LinkedHashMap<String, Boolean> map;
    private static List<String> answer;
    public static boolean nickNameSimilarCheck(String nickName1,String nickName2)
    {
        for (int i = 0 ; i<nickName1.length()-1; i++)
        {
            if (nickName2.contains(nickName1.substring(i,i+2)))
                return true;
        }
        return false;
    }
    public static boolean visitedCheck(String email)
    {
        return map.get(email);
    }
    public static void visitedAdd (String email){
        answer.add(email);
        map.put(email,true);
    }
    public static void   nickNameCheck(List<String> form1,List<String> form2)
    {
        String nickName1 = form1.get(1);
        String email1 = form1.get(0);
        String nickName2 = form2.get(1);
        String email2 = form2.get(0);

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
        map = new LinkedHashMap<>();
        for (int i = 0 ; i < forms.size() ; i++){
            map.put(forms.get(i).get(0), false);
        }
        for (int i = 0 ; i < forms.size(); i++)
        {
            for (int j = i + 1 ; j< forms.size(); j++)
            {
                nickNameCheck(forms.get(i), forms.get(j));
            }
        }
        Collections.sort(answer);
        return answer;
    }
    /*
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
            List.of("jm@email.com", "제이엠"),
            List.of("jason@email.com", "제이슨"),
            List.of("woniee@email.com", "워니"),
            List.of("mj@email.com", "엠제이"),
            List.of("nowm@email.com", "이제엠")
        );
        System.out.println(solution(forms));
    }*/
}
