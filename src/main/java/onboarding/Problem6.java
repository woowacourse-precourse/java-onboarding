package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashSet<String> emails = new HashSet<>();
        Map<String, String> hash = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            if(name.length() < 2){
                break;
            }
            //System.out.println("name: " + name);
            for (int j = 0; i < name.length() - 1; j++) {
                String target = name.substring(j, j + 2);// 연속 두글자
                //System.out.println("target: " + target);
                if (hash.containsKey(target)) {
                    String email = hash.get(target);
                    if (!email.equals(forms.get(i).get(0))) {
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                hash.put(target, forms.get(i).get(0));
            }

        }

        answer = emails.stream().sorted().collect(Collectors.toList());
        return answer;
    }

    /*
        public static void main(String[] args) { // TEST
           // List<List<String>> forms = new ArrayList<>();

            List<List<String>> forms = List.of(List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("wonie@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠"));


            System.out.println(solution(forms));


        }

     */

}
