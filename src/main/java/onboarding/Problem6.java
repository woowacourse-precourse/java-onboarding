package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
            List.of("jm@email.com", "제이엠"),
            List.of("jason@email.com", "제이슨"),
            List.of("woniee@email.com", "워니"),
            List.of("mj@email.com", "엠제이"),
            List.of("nowm@email.com", "이제엠")
            );
        System.out.println(solution(forms));
    }
    public static List<String> solution(List<List<String>> forms) {
           List<String> answer ;
            Map<String, String> nameToEmail = new HashMap<>();
            Set<String> email = new HashSet<>();

            for (List<String> emailAndName : forms) {
                String name = emailAndName.get(1);
                for (int i=0; i<name.length()-1; i++) {
                    String twoSizeName = name.substring(i, i+2);
                        //이미 키로 존재하는 경우
                    if (nameToEmail.containsKey(twoSizeName)) {
                        //get : 밸류값을 가져와라
                     email.add(nameToEmail.get(twoSizeName));
                        email.add(emailAndName.get(0));
                     }
                    //score.put(이름, 점수)
                    nameToEmail.put(twoSizeName, emailAndName.get(0));
                }
            }

            answer = email.stream()
                .sorted().collect(Collectors.toList());

            return answer;
    }
}
