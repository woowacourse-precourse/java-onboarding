package onboarding;


import java.util.*;
import onboarding.problem6.DuplicateNickname;

public class Problem6 {

    static List<String> EmailSort(List<String> email) {
        List<String> result = email;

        Collections.sort(result);

        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        DuplicateNickname duplicateNickname = new DuplicateNickname(forms);
        System.out.println(duplicateNickname.DuplicatEmailIndex());

        return answer;
    }

    public static void main(String str[]) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );


        System.out.print(solution(forms));


    }
}
