package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    static Set<String> userSet = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        for(List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);
            int name_len = name.length();

            if(!email.split("@")[1].equals("email.com")) {
                continue;
            }

            if(name.length() < 1 && name.length() > 20) {
                System.out.println("Error!");
            }

            for(int i = 0; i < name_len - 1; i++) {
                String subName = name.substring(i, i + 2);
                check(name, subName, forms);
            }
        }
        List<String> answer = userSet.stream().sorted().collect(Collectors.toList());
        return answer;
    }

    public static void check(String name, String nickname, List<List<String>> forms) {
        for(List<String> form : forms) {
            if(name.equals(form.get(1))) {
                continue;
            }

            if (form.get(1).contains(nickname)) {
                userSet.add(form.get(0));
            }
        }
    }
}
