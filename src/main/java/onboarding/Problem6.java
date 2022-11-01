package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    private static List<String> splitNameInTwoWords(String name){
        List<String> result = new ArrayList<>();
        for(int i=0;i<name.length()-1;i++){
            result.add(name.substring(i, i+2));
        }
        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> totalTwoNames = new HashMap<>();

        for(int i=0;i<forms.size();i++){
            List<String> form = forms.get(i);
            String email = form.get(0);
            String name = form.get(1);

            for(int j = 0; j< name.length()-1; j++){
                String splitName = name.substring(j, j+2);
                if(!totalTwoNames.containsKey(splitName)){
                    totalTwoNames.put(splitName, 0);
                } else{

                    totalTwoNames.put(splitName, totalTwoNames.get(splitName)+1);
                    for(int k=i;k>=0;k--){
                        String previousEmail = forms.get(k).get(0);
                        String previousName = forms.get(k).get(1);
                        if(!answer.contains(previousEmail) && previousName.contains(splitName)){
                            answer.add(previousEmail);
                        }
                    }
                    break;
                }
            }
        }

        System.out.println(totalTwoNames);
        Collections.sort(answer);
        return answer;
    }

    public static void main(String[] args){
        List<List<String>> test1 = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(solution(test1));
        List<List<String>> test2 = List.of(
                List.of("ab@email.com", "에이비"),
                List.of("hi@email.com", "하이"),
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("hello@email.com", "이하이"),
                List.of("copy@email.com", "이하동문"),
                List.of("bb@email.com", "비비")
        );
        System.out.println(solution(test2)); // [copy.com, hello@email.com, hi@email.com]


    }
}
