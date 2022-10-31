package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> crews = new HashMap<>();
        for(List<String> person : forms) {
            String email = person.get(0);
            String nickName = person.get(1);
            if(email.contains("email.com") && (email.length() >= 1 && email.length() <20))
                   crews.put(nickName, email);
        }

        ArrayList<String> nickNames = new ArrayList<>(crews.keySet());
        ArrayList<String> emails = new ArrayList<>();

        for(int i=0; i<nickNames.size(); i++) {
            String item1 = nickNames.get(i);
            for(int j=i+1; j<nickNames.size(); j++) {
                String item2 = nickNames.get(j);
                if(CompareString(item1, item2)) {
                    emails.add(crews.get(item1));
                    emails.add(crews.get(item2));
                }
            }
        }

        List<String> answer = new ArrayList<>();
        for(String email : emails) {
            if(!answer.contains(email))
                answer.add(email);
        }

        Collections.sort(answer);
        return answer;
    }

    public static boolean CompareString(String s1, String s2) {
        ArrayList<String> item1 = new ArrayList<>();
        ArrayList<String> item2 = new ArrayList<>();
        boolean flag = false;

        for(int i=0; i<s1.length(); i++)
            item1.add(s1.substring(i, i+1));
        for(int i=0; i<s2.length(); i++)
            item2.add(s2.substring(i,i+1));

        for(int i=0; i<item1.size()-1; i++) {
            for(int j=0; j<item2.size()-1; j++) {
                if (item1.get(i).equals(item2.get(j)) && item1.get(i + 1).equals(item2.get(j + 1))) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
