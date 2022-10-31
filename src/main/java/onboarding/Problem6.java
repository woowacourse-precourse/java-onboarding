package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer =new ArrayList<String>();
        int index=0;

        for(List<String> next_mem : forms){
            String mem_name=next_mem.get(1);
            //email도메인확인
            //if(!email.endsWith("@email.com"))
            for(int i=index+1; i<forms.size();++i){
                String other_name=forms.get(i).get(1);

                for(int j=0; j<mem_name.length()-2; ++j){
                    String test_name=mem_name.substring(j,j+2);
                    if(other_name.contains(test_name)){

                        String email= next_mem.get(0);
                        String other_email=forms.get(i).get(0);
                        if(!answer.contains(email))
                            answer.add(email);
                        if(!answer.contains(other_email))
                            answer.add(other_email);
                        break;
                    }
                }

            }




            index++;

        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
