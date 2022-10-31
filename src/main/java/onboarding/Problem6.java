package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> delDuplicate(List<String> emails){
        ArrayList<String> newList = new ArrayList<String>();

        if(emails.size() >= 2) {
            for (String email : emails) {
                if (!newList.contains(email)){
                    newList.add(email);
                }
            }
        }

        return newList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "나이엠"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "임제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(solution(forms));
    }
}
