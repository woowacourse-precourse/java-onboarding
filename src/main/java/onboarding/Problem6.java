package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {

    public static HashMap<String, ArrayList<String>> createEmailMap(List<List<String>> forms) {
        HashMap<String, ArrayList<String>> emailMap = new HashMap<String, ArrayList<String>>();
        for(List<String> crewInfo : forms) {
            String nickname = crewInfo.get(1);
            for(int i = 0; i < nickname.length() - 1; i++) {
                String key = Character.toString(nickname.charAt(i)) + Character.toString(nickname.charAt(i + 1));
                ArrayList<String> values;
                if(emailMap.containsKey(key)) {
                    values = emailMap.get(key);
                } else {
                    values = new ArrayList<String>();
                }
                values.add(crewInfo.get(0));
                emailMap.put(key, values);
            }
        }
        return emailMap;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, ArrayList<String>> emailMap = createEmailMap(forms);
        System.out.println(emailMap);
        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        solution(forms);
    }
}
