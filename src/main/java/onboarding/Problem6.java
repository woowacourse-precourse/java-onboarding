package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
//        List<String> answer = List.of("answer");
//        return answer;

        HashSet<String> emails = new HashSet<>();
        HashMap<String, String> map = new HashMap<>();



        for (int i =0; i < forms.size(); i++){
            String name = forms.get(i).get(1);
            if(name.length() < 2){
                break;
            }
            for (int j =0; j < name.length()-1; j++){
                String common = name.substring(j, j+2);
                if(map.containsKey(common)){
                    String email = map.get(common);
                    if(email != forms.get(i).get(0)){
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }

                }
                map.put(common, forms.get(i).get(0));

            }


        }
        List<String> answer = emails.stream().sorted().collect(Collectors.toList());
        return answer;



    }
}
