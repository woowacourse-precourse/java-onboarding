package onboarding;
import org.assertj.core.util.Lists;

import java.util.*;

public class Problem6 {

    public static boolean hasDuplicatedStr(String A, String B){

        for (int i=0; i<A.length()-1; i++){
            if (B.contains(A.substring(i,i+2))){
                return true;
            }
        }
        return false;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();
        for (int i=0; i<forms.size(); i++){
            for (int j=0; j<i; j++){
                if(hasDuplicatedStr(forms.get(i).get(1), forms.get(j).get(1))){
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }
        answer = sortByEmail(answer);
        return answer;
    }
}