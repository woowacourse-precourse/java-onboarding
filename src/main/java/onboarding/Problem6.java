package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        for(int i=0;i<forms.size();i++)
        {
            for(int j=1;j<forms.size();j++)
            {
                if(j!=i)
                    if(Check_Name(forms.get(i).get(1),forms.get(j).get(1)))//
                    {
                        answer.add(forms.get(i).get(0));
                    }

            }
        }

        Collections.sort(answer);//오름차순 정렬
        Set<String> set = new HashSet<>(answer);//중복 제거
        answer = new ArrayList<>(set);
        System.out.println(answer);

        return answer;
    }
    public static boolean Check_Name(String name_one, String name_two)
    {
        boolean result=false;
        loop1:
        for(int i = 1; i < name_one.length(); i++)
        {

            for(int j=1;j<name_two.length();j++)
            {
                if(name_one.substring(i-1,i+1).equals(name_two.substring(j-1,j+1)))
                {
                    result = true;
                    break loop1;
                }
            }
        }
        return result;
    }
}
