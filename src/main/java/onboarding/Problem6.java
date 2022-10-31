package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<Boolean> checked = new ArrayList<>();

        for(int i = 0; i<forms.size(); i++){
            checked.add(false);
        }

        List<String> answer = new ArrayList<>();

        for(int i = 0; i<forms.size()-1; i++){
            for(int j = i+1; j<forms.size(); j++){
                for(int z = 0; z<forms.get(i).get(1).length()-1; z++){
                    if(forms.get(j).get(1).contains(forms.get(i).get(1).substring(z,z+1))){
                        int index = forms.get(j).get(1).indexOf(forms.get(i).get(1).substring(z,z+1));
                        if(index+2 <=forms.get(j).get(1).length()){
                            if(forms.get(i).get(1).substring(z+1,z+2).equals(forms.get(j).get(1).substring(index+1,index+2))){
                                checked.set(i,true);
                                checked.set(j,true);
                                break;
                            }
                        }
                    }
                }
            }
        }



        // email이 정확한지 확인
        String pattern = "^[A-Za-z0-9]{1,10}\\w+@email.com";

        for(int i = 0; i< forms.size(); i++){
            if(!forms.get(i).get(0).matches(pattern)){
                checked.set(i,true);
            }
        }
        for(int i = 0; i<checked.size(); i++){
            if(checked.get(i)){
                answer.add(forms.get(i).get(0));
            }
        }

        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@naver.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(solution(forms));
    }
}
