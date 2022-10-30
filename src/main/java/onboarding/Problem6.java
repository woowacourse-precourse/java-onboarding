package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        //make answer
        List<String> temp_answer = new ArrayList<>();
        make_repeated_id_ar(forms, temp_answer);

        //formatting answer
        Set<String> set = new HashSet<>(temp_answer);
        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);

        return answer;
    }

    static void make_repeated_id_ar(List<List<String>> forms, List<String> temp_answer)
    {
        for(int i = 0; i < forms.size(); i ++)
        {
            check_repeated_nickname(forms, i, temp_answer);
        }
    }
    static void check_repeated_nickname(List<List<String>> forms, int index, List<String> temp_answer)
    {
        for(int i = index + 1; i < forms.size(); i ++)
        {
            if(check_duplicated_charset(forms.get(index).get(1), forms.get(i).get(1)))
            {
                temp_answer.add(forms.get(index).get(0));
                temp_answer.add(forms.get(i).get(0));
            }
        }
    }
    static boolean check_duplicated_charset(String s1, String s2)
    {
        for(int i = 0; i < s1.length()-1; i ++)
        {
            for(int j = 0; j < s2.length()-1; j ++)
            {
                if(s1.substring(i, i+2).equals(s2.substring(j, j+2)))
                    return true;
            }
        }
        return false;
    }
}
