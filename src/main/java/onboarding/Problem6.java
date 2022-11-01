
package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < forms.size(); i++){
            for(int j = i + 1; j < forms.size(); j++){
                if(redunCheck(forms.get(i).get(1), forms.get(j).get(1))) {
                    if (!Exist(answer, forms.get(i).get(0)))
                        answer.add(forms.get(i).get(0));
                    if (!Exist(answer, forms.get(j).get(0)))
                        answer.add(forms.get(j).get(0));
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
    public static boolean redunCheck(String first, String second){
        boolean result = false;
        if((first.length() + second.length()) == 2){
            return result;
        }
        if(first.length() > 2)
            for(int i = 0; i < first.length()-1; i++){
                if(second.contains(first.substring(i, i+2))){
                    result = true;
                    break;
                }
            }
        else {
            result = second.contains(first);
        }
        return result;
    }
    public static boolean Exist(List<String>input, String check){
        boolean result = false;
        for(int i = 0; i < input.size(); i++)
            if(check == input.get(i)){
                result = true;
                break;
            }
        return result;
    }
}

