package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Integer> duplicated;
        List<String> name = new ArrayList<>();
        List<String> email = new ArrayList<>();

        for (List<String> form : forms) {
            name.add(form.get(1));
            email.add(form.get(0));
        }

        duplicated = duplicated_index(name);

        for (Integer integer : duplicated) {
            answer.add(email.get(integer));
        }

        answer.sort(String.CASE_INSENSITIVE_ORDER);
        check_email_form(answer);

        return answer;
    }

    private static List<Integer> duplicated_index(List<String> name) {
        List<Integer> result = new ArrayList<>();
        List<String> decomposed;
        String check;

        for(int i=0; i<name.size()-1; i++){
            check = name.get(i);
            decomposed = decompose(check);
            check_duplicated(result, decomposed, name, i);
        }

        HashSet<Integer> tmp = new HashSet<>(result);
        result = new ArrayList<>(tmp);

        return result;
    }

    private static List<String> decompose(String check) {
        List<String> result = new ArrayList<>();

        for(int i=0; i<check.length()-1; i++){
            result.add(check.substring(i,i+2));
        }

        return result;
    }

    private static void check_duplicated(List<Integer> result, List<String> decomposed, List<String> name, Integer num) {
        for(int i=num+1; i<name.size(); i++){
            for (String s : decomposed) {
                if (name.get(i).contains(s)) {
                    result.add(i);
                    result.add(num);
                }
            }
        }
    }

    private static void check_email_form(List<String> answer) {
        for(int i=0; i<answer.size(); i++){
            if(!answer.get(i).contains("@email.com")){
                answer.remove(String.valueOf(answer.get(i)));
            }
        }
    }
}
