package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static boolean error_chk(List<List<String>> forms)
    {
        String email = "";
        String[] email_split = new String[]{};

        for (List<String> apply : forms)
        {
            email = apply.get(0);
            email_split = email.split("@");
            if (email_split[1].equals("email.com"))
                return false;
        }
        return true;
    }
    public static boolean compare_string(String a, String b)
    {
        String[] split_a = a.split("");
        String[] split_b = b.split("");
        for (int i = 0; i < split_a.length - 1; i++)
        {
            for (int j = 0; j < split_b.length - 1; j++)
            {
                if (i != split_a.length - 1 && j != split_b.length -1
                    && split_a[i + 1].equals(split_b[j + 1]) && split_a[i].equals(split_b[j]))
                    return true;
            }
        }
        return false;
    }
    public static List<String> mail_sort(List<Integer>idx_list, List<List<String>> forms)
    {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < idx_list.size(); i++)
        {
            result.add(forms.get(idx_list.get(i)).get(0));
        }
        Collections.sort(result);
        return (result);
    }
    public static List<String> solution(List<List<String>> forms) {
        String now = "";
        List<String> answer = List.of("answer");
        List<Integer> answer_idx = new ArrayList<Integer>();
        ArrayList<Integer> visited = new ArrayList<Integer>();

        if (!error_chk(forms))
            return answer;
        for (int i = 0; i < forms.size(); i++)
            visited.add(0);
        for (int i = 0; i < forms.size(); i++)
        {
            now = forms.get(i).get(1);
            for (int j = i + 1; j < forms.size(); j++) {
                if (compare_string(now, forms.get(j).get(1))) {
                    if (visited.get(i) == 0)
                    {
                        visited.set(i, 1);
                        answer_idx.add(i);
                    }
                    if (visited.get(j) == 0)
                    {
                        visited.set(j, 1);
                        answer_idx.add(j);
                    }
                }
            }
        }
        answer = mail_sort(answer_idx, forms);
        return answer;
    }
}
