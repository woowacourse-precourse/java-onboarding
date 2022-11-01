package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> fragmentMap = new HashMap<>();
        fragmentMap =  makeMap(forms);

        for (String fragment : fragmentMap.keySet()) {
            List<String> emailList = fragmentMap.get(fragment);

            if (emailList.size() >= 2) {
                for (int i = 0; i < emailList.size(); i++) {
                    if (!answer.contains(emailList.get(i))) {
                        answer.add(emailList.get(i));
                    }
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    public static HashMap<String, List<String>> makeMap(List<List<String>> forms) {

        HashMap<String, List<String>> fragmentMap = new HashMap<>();

        for (List<String> form : forms) {

            String currentName = form.get(1);
            String currentEmail = form.get(0);
            String domainName = currentEmail.substring(currentEmail.indexOf("@") + 1);

            if (!domainName.equals("email.com")) {
                continue;
            }

            for (int j = 1; j < currentName.length(); j++) {
                String fragment = String.valueOf(currentName.charAt(j - 1)) + currentName.charAt(j);
                if (fragmentMap.containsKey(fragment)) {
                    fragmentMap.get(fragment).add(currentEmail);
                } else {
                    List<String> emailList = new ArrayList<>();
                    emailList.add(currentEmail);
                    fragmentMap.put(fragment, emailList);
                }
            }
        }

        return fragmentMap;
    }

}
