package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emails = new HashSet<>();

        final Map<String, String> hashMap = new HashMap<>();



        for (int i = 0; i < forms.size(); i++) {

            String name = forms.get(i).get(1);

            if (name.length() < 2) {
                break;
            }

            for(int j=0; j <name.length()-1; j++){
                String key = name.substring(j,j+2); // 제이,이엠,제이,이슨,워니,엠제,제이,이제,제엠

                if(hashMap.containsKey(key)){
                    String email = hashMap.get(key);

                    if(!email.equals(forms.get(i).get(0))){
                        emails.add(email);
                        emails.add(forms.get(i).get(0));

                    }

                }
                hashMap.put(key,forms.get(i).get(0));



            }




        }
        List<String> answer = emails.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(answer);


        return answer;
    }
}
