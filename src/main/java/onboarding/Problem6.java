package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < forms.size() ; i++){
            String name =forms.get(i).get(1);
            for(int j = 0 ; j< name.length()-1; j++ ){
                String cutName = name.substring(j,j+2);
                map.put(cutName, map.getOrDefault(cutName, 0) +1);
            }
        }

        for(int i = 0 ; i < forms.size() ; i++){
            String name =forms.get(i).get(1);
            String email = forms.get(i).get(0);
            for(int j = 0 ; j< name.length()-1; j++ ){
                String cutName = name.substring(j,j+2);
                if(map.get(cutName) >=2 ){
                    if(!answer.contains(email)){
                        answer.add(email);
                        break;
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    public static  void main(String args[]) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(solution(forms));
    }
}
